package com.example.petapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Food {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "food_name")
    private String foodName;

    @ColumnInfo(name = "food_img")
    private String foodImg;

    @ColumnInfo(name = "store1")
    private String store1;

    @ColumnInfo(name = "store2")
    private String store2;

    @ColumnInfo(name = "store3")
    private String store3;

    @ColumnInfo(name = "nutrition")
    private String nutritionComment;

    public Food(String foodName, String foodImg, String store1, String store2, String store3, String nutritionComment){
       this.foodName = foodName;
       this.foodImg = foodImg;
        this.store1 = store1;
        this.store2 =  store2;
        this.store3 = store3;
        this.nutritionComment = nutritionComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public String getStore1() {
        return store1;
    }

    public void setStore1(String store1) {
        this.store1 = store1;
    }

    public String getStore2() {
        return store2;
    }

    public void setStore2(String store2) {
        this.store2 = store2;
    }

    public String getStore3() {
        return store3;
    }

    public void setStore3(String store3) {
        this.store3 = store3;
    }

    public String getNutritionComment() {
        return nutritionComment;
    }

    public void setNutritionComment(String nutritionComment) {
        this.nutritionComment = nutritionComment;
    }
}
