package com.servlet;

import com.SingleTone;
import com.company.DAO;
import com.company.DiaryDAO;
import com.company.FoodDAO;
import com.company.StatisticDAO;
import com.model.Diary;
import com.model.Food;
import com.model.Statistic;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/diary")
public class AdminFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SingleTone singleTone=SingleTone.getInstance("???");
        if(singleTone.getLogin().equals("???")) req.getRequestDispatcher("AutorizWindow.jsp").forward(req, resp);
        else {
            DiaryViewer diaryViewer = new DiaryViewer();
            diaryViewer.main(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Configuration conf = new Configuration();
        SessionFactory factory = conf.configure().buildSessionFactory();
        Diary diary=new Diary();
        DAO<Diary, String> diaryDAO=new DiaryDAO(factory);
        DAO<Food, String> foodDAO=new FoodDAO(factory);
        DAO<Statistic, String> statisticDAO=new StatisticDAO(factory);
        if(!req.getParameter("dish").equals("")){
            Food food=foodDAO.read(req.getParameter("dish"));
            if(food.getFoodName().equals("???")){
                req.setAttribute("errorNoSuchDish","Блюдо не найдено");
            }
            else {
                SingleTone singleTone=SingleTone.getInstance("login");
                diary.setLogin(singleTone.getLogin());
                diary.setDate(req.getParameter("date"));
                diary.setSize(Integer.parseInt(req.getParameter("size")));
                diary.setFoodName(req.getParameter("dish"));
                diaryDAO.create(diary);
                Statistic statistic=statisticDAO.read(singleTone.getLogin()+"+"+req.getParameter("date"));
                if(statistic.getLogin().equals("???")){
                    statistic.setLogin(singleTone.getLogin());
                    statistic.setDate(req.getParameter("date"));
                    statistic.setCurrCal(food.getCalories()*diary.getSize()/100);
                    statistic.setCurrCarbohydrates(food.getCarbohydrates()*diary.getSize()/100);
                    statistic.setCurrFats(food.getFats()*diary.getSize()/100);
                    statistic.setCurrProteins(food.getProtein()*diary.getSize()/100);
                    statisticDAO.create(statistic);
                }
                else{
                    statistic.setCurrCal(statistic.getCurrCal()+food.getCalories()*diary.getSize()/100);
                    statistic.setCurrCarbohydrates(statistic.getCurrCarbohydrates()+food.getCarbohydrates()*diary.getSize()/100);
                    statistic.setCurrFats(statistic.getCurrFats()+food.getFats()*diary.getSize()/100);
                    statistic.setCurrProteins(statistic.getCurrProteins()+food.getProtein()*diary.getSize()/100);
                    statisticDAO.update(statistic);
                }
            }
        }
        doGet(req, resp);
    }
}
