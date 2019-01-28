package com.epam.menu.dao.util;

import com.epam.menu.entity.Food;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxHandler {
    List<Food> foodList=new ArrayList<>();


    public List<Food> getFoodList(XMLStreamReader reader) throws Exception{

        Food food=null;
        MenuTagName elementName=null;

        while (reader.hasNext()){
            int type=reader.next();

            switch (type){
                case XMLStreamConstants
                        .START_ELEMENT:
                    elementName=MenuTagName.getElementTagName(reader.getLocalName());
                switch (elementName){
                    case FOOD:
                        food=new Food();
                        food.setId(Integer.parseInt(reader.getAttributeValue(null,"id")));
                        food.setType(reader.getAttributeValue(null,"type"));
                        break;
                    case PRICE:
                        if (reader.getAttributeCount()>1){
                            food.getOptions().put("-"+reader.getAttributeValue(null,"option"),"-"+
                                    reader.getAttributeValue(null,"value"));
                        }else {
                            food.getOptions().put("",reader.getAttributeValue(null,"value"));
                        }
                }
                break;

                case XMLStreamConstants.CHARACTERS:
                    String text=reader.getText().trim();
                    if (text.isEmpty()){
                        break;
                    }
                    switch (elementName){
                        case NAME:
                            food.setName(text);
                            break;
                        case IMAGE:
                            food.setImage(text);
                            break;
                        case PORTION:
                            food.setPortion(text);
                            break;
                        case DESCRIPTION:
                            food.setDescription(text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName=MenuTagName.getElementTagName(reader.getLocalName());
                    if (elementName==MenuTagName.FOOD){
                        foodList.add(food);
                    }
                    break;
            }
        }
        return foodList;
    }

}
