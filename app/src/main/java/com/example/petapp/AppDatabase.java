package com.example.petapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pet.class}, version = 2)
abstract class AppDatabase extends RoomDatabase {
    public abstract PetDao petDao();
}