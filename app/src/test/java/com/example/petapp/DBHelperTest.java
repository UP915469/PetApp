package com.example.petapp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

// Tests whether the dbhelper class function correctly intialises a list for use by room db insert function by asserting if it contains objects.
public class DBHelperTest {
    DBHelper dbHelper = new DBHelper();
    List<Pet> pets = new ArrayList<>();
    List<Food> foods = new ArrayList<>();

    @Test
    public void testDBHelperPets(){
        pets = dbHelper.initialisePets();
        boolean petsExist = false;

        if(pets.size() > 0){
            petsExist = true;
        }
        assertEquals(petsExist, true);
    }

    @Test
    public void testDBHelperFood(){
        foods = dbHelper.initializeFood();
        boolean foodExist = false;

        if(foods.size() > 0){
            foodExist = true;
        }
        assertEquals(foodExist, true);
    }
}