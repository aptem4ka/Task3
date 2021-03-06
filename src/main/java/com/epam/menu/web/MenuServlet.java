package com.epam.menu.web;

import com.epam.menu.entity.Food;
import com.epam.menu.exception.ServiceException;
import com.epam.menu.service.Command;
import com.epam.menu.service.CommandHelper;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start=Integer.parseInt(req.getParameter("start"));
        int elementsPerPage=5;
        int end=start+elementsPerPage-1;

        sessionSetup(req);
        setActualFoodList(req,start,end);

        req.setAttribute("start",start);
        //req.setAttribute("locale",req.getParameter("SessionLocale"));
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("table.jsp");
        requestDispatcher.forward(req,resp);
    }


    private void setActualFoodList(HttpServletRequest req, int start, int end)throws ServletException{

        HttpSession session=req.getSession(false);
        Command command=CommandHelper.getInstance().getCommand((String)session.getAttribute("parser"));
        List<Food> total=null;
        try {
            total=command.execute(req);
        } catch (ServiceException e){
            throw new ServletException(e);
        }
        List<Food> part=new ArrayList<>();
        for (int i=start ; i<=end ; i++){
            if (i<total.size()) {
                if (total.get(i).getOriginalType().equals(session.getAttribute("category"))){
                    part.add(total.get(i));
                }
            }else {
                req.setAttribute("isFinish", "y");
            }
        }
        req.setAttribute("food",part);

    }

    private void sessionSetup(HttpServletRequest req) {
        HttpSession session = req.getSession();

          if (req.getParameter("SessionLocale") != null)
                session.setAttribute("local", req.getParameter("SessionLocale"));
          if (req.getParameter("parser") != null)
                session.setAttribute("parser", req.getParameter("parser"));
          if (req.getParameter("category") != null)
                session.setAttribute("category", req.getParameter("category"));

    }

}
