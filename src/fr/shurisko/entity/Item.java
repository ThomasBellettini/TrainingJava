package fr.shurisko.entity;

import fr.shurisko.ShopDisplay;

public class Item {

    public int ID;
    private String name;
    private String description;
    private double price;

    public Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.ID = ShopDisplay.getInstance.itemList.size();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
