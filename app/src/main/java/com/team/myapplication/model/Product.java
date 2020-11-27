package com.team.myapplication.model;

import java.util.ArrayList;

/**
 * Created by Amit on 25,November,2020
 */
public class Product {

    private int mainImage;
    private ArrayList<String> sizeArrayList;
    private ArrayList<Example> exampleArrayList;

    public Product(int mainImage, ArrayList<String> sizeArrayList, ArrayList<Example> exampleArrayList) {
        this.mainImage = mainImage;
        this.sizeArrayList = sizeArrayList;
        this.exampleArrayList = exampleArrayList;
    }

    public Product() {
    }

    public int getMainImage() {
        return mainImage;
    }

    public void setMainImage(int mainImage) {
        this.mainImage = mainImage;
    }

    public ArrayList<String> getSizeArrayList() {
        return sizeArrayList;
    }

    public void setSizeArrayList(ArrayList<String> sizeArrayList) {
        this.sizeArrayList = sizeArrayList;
    }

    public ArrayList<Example> getExampleArrayList() {
        return exampleArrayList;
    }

    public void setExampleArrayList(ArrayList<Example> exampleArrayList) {
        this.exampleArrayList = exampleArrayList;
    }
}
