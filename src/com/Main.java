package com;

import com.company.*;
import com.model.Diary;
import com.model.Statistic;
import com.model.User;
import com.model.User_data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        SessionFactory factory = conf.configure().buildSessionFactory();
        DAO<Diary, String> diaryDAO=new DiaryDAO(factory);
        System.out.println(diaryDAO.read("1557278438455").getFoodName());
    }
}
