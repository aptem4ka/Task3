package com.epam.menu.dao.impl;

import com.epam.menu.dao.XmlDao;
import com.epam.menu.dao.util.StaxHandler;
import com.epam.menu.entity.Food;
import com.epam.menu.exception.DAOException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public List<Food> parse(HttpServletRequest request) throws DAOException {
        List<Food> foodList=null;
        String dataSource=this.getClass().getClassLoader().getResource("menu.xml").getPath();
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(dataSource);
        }catch (FileNotFoundException e){
            throw new DAOException(e);
        }
        XMLStreamReader xmlStreamReader=null;
        try {
            xmlStreamReader= XMLInputFactory.newInstance().createXMLStreamReader(inputStream);
            foodList=new StaxHandler().getFoodList(xmlStreamReader, request);
        }catch (XMLStreamException|IOException e){
            throw new DAOException(e);
        }
        return foodList;
    }
}
