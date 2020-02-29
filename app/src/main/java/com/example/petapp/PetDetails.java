package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PetDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        System.out.println("screen reached");
        Intent mIntent = getIntent();
        int petId = mIntent.getIntExtra("pet_id", 0);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pet-app").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        List<Pet> pet = db.petDao().findById(petId);

        ImageView petImg = findViewById(R.id.pet_img);
        TextView petName = findViewById(R.id.pet_name);
        TextView careComment1 = findViewById(R.id.care_comment_1);

        int resourceId = this.getResources().getIdentifier(pet.get(0).getImgPath(),"drawable","com.example.petapp");
        petImg.setImageResource(resourceId);
        petName.setText(pet.get(0).getName());
        careComment1.setText(pet.get(0).getCareComment1());
    }
}
