package com.epam.menu.web;

import com.epam.menu.dao.util.SaxHandler;
import com.epam.menu.entity.Food;
import com.epam.menu.service.Command;
import com.epam.menu.service.CommandHelper;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start=Integer.parseInt(req.getParameter("start"));
        int elementsPerPage=5;
        int end=start+elementsPerPage-1;
        if (req.getSession(false)!=null)
        req.getSession(true).setAttribute("local",req.getParameter("SessionLocale"));

        String par=req.getParameter("parser");
        Command command=CommandHelper.getInstance().getCommand(par);
        List<Food> total=command.execute(req);
        List<Food> part=new ArrayList<>();
        for (int i=start ; i<=end ; i++){
            if (i<total.size()) {
                part.add(total.get(i));
            }else {
                req.setAttribute("isFinish", "y");
            }
        }
        req.setAttribute("food",part);
        req.setAttribute("parser",par);
        req.setAttribute("start",start);
       // req.setAttribute("end",end);
        req.setAttribute("locale",req.getParameter("SessionLocale"));
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("table.jsp");
        requestDispatcher.forward(req,resp);

    }

}
