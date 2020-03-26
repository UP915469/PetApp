package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PetDetails extends AppCompatActivity {
    Button nutritionBtn;
    Integer foodId1;
    Integer foodId2;
    Integer foodId3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);
        getSupportActionBar().hide();

        Intent mIntent = getIntent();

        /**
         * @author UP915469
         * Gets the id parsed into this screen from previous MainActivity/PetList screens and uses that id to search for a specific pet from the db.
         */
        int petId = mIntent.getIntExtra("pet_id", 0);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pet-app").allowMainThreadQueries().fallbackToDestructiveMigration().build();



        List<Pet> pet = db.petDao().findById(petId);


        /**
         *  @author UP915469
         * Sets the image and text views in the pet details screen to equal the content returned from accesing that specific queried pets get methods. */
        ImageView petImg = findViewById(R.id.pet_img);
        TextView petName = findViewById(R.id.pet_name);
        TextView petSpecies = findViewById(R.id.pet_species);
        TextView petAge = findViewById(R.id.pet_age);
        TextView petWeight = findViewById(R.id.pet_weight);
        TextView careComment1 = findViewById(R.id.care_comment_1);
        TextView careComment2 = findViewById(R.id.care_comment_2);
        TextView careComment3 = findViewById(R.id.care_comment_3);

        if(pet.size() != 0){
            int resourceId = this.getResources().getIdentifier(pet.get(0).getImgPath(),"drawable","com.example.petapp");
            petImg.setImageResource(resourceId);
            petName.setText(pet.get(0).getName());
            petSpecies.setText(pet.get(0).getSpecies());
            petAge.setText(pet.get(0).getAvgAge());
            petWeight.setText(pet.get(0).getAvgWeight());
            careComment1.setText(pet.get(0).getCareComment1());
            careComment2.setText(pet.get(0).getCareComment2());
            careComment3.setText(pet.get(0).getCareComment3());

            foodId1 = pet.get(0).getFood1Id();
            foodId2 = pet.get(0).getFood2Id();
            foodId3 = pet.get(0).getFood3Id();
        }


        /**
         *  @author UP915469
         *  Sets the button in pet details screen to have an onclick moving user to nutrition screen, parsing in the food ids to search nutrition table for.
         */
        nutritionBtn = findViewById(R.id.nutrition_btn);

        nutritionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PetDetails.this, PetNutrition.class);
                intent.putExtra("foodId1", foodId1);
                intent.putExtra("foodId2", foodId2);
                intent.putExtra("foodId3", foodId3);
                startActivity(intent);
            }
        });
    }
}
