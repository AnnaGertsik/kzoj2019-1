package com.servlet;

import com.SingleTone;
import com.company.*;
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

@WebServlet("/diaryf")
public class DeleteDiaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SingleTone singleTone=SingleTone.getInstance("???");
        if(singleTone.getLogin().equals("???")) req.getRequestDispatcher("AutorizWindow.jsp").forward(req, resp);
        else {
            req.setAttribute("userName", singleTone.getLogin());
            req.getRequestDispatcher("MainWindow.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] checked=req.getParameterValues("toDelete");
        Configuration configuration=new Configuration();
        SessionFactory factory=configuration.configure().buildSessionFactory();
        DAO<Diary, String> diaryStringDAO=new DiaryDAO(factory);
        DAO<Statistic, String> statisticStringDAO=new StatisticDAO(factory);
        DAO<Food, String> foodStringDAO=new FoodDAO(factory);
        if(checked!=null) {
            for (int i = 0; i < checked.length; i++) {
                Diary diary = diaryStringDAO.read(checked[i]);
                Statistic statistic = statisticStringDAO.read(diary.getLogin() + "+" + diary.getDate());
                Food food = foodStringDAO.read(diary.getFoodName());
                statistic.setCurrCal(statistic.getCurrCal() - diary.getSize() / 100 * food.getCalories());
                statistic.setCurrFats(statistic.getCurrFats() - diary.getSize() / 100 * food.getFats());
                statistic.setCurrProteins(statistic.getCurrProteins() - diary.getSize() / 100 * food.getProtein());
                statistic.setCurrCarbohydrates(statistic.getCurrCarbohydrates() - diary.getSize() / 100 * food.getCarbohydrates());
                statisticStringDAO.update(statistic);
                diaryStringDAO.delete(diary);
            }
        }
        DiaryViewer diaryViewer=new DiaryViewer();
        diaryViewer.main(req, resp);
    }
}
