package com.tylerdarby.charactersheet.models;

/**
 * Created by tdarby on 10/2/17.
 */

public class InventoryItem {
    private String description;
    private String name;
    private int amount;

    public InventoryItem(String description, String name, int amount) {
        this.description = description;
        this.name = name;
        this.amount = amount;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
