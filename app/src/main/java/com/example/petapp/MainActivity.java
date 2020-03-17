package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView search_pet;
    ArrayAdapter<String> adapter;
    List<String> searchTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Adds names and species to the respecitive arrays so they can be queried by onSearchInput method
        when the user enters their search term */
        searchTerms = Arrays.asList("Cat", "Dog", "Beagle", "Tabby Cat", "Kitty", "Puppy");

        search_pet = findViewById(R.id.search_list);

        /* Creates an array that takes and adds items from the my_pets items in res/strings.xml,
        sets the adapter to use the listview provided in the layout file for main activity using the created array of items
        which are pet names/species */
        ArrayList<String> arrayPets = new ArrayList<>();
        arrayPets.addAll(Arrays.asList(getResources().getStringArray(R.array.my_pets)));

        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayPets
        );

        search_pet.setAdapter(adapter);
    }

    /* Creates the search action, parsing through the created menu file in res/menu giving context to where it will be
    displayed. Creates the onQueryListener which handles how user interaction via searching dictates will affect which pet names/species
    will be shown in the list as they search, assigning a filter for the text users enter. */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_pets);
        SearchView searchView = (SearchView)item.getActionView();

        final ListView listView = findViewById(R.id.search_list);
        final ImageView imageView = findViewById(R.id.searchimg);
        final TextView textView = findViewById(R.id.searchinfo);

        int resourceId = this.getResources().getIdentifier("animalplanet","drawable","com.example.petapp");
        imageView.setImageResource(resourceId);
        listView.setVisibility(View.INVISIBLE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String s) {
                String search = s.toLowerCase();

                for (String str: searchTerms) {
                    if(str.trim().toLowerCase().contains(search)){
                        Intent intent = new Intent(MainActivity.this, PetList.class);
                        intent.putExtra("search_term", s);
                        startActivity(intent);
                        return false;
                    } else {
                        Toast.makeText(MainActivity.this, "Please check spelling or spaces", Toast.LENGTH_SHORT).show();
                    }
                }
                
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s.isEmpty()){
                    listView.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    return false;
                } else{
                    listView.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                    adapter.getFilter().filter(s);
                    return false;
                }
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
