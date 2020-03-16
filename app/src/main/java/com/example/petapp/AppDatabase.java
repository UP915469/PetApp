package com.example.petapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pet.class, Food.class}, version = 3)
abstract class AppDatabase extends RoomDatabase {
    public abstract PetDao petDao();
    public abstract FoodDao foodDao();
}