package com.epam.menu.dao;

import com.epam.menu.dao.impl.DomDao;
import com.epam.menu.dao.impl.SaxDao;
import com.epam.menu.dao.impl.StaxDao;

public class DaoFactory {
public final static DaoFactory instance=new DaoFactory();

    public static DaoFactory getInstance() {
        return instance;
    }

    public XmlDao getDao(DaoType type){
        switch (type){
            case SAX:
                return SaxDao.getInstance();
            case STAX:
                return StaxDao.getInstance();
            case DOM:
                return DomDao.getInstance();

                default: return null; //========================временное решение
        }
    }


    public enum DaoType{
        SAX,STAX,DOM;

    }
}
