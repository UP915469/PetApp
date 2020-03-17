package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PetList extends AppCompatActivity implements PetAdapter.OnSelectListener {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        Intent mIntent = getIntent();
        String searchTerm = mIntent.getStringExtra("search_term");

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pet-app").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        recyclerView = findViewById(R.id.recycler_view);

        pets = db.petDao().getAllUsers();
        for(Pet p : pets){
            db.petDao().delete(p);
        }

        db.petDao().insertAll(new Pet("Beagle", "Dog", "beagle", "6 years old", "20pounds", "handle with care"
        , "2nd care comment", "final care comment", 1, 2,3),
                new Pet("Tabby Cat", "Cat", "tabbycat", "8 years old", "10pounds", "handle with care"
                        , "2nd care comment", "final care comment", 1, 2,3),
                new Pet("Puppy", "Dog", "tabbycat", "8 years old", "10pounds", "handle with care"
                        , "2nd care comment", "final care comment", 1, 2,3),
                new Pet("Kitty", "Cat", "tabbycat", "8 years old", "10pounds", "handle with care"
                , "2nd care comment", "final care comment", 1, 2,3));

        pets = db.petDao().findByNameOrSpecies(searchTerm);

        if(pets.size() == 1){
            onPetClick(0);
            PetList.this.finishActivity(0);
        }

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PetAdapter(pets, this, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPetClick(int position) {
        int petId = pets.get(position).getId();

        Intent intent = new Intent(PetList.this, PetDetails.class);
        intent.putExtra("pet_id", petId);

        startActivity(intent);
    }
}
