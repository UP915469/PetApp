package com.example.petapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pet {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "species")
    private String species;

    @ColumnInfo(name = "img_path")
    private String imgPath;

    // Care Details

    @ColumnInfo(name = "avg_age")
    private String avgAge;

    @ColumnInfo(name = "avg_weight")
    private String avgWeight;

    @ColumnInfo(name = "care_comment_1")
    private String careComment1;

    @ColumnInfo(name = "care_comment_2")
    private String careComment2;

    @ColumnInfo(name = "care_comment_3")
    private String careComment3;

    //Nutrition link

    @ColumnInfo(name = "food_id_1")
    private int food1Id;

    @ColumnInfo(name = "food_id_2")
    private int food2Id;

    @ColumnInfo(name = "food_id_3")
    private int food3Id;

    //Pet Constructor
    public Pet(String name, String species, String imgPath, String avgAge, String avgWeight, String careComment1, String careComment2, String careComment3, int food1Id, int food2Id, int food3Id ){
        this.name = name;
        this.species = species;
        this.imgPath = imgPath;
        this.avgAge = avgAge;
        this.avgWeight = avgWeight;
        this.careComment1 = careComment1;
        this.careComment2 = careComment2;
        this.careComment3 = careComment3;
        this.food1Id = food1Id;
        this.food2Id = food2Id;
        this.food3Id = food3Id;
    }

    // getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getAvgAge() {
        return avgAge;
    }

    public void setAvgAge(String avgAge) {
        this.avgAge = avgAge;
    }

    public String getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(String avgWeight) {
        this.avgWeight = avgWeight;
    }

    public String getCareComment1() {
        return careComment1;
    }

    public void setCareComment1(String careComment1) {
        this.careComment1 = careComment1;
    }

    public String getCareComment2() {
        return careComment2;
    }

    public void setCareComment2(String careComment2) {
        this.careComment2 = careComment2;
    }

    public String getCareComment3() {
        return careComment3;
    }

    public void setCareComment3(String careComment3) {
        this.careComment3 = careComment3;
    }

    public int getFood1Id() {
        return food1Id;
    }

    public void setFood1Id(int food1Id) {
        this.food1Id = food1Id;
    }

    public int getFood2Id() {
        return food2Id;
    }

    public void setFood2Id(int food2Id) {
        this.food2Id = food2Id;
    }

    public int getFood3Id() {
        return food3Id;
    }

    public void setFood3Id(int food3Id) {
        this.food3Id = food3Id;
    }
}
