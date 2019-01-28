package com.epam.menu.dao.util;

import java.io.IOException;

public enum MenuTagName {
NAME, PRICE, DESCRIPTION, IMAGE, FOOD, PORTION, MENU, INGRIDIENTS, INGRIDIENT, OPTIONS;

    public static MenuTagName getElementTagName (String element)throws IOException{

    switch (element){
        case "menu":
            return MENU;
        case "food":
            return FOOD;
        case "name":
            return NAME;
        case "description":
            return DESCRIPTION;
        case "price":
            return PRICE;
        case "image":
            return IMAGE;
        case "portion":
            return PORTION;
        case "ingridients":
            return INGRIDIENTS;
        case "ingridient":
            return INGRIDIENT;
        case "options":
            return OPTIONS;

            default: throw new IOException();
    }

}
}
