package com.epam.menu.dao.impl;

import com.epam.menu.dao.XmlDao;
import com.epam.menu.dao.util.SaxHandler;
import com.epam.menu.entity.Food;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class SaxDao implements XmlDao {
    private static final SaxDao instance=new SaxDao();

    private SaxDao(){}

    public static SaxDao getInstance() {
        return instance;
    }

    @Override
    public List<Food> parse(HttpServletRequest request) {
        XMLReader xmlReader=null;
        try {
            xmlReader= XMLReaderFactory.createXMLReader();
        }catch (SAXException e){}
        SaxHandler handler=new SaxHandler();
        xmlReader.setContentHandler(handler);

        ClassLoader classLoader=this.getClass().getClassLoader();
        String datasource=classLoader.getResource("menu.xml").getPath();

        try {
            xmlReader.parse(datasource);
        }catch (SAXException e){}
        catch (IOException t){}

        return handler.getFoodList(request);
    }
}
