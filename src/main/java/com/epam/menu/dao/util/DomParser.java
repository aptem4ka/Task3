package com.epam.menu.dao.util;

import com.epam.menu.entity.Food;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomParser {
    List<Food> foodList=new ArrayList<>();

    public List<Food> getFoodList(HttpServletRequest request) throws Exception{
        String dataSource=this.getClass().getClassLoader().getResource("menu.xml").getPath();
        DOMParser domParser=new DOMParser();
        domParser.parse(dataSource);

        Document document=domParser.getDocument();

        Element root=document.getDocumentElement();

        NodeList foodNodes=root.getElementsByTagName("food");
        Food food=null;

        for (int i=0; i<foodNodes.getLength();i++){
            food=new Food();
            Element foodElement=(Element)foodNodes.item(i);

            food.setId(Integer.parseInt(foodElement.getAttribute("id")));
            food.setType(foodElement.getAttribute("type"));
            food.setImage(getSingleChild(foodElement,"image").getTextContent());
            food.setName(getSingleChild(foodElement,"name").getTextContent());
            food.setDescription(getSingleChild(foodElement,"description").getTextContent());
            food.setPortion(getSingleChild(foodElement,"portion").getTextContent());
            food.setOptions(getOptionsData(foodElement));
            if (food.getOriginalType().equals(request.getSession(false).getAttribute("category")))
            foodList.add(food);
        }
        return foodList;
    }


    public static Element getSingleChild(Element element, String childName){
        NodeList nlist=element.getElementsByTagName(childName);
        Element child=(Element)nlist.item(0);
        return child;
    }

    private Map<String,String> getOptionsData(Element element){
        NodeList priceNodes=element.getElementsByTagName("price");
        Map<String,String> prices=new HashMap<>();

        if (priceNodes.getLength()==1){
            prices.put("",getSingleChild(element,"price").getAttribute("value"));
        }else {
            for (int i = 0; i < priceNodes.getLength(); i++) {
                Element child = (Element) priceNodes.item(i);
                prices.put("-"+child.getAttribute("option"),"-"+child.getAttribute("value"));
            }
        }
        return prices;

    }

}
