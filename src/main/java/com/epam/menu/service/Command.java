package com.epam.menu.service;

import com.epam.menu.entity.Food;
import com.epam.menu.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Command {

    List<Food> execute(HttpServletRequest request) throws ServiceException;

}

