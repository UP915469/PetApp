package com.example.petapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * @author UP915469
 * Contains the queries used to search the database or methods to be used on the database.
 * Queries are converted to functions to be called on lists of that items class.
 * Follows Room db notation.
 */
@Dao
public interface PetDao {
    @Query("SELECT * FROM pet")
    List<Pet> getAllUsers();
    @Query("SELECT * FROM pet WHERE name LIKE :arg0 OR species LIKE :arg0")
    List<Pet> findByNameOrSpecies(String arg0);
    @Query("SELECT * FROM pet WHERE id IS :arg0")
    List<Pet> findById(Integer arg0);
    @Insert
    void insertAll(Pet... pet);

    @Delete
    void delete(Pet pet);
}
