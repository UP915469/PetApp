package com.example.petapp;

public class Pet {
    private int id;

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

    private String name;
    private String species;
    private String imgPath;

    // Care Details
    private String avgAge;
    private String avgWeight;
    private String careComment1;
    private String careComment2;
    private String careComment3;

    //Nutrition link
    private int food1Id;
    private int food2Id;
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
}
