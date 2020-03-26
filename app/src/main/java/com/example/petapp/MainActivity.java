package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView search_pet;
    ArrayAdapter<String> adapter;
    List<String> searchTerms;
    List<Pet> pets;
    List<Food>foods;
    DBHelper dbHelper = new DBHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  @author UP915469
         *  Initialises db for user if its not already by checking if the db contains anything and if not inserting into it using the dbhelper class
         *  @see com.example.petapp.DBHelper for information how this class works*/
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pet-app").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        pets = db.petDao().getAllUsers();
        if(pets.size() == 0){
            List<Pet> insertPet = dbHelper.initialisePets();

            for(Pet p: insertPet){
                db.petDao().insertAll(p);
            }
        }

        foods = db.foodDao().getAllFoods();
        if(foods.size() == 0){
            List<Food> insertFood = dbHelper.initializeFood();
            for(Food f: insertFood){
                db.foodDao().insertAll(f);
            }
        }

        /**
         *  @author UP915469
         *  Adds names and species to the respecitive arrays so they can be queried by onSearchInput method
         *  when the user enters their search term */
        searchTerms = Arrays.asList("cat", "dog", "snake", "gecko", "beagle", "bulldog", "golden retriever", "shiba inu", "dobermann", "siamese", "bengal", "persian", "pug", "cocker spaniel", "ball python",
                "crested gecko");

        search_pet = findViewById(R.id.search_list);

        /**
         *  @author UP915469
         *  Creates an array that takes and adds items from the my_pets items in res/strings.xml,
         *  sets the adapter to use the listview provided in the layout file for main activity using the created array of items
         *  which are pet names/species */
        ArrayList<String> arrayPets = new ArrayList<>();
        arrayPets.addAll(Arrays.asList(getResources().getStringArray(R.array.my_pets)));

        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayPets
        );

        search_pet.setAdapter(adapter);


    }

    /**
     * @author UP915469
     *  Creates the search action, parsing through the created menu file in res/menu giving context to where it will be displayed.
     *  Creates the onQueryListener which handles how user interaction via searching dictates will affect which pet names/species
     *  will be shown in the list as they search, assigning a filter for the text users enter. */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_pets);
        final SearchView searchView = (SearchView)item.getActionView();

        final ListView listView = findViewById(R.id.search_list);
        final ImageView imageView = findViewById(R.id.searchimg);
        final TextView textView = findViewById(R.id.searchinfo);

        int resourceId = this.getResources().getIdentifier("animalplanet","drawable","com.example.petapp");
        imageView.setImageResource(resourceId);
        listView.setVisibility(View.INVISIBLE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String s) {
                String search = s.toLowerCase().trim();
                Boolean toast = false;
                for (String str: searchTerms) {
                    if(str.trim().toLowerCase().equals(search)){
                        toast = false;
                        Intent intent = new Intent(MainActivity.this, PetList.class);
                        intent.putExtra("search_term", s);
                        startActivity(intent);
                        return false;
                    } else{
                        toast = true;
                    }
                }
                if(toast == true){
                    Toast.makeText(MainActivity.this, "Please check spelling", Toast.LENGTH_SHORT).show();
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
