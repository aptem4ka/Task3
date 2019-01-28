package com.epam.menu.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Food {
    private String type;
    private int id;
    private String name;
    private String description;
    private String portion;
    private String image;
    private Map<String, String> options=new HashMap<>();

    public Food() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals("cold_snack"))
        this.type = "Холодные закуски";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id &&
                type.equals(food.type) &&
                name.equals(food.name) &&
                description.equals(food.description) &&
                portion.equals(food.portion) &&
                image.equals(food.image) &&
                options.equals(food.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, name, description, portion, image, options);
    }

    @Override
    public String toString() {
        return "Food{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", portion='" + portion + '\'' +
                ", image='" + image + '\'' +
                ", options=" + options +
                '}';
    }
}
