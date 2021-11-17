package com.example.hf7;

import java.util.ArrayList;

public class Animal {
    private String name;
    private String description;
    private int imageID;
    private String content;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageID() {
        return imageID;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Animal(String name, String description, int imageID, String content) {
        this.name = name;
        this.description = description;
        this.imageID = imageID;
        this.content = content;
    }
    public static ArrayList<Animal> getAnimals(){
        ArrayList<Animal> allatok = new ArrayList<>();
        allatok.add(new Animal("Macska","macskas",R.drawable.cat,"Mese a macskarol"));
        allatok.add(new Animal("Kutya","kutyas",R.drawable.dog,"Mese a kutyarol"));
        allatok.add(new Animal("Zsiraf","Magas",R.drawable.giraffe,"Mese a zsirafrol"));
        allatok.add(new Animal("Polip","Olelkezos",R.drawable.octopus,"Mese a poliprol"));        allatok.add(new Animal("Barany","Gyapjas",R.drawable.sheep,"Kellemes Husveti Unnepeket"));
        allatok.add(new Animal("Lo","Nyiha.Ha!",R.drawable.horse,"Mese a Lorol"));
        allatok.add(new Animal("Oroszlan","Roar.",R.drawable.lion,"Mese az orosz lanyrol."));
        return allatok;

    }

    public int getThumbnailDrawable() {
        return imageID;
    }
}
