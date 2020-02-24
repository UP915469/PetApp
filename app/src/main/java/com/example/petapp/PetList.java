package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PetList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pet-app").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        recyclerView = findViewById(R.id.recycler_view);


            db.petDao().insertAll( new Pet("Beagle ", "Dog", "beagle",
                    "10 years", "40pounds", "c1", "c2",
                    "c3", 1, 2, 3));
            db.petDao().insertAll( new Pet("Tabby Cat", "Cat", "tabbycat",
                    "10 years", "20pounds", "c1", "c2",
                    "c3", 1, 2, 3));

        List<Pet> pets = db.petDao().findBySpecies("Cat");

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PetAdapter(pets, this);
        recyclerView.setAdapter(adapter);
    }
}
