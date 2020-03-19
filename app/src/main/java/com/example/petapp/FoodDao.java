package com.example.petapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * @author UP915469
 * @see com.example.petapp.PetDao for explanation of class purpose.
 */
@Dao
public interface FoodDao {
    @Query("SELECT * FROM food")
    List<Food> getAllFoods();
    @Query("SELECT * FROM food WHERE id IN (:arg0)")
    List<Food> getFoodById(int[] arg0);

    @Insert
    void insertAll(Food... food);

    @Delete
    void delete(Food food);
}
