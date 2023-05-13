package com.example.additem;


import android.graphics.Bitmap;

public class ItemModel {


    private String name;
    private int id;
    private String sportType;
    private String location;
    private int price;

   private String imageName;
   private Bitmap image;



    //constructor
    public ItemModel(String name,int id, String sportType, String location, int price,String imageName,Bitmap image) {
        this.name = name;
        this.id=id;
        this.sportType = sportType;
        this.location = location;
        this.price = price;
        this.imageName=imageName;
        this.image=image;


    }
//non parametric constructor
    public ItemModel() {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sportType='" + sportType + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                '}';
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}



