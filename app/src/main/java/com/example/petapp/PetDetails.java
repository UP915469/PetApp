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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        Intent mIntent = getIntent();

        //Gets the id parsed into this screen from previous MainActivity/PetList screens and uses that id to search for a specific pet from the db.
        int petId = mIntent.getIntExtra("pet_id", 0);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pet-app").allowMainThreadQueries().fallbackToDestructiveMigration().build();



        List<Pet> pet = db.petDao().findById(petId);


        //Sets the image and text views in the pet details screen to equal the content returned from accesing that specific queried pets get methods.
        ImageView petImg = findViewById(R.id.pet_img);
        TextView petName = findViewById(R.id.pet_name);
        TextView petSpecies = findViewById(R.id.pet_species);
        TextView careComment1 = findViewById(R.id.care_comment_1);
        TextView careComment2 = findViewById(R.id.care_comment_2);
        TextView careComment3 = findViewById(R.id.care_comment_3);

        int resourceId = this.getResources().getIdentifier(pet.get(0).getImgPath(),"drawable","com.example.petapp");
        petImg.setImageResource(resourceId);
        petName.setText(pet.get(0).getName());
        petSpecies.setText(pet.get(0).getSpecies());
        careComment1.setText(pet.get(0).getCareComment1());
        careComment2.setText(pet.get(0).getCareComment2());
        careComment3.setText(pet.get(0).getCareComment3());

        final Integer foodId1 = pet.get(0).getFood1Id();
        final Integer foodId2 = pet.get(0).getFood2Id();
        final Integer foodId3 = pet.get(0).getFood3Id();
        //Sets the button in pet details screen to have an onclick moving user to nutrition screen, parsing in the food ids to search nutrition table for.

        Button nutritionBtn = findViewById(R.id.nutrition_btn);

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
