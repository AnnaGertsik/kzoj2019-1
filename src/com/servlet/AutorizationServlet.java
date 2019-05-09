package com.servlet;

import com.SingleTone;
import com.company.DAO;
import com.company.UsersDAO;
import com.company.Users_dataDAO;
import com.model.User;
import com.model.User_data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class AutorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SingleTone singleTone=SingleTone.getInstance("???");
        singleTone.setLogin("???");
        req.getRequestDispatcher("AutorizWindow.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory factory=null;
        try {
            Configuration conf = new Configuration();
            factory = conf.configure().buildSessionFactory();

            DAO<User, String> userDAO = new UsersDAO(factory);
            DAO<User_data, String> user_dataDAO = new Users_dataDAO(factory);


            User user = new User();
            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));
            user=userDAO.read(req.getParameter("login"));
            if(user.getLogin().equals("???")==true || user.getPassword().equals(req.getParameter("password"))!=true){
                req.setAttribute("errorUserNotFound","Wrong login or password");
                req.getRequestDispatcher("AutorizWindow.jsp").forward(req,resp);
            }
            else {
                SingleTone singleTone=SingleTone.getInstance("???");
                singleTone.setLogin(user.getLogin());
                req.setAttribute("userName", user.getLogin());
                req.getRequestDispatcher("MainWindow.jsp").forward(req, resp);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
