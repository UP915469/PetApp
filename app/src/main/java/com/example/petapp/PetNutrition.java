package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


public class PetNutrition extends AppCompatActivity {
    List<Food> foods;
    boolean permission = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_nutrition);
        getSupportActionBar().hide();

        /**
         * @author UP915469
         * Gets food id parsed to this activity from PetDetails screen, uses those to query db for correct food items.
         */

        Intent mIntent = getIntent();

        int foodId1 =  mIntent.getIntExtra("foodId1", 0);
        int foodId2 =  mIntent.getIntExtra("foodId2", 0);
        int foodId3 =  mIntent.getIntExtra("foodId3", 0);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pet-app").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        foods = db.foodDao().getAllFoods();
        int[] foodIds = {foodId1, foodId2, foodId3};
        foods = db.foodDao().getFoodById(foodIds);

        ImageView foodImg1 = findViewById(R.id.food_img_1);
        ImageView foodImg2 = findViewById(R.id.food_img_2);
        ImageView foodImg3 = findViewById(R.id.food_img_3);
        TextView foodName1 = findViewById(R.id.food_name_1);
        TextView foodName2 = findViewById(R.id.food_name_2);
        TextView foodName3 = findViewById(R.id.food_name_3);
        TextView nutritionComments = findViewById(R.id.nutrition_comments);

        if(foods.size() != 0){
            int resourceId1 = this.getResources().getIdentifier(foods.get(0).getFoodImg(),"drawable","com.example.petapp");
            int resourceId2 = this.getResources().getIdentifier(foods.get(1).getFoodImg(),"drawable","com.example.petapp");
            int resourceId3 = this.getResources().getIdentifier(foods.get(2).getFoodImg(),"drawable","com.example.petapp");
            foodImg1.setImageResource(resourceId1);
            foodImg2.setImageResource(resourceId2);
            foodImg3.setImageResource(resourceId3);

            foodName1.setText(foods.get(0).getFoodName());
            foodName3.setText(foods.get(1).getFoodName());
            foodName2.setText(foods.get(2).getFoodName());

            String nutritionCommment = foods.get(0).getNutritionComment() + "\n\n" +
                    foods.get(1).getNutritionComment() + "\n\n" +
                    foods.get(2).getNutritionComment();
            nutritionComments.setText(nutritionCommment);
        }



        /* Creates list of imageviews and iterates over them adding the onclick along with the loop count
        so it can get the correct num to use with the get function. Then creates the store locator intent parsing in the stores from that */
        ImageView[] imgViews = {foodImg1, foodImg2, foodImg3};

        for (int i = 0; i < imgViews.length; i++) {
            final int finalI = i;
            imgViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(PetNutrition.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

                    if(permission == true){
                        Intent intent = new Intent(PetNutrition.this, StoreLocator.class);
                        intent.putExtra("store_1", foods.get(finalI).getStore1());
                        intent.putExtra("store_2", foods.get(finalI).getStore2());
                        intent.putExtra("store_3", foods.get(finalI).getStore3());

                        startActivity(intent);
                    }

                }
            });
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        permission = true;
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
