package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
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
        getSupportActionBar().hide();

        Intent mIntent = getIntent();
        String searchTerm = mIntent.getStringExtra("search_term");

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pet-app").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        recyclerView = findViewById(R.id.recycler_view);

        pets = db.petDao().findByNameOrSpecies(searchTerm);

        /**
         *  if only 1 pet is returned from the users search on homescreen then onPetClick is automatically called
         *  sending the user to the petdetails pet with that specifics pets information
         *  @author UP915469
         */
        if(pets.size() == 1){
            onPetClick(0);
            PetList.this.finishActivity(0);
        }

        /**
         *  Standard way of intialising the recycler view list and setting the adapter to be used with the functionality the list will contain.
         *  Information related to this contained with the official developer android documentation.
         *  @author UP915469
         */
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PetAdapter(pets, this, this);
        recyclerView.setAdapter(adapter);
    }

    /**
     *  @author UP915469
     * @param position gets the clicked items position in the list and uses that integer to search the arraylist for that specific clicked pets id. That id is then parsed to the petdetails page to be used to search the database.
     */
    @Override
    public void onPetClick(int position) {
        int petId = pets.get(position).getId();

        Intent intent = new Intent(PetList.this, PetDetails.class);
        intent.putExtra("pet_id", petId);

        startActivity(intent);
    }
}
