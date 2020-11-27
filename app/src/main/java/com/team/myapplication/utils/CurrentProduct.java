package com.team.myapplication.utils;

import com.team.myapplication.model.Product;

public class CurrentProduct {

    public static Product subProduct = new Product();

    public static Product getCurrentProduct() {
        return subProduct;
    }

    public static void setCurrentProduct(Product subProduct) {
        CurrentProduct.subProduct = subProduct;
    }

}
