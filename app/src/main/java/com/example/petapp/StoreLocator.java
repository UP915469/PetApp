package com.example.petapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author UP91469
 * Manageses the maps view as well how the markers are placed within it.
 */
public class StoreLocator extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient mfusedLocationProviderClient;
    private PlacesClient placesClient;
    private List<AutocompletePrediction> predictionList;
    private Intent mIntent = getIntent();
    private Location mLastKnownLocation;
    private LocationCallback locationCallback;
    String store1;
    String store2;
    String store3;

    final float DEFAULT_ZOOM = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_locator);
        getSupportActionBar().hide();

        /**
         * gets the store names parsed from nutrition screen to call latLng function with.
         * @author UP91469
         */
        Intent mIntent = getIntent();
        store1 = mIntent.getStringExtra("store_1");
        store2 = mIntent.getStringExtra("store_2");
        store3 = mIntent.getStringExtra("store_3");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mfusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(StoreLocator.this);
        Places.initialize(StoreLocator.this, "AIzaSyC1RjtsraF6NUsXBuvTAIPMIUG446503es");
        placesClient = Places.createClient(this);
        AutocompleteSessionToken token = AutocompleteSessionToken.newInstance();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        //Check if GPS is enabled and if not request user enable it
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);

        SettingsClient settingsClient = LocationServices.getSettingsClient(StoreLocator.this);
        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());

        task.addOnSuccessListener(StoreLocator.this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                getDeviceLocation();


            }
        });

        task.addOnFailureListener(StoreLocator.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(e instanceof ResolvableApiException){
                    ResolvableApiException resolvable = (ResolvableApiException) e;
                    try {
                        resolvable.startResolutionForResult(StoreLocator.this, 36);
                    } catch (IntentSender.SendIntentException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        LatLng latLng1 = getLatLng(store1);
        LatLng latLng2 = getLatLng(store2);
        LatLng latLng3 = getLatLng(store3);
        MarkerOptions options1 = new MarkerOptions().position(latLng1).title(store1);
        mMap.addMarker(options1);
        MarkerOptions options2 = new MarkerOptions().position(latLng2).title(store2);
        mMap.addMarker(options2);
        MarkerOptions options3 = new MarkerOptions().position(latLng3).title(store3);
        mMap.addMarker(options3);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 36){
            if(resultCode == RESULT_OK){
                getDeviceLocation();
            }
        }
    }

    /**
     * Function that gets users current location for use by the map
     * Requests user give permission for location before use and notifies them to turn on location if it isn't already.
     * Update maps camera to the location using the zoom variable created.
     * @author UP91469
     */
    private void getDeviceLocation() {
        mfusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            mLastKnownLocation = task.getResult();
                            if(mLastKnownLocation != null){
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(),
                                        mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                            } else {
                                final LocationRequest locationRequest = LocationRequest.create();
                                locationRequest.setInterval(10000);
                                locationRequest.setFastestInterval(5000);
                                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                                locationCallback = new LocationCallback(){
                                    @Override
                                    public void onLocationResult(LocationResult locationResult) {
                                        super.onLocationResult(locationResult);
                                        if(locationResult == null){
                                            return;
                                        }
                                        mLastKnownLocation = locationResult.getLastLocation();
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(),
                                                mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                                    }
                                };
                                mfusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
                                mfusedLocationProviderClient.removeLocationUpdates(locationCallback);
                            }
                        } else {
                            Toast.makeText(StoreLocator.this, "unable to find current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * @author UP91469
     * @param store this function takes a store variable obtained from this intent. Store variables are parsed to this intent from pet nutrition screen.
     * @return this returns a LatLng object specifying the coordinates of the store variable used.
     */
    public LatLng getLatLng(String store){
        LatLng latLng = new LatLng(0,0);

        switch (store){
            case "Tesco":
                latLng = new LatLng(50.800782,-1.087534);
                break;
            case "Pets at Home":
                latLng = new LatLng(50.815809,-1.054626);
                break;
            case "Morrisons":
                latLng = new LatLng(50.806650,-1.088980);
                break;
            case "Sainsburys":
                latLng = new LatLng(50.804260,-1.087230);
                break;
            default:
                break;
        }
        return latLng;
    }

}
