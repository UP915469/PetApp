package com.example.petapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author UP915469
 * Database class
 * Lists the classes within entities that contain the information of how each db item is created, version is updated whenever the database schema is updated.
 * Daos are used as the schemas to be used when Room creates the database
 */
@Database(entities = {Pet.class, Food.class}, version = 3)
abstract class AppDatabase extends RoomDatabase {
    public abstract PetDao petDao();
    public abstract FoodDao foodDao();
}