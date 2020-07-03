package com.example.myapplication;

public class ColorModel {
    private String color;
    private String colorName;
    public ColorModel(String color, String colorName){
        this.color=color;
        this.colorName=colorName;
    }
    public String getColor() {
        return color;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
