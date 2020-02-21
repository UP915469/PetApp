package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PetList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        recyclerView = findViewById(R.id.recycler_view);

        pets = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            Pet pet = new Pet("Beagle " + i, "Dog", "@drawable/beagle.jpg",
                    "10 years", "40pounds", "c1", "c2",
                    "c3", 1, 2, 3);
            pets.add(pet);
        }

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PetAdapter(pets);
        recyclerView.setAdapter(adapter);
    }
}
