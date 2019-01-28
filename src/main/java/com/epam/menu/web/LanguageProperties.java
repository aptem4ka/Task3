package com.epam.menu.web;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageProperties {
    private ResourceBundle bundle;

    public LanguageProperties(Locale locale) {
        bundle=ResourceBundle.getBundle("prop",locale);
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
