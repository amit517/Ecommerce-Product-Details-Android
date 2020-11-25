package com.team.myapplication.model;

/**
 * Created by Amit on 25,November,2020
 */
public class Example {
    private int frontImg;
    private int backImg;

    public Example(int frontImg, int backImg) {
        this.frontImg = frontImg;
        this.backImg = backImg;
    }

    public int getFrontImg() {
        return frontImg;
    }

    public void setFrontImg(int frontImg) {
        this.frontImg = frontImg;
    }

    public int getBackImg() {
        return backImg;
    }

    public void setBackImg(int backImg) {
        this.backImg = backImg;
    }
}
