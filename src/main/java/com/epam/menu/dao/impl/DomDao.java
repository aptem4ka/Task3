package com.epam.menu.dao.impl;

import com.epam.menu.dao.XmlDao;
import com.epam.menu.dao.util.DomParser;
import com.epam.menu.entity.Food;
import com.epam.menu.exception.DAOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DomDao implements XmlDao {
    private static final DomDao instance=new DomDao();

    private DomDao() {
    }

    public static DomDao getInstance() {
        return instance;
    }

    @Override
    public List<Food> parse(HttpServletRequest request) throws DAOException{
        List<Food> foodList=null;
        try {
            foodList=new DomParser().getFoodList(request);
        }catch (Exception e){
            throw new DAOException(e);
        }

        return foodList;
    }
}
