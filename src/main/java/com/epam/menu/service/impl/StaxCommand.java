package com.epam.menu.service.impl;

import com.epam.menu.dao.DaoFactory;
import com.epam.menu.dao.XmlDao;
import com.epam.menu.entity.Food;
import com.epam.menu.service.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StaxCommand implements Command {

    @Override
    public List<Food> execute(HttpServletRequest request) {
        XmlDao dao=DaoFactory.getInstance().getDao(DaoFactory.DaoType.STAX);
        return dao.parse(request);
    }
}
