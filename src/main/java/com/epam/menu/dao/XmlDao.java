package com.epam.menu.dao;

import com.epam.menu.entity.Food;
import com.epam.menu.exception.DAOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface XmlDao {
    List<Food> parse(HttpServletRequest request) throws DAOException;
}
