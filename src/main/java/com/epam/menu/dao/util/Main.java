package com.epam.menu.dao.util;


import com.epam.menu.dao.DaoFactory;
import com.epam.menu.dao.XmlDao;
import com.epam.menu.entity.Food;
import com.epam.menu.service.Command;
import com.epam.menu.service.CommandHelper;
import com.epam.menu.web.RequestedParserType;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        XmlDao dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.DOM);
        List<Food> foodList = dao.parse();

        for (Food food:foodList){
            System.out.println(food);
        }

    }
}
