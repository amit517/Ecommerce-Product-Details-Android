package com.team.myapplication;

import com.team.myapplication.model.Example;
import com.team.myapplication.model.Product;

import java.util.ArrayList;

/**
 * Created by Amit on 25,November,2020
 */
public class GiveMeProduct {

    public static ArrayList<Product> getProduct(){

        ArrayList<Product> productArrayList = new ArrayList<>();
        ArrayList<String> sizeArray = new ArrayList<>();
        ArrayList<Example> exampleArrayList = new ArrayList<>();
        sizeArray.add("S");
        sizeArray.add("M");
        sizeArray.add("X");
        sizeArray.add("XL");

        exampleArrayList.add(new Example(R.drawable.product_image,R.drawable.back));
        exampleArrayList.add(new Example(R.drawable.font1,R.drawable.back));
        exampleArrayList.add(new Example(R.drawable.product_image,R.drawable.back));
        exampleArrayList.add(new Example(R.drawable.font1,R.drawable.back));
        exampleArrayList.add(new Example(R.drawable.product_image,R.drawable.back));
        exampleArrayList.add(new Example(R.drawable.font1,R.drawable.back));


        productArrayList.add(new Product(R.drawable.main_image,sizeArray,exampleArrayList));
        productArrayList.add(new Product(R.drawable.main_image,sizeArray,exampleArrayList));
        productArrayList.add(new Product(R.drawable.main_image,sizeArray,exampleArrayList));
        productArrayList.add(new Product(R.drawable.main_image,sizeArray,exampleArrayList));
        productArrayList.add(new Product(R.drawable.main_image,sizeArray,exampleArrayList));


        return productArrayList;

    }

}
