package com.team.myapplication.utils;

import com.team.myapplication.R;
import com.team.myapplication.model.DrawerItem;
import com.team.myapplication.model.Example;
import com.team.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Amit on 25,November,2020
 */
public class Constant {

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

    public static String[] getShippingName(){
        String[] shippingName = { "zDrop Premium Shipping", "Pathao Shipping", "RedeX" };
        return shippingName;
    }

    public static String[] getCost(){
        String[] cost = { "Cost: BDT. 4000", "Cost: BDT. 4000", "Cost: BDT. 4000" };
        return cost;
    }

    public static final List<DrawerItem> getDraware(){
        List<DrawerItem> dataList = new ArrayList<>();

        dataList.add(new DrawerItem("Specifications", R.drawable.ic_specification));
        dataList.add(new DrawerItem("Reviews", R.drawable.ic_review));
        dataList.add(new DrawerItem("How to Order", R.drawable.ic_how_to_order));
        dataList.add(new DrawerItem("FAQ", R.drawable.ic_faq));
        dataList.add(new DrawerItem("Wholesale Inquiry", R.drawable.ic_wholsel));
        dataList.add(new DrawerItem("Descriptions", R.drawable.ic_description));
        return dataList;

    }

}
