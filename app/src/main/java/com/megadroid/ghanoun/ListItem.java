package com.megadroid.ghanoun;

public class ListItem {

    private String head;
    private String description;
    private String shortDescription;

    public String getShortDescription() {
        return shortDescription;
    }

    public ListItem(String head, String description) {
        this.head = head;
        this.description = description;
    }

    public ListItem(String shortDescription) {
        this.shortDescription =shortDescription;
    }


    public String getHead() {
        return head;
    }

    public String getDescription() {
        return description;
    }
}