package com.epam.menu.dao.impl;

import com.epam.menu.dao.XmlDao;
import com.epam.menu.dao.util.StaxHandler;
import com.epam.menu.entity.Food;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class StaxDao implements XmlDao {
    public final static StaxDao instance=new StaxDao();

    private StaxDao() {
    }

    public static StaxDao getInstance() {
        return instance;
    }

    @Override
    public List<Food> parse() {
        List<Food> foodList=null;
        String dataSource=this.getClass().getClassLoader().getResource("menu.xml").getPath();
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(dataSource);
        }catch (FileNotFoundException e){}
        XMLStreamReader xmlStreamReader=null;
        try {
            xmlStreamReader= XMLInputFactory.newInstance().createXMLStreamReader(inputStream);
        }catch (XMLStreamException e){}
        try {
            foodList=new StaxHandler().getFoodList(xmlStreamReader);
        }catch (Exception e){}
        return foodList;
    }
}
