package com.epam.menu.dao;

import com.epam.menu.entity.Food;

import java.util.List;

public interface XmlDao {
    List<Food> parse();
}
