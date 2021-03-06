package com.epam.menu.service.impl;

import com.epam.menu.dao.DaoFactory;
import com.epam.menu.dao.XmlDao;
import com.epam.menu.entity.Food;
import com.epam.menu.exception.DAOException;
import com.epam.menu.exception.ServiceException;
import com.epam.menu.service.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StaxCommand implements Command {

    @Override
    public List<Food> execute(HttpServletRequest request) throws ServiceException {
        XmlDao dao=DaoFactory.getInstance().getDao(DaoFactory.DaoType.STAX);
        try {
            return dao.parse(request);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
