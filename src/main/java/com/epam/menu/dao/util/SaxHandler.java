package com.epam.menu.dao.util;

import com.epam.menu.entity.Food;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {
    private List<Food> foodList = new ArrayList<Food>();
    private Food food;
    private StringBuilder text;

    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        text = new StringBuilder();
        if (localName.equals("food")) {
            food = new Food();
            food.setId(Integer.parseInt(attributes.getValue("id")));
            food.setType(attributes.getValue("type"));
        }
        if (localName.equals("price")) {
            if (attributes.getLength() == 1) {
                food.getOptions().put("", attributes.getValue("value"));
            } else {
                food.getOptions().put("-"+attributes.getValue("option"), "-"+attributes.getValue("value"));
            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (localName.equals("name")) {
            food.setName(text.toString());
        }
        if (localName.equals("description")) {
            food.setDescription(text.toString());
        }
        if (localName.equals("portion")) {
            food.setPortion(text.toString());
        }
        if (localName.equals("image")) {
        //  String imgSource=this.getClass().getClassLoader().getResource(text.toString()).getPath();
           food.setImage(text.toString());
        }
        if (localName.equals("food")) {
            foodList.add(food);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }
}
