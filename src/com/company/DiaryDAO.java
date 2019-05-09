package com.company;

import com.model.Diary;
import com.model.Diary;
import com.model.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;


public class DiaryDAO implements DAO<Diary, String> {
    private SessionFactory factory;
    public DiaryDAO(SessionFactory factory){
        this.factory=factory;
    }
    public boolean create(Diary dairy){
        boolean result=false;

        Date date=new Date();
        try(Session session=factory.openSession()){
            session.beginTransaction();
            dairy.setId(date.getTime());
            session.save(dairy);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return result;
    }

    public Diary read(String login) {
        Diary result=new Diary();

        try(Session session=factory.openSession()){
            result=session.get(Diary.class, Long.parseLong(login));
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally {
            if(result==null){
                result=new Diary();
                result.setLogin("???");
                return result;
            }
            return result;
        }
    }
    public boolean update(Diary dairy){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.update(dairy);
            session.getTransaction().commit();
            result = true;
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally {
            return result;
        }
    }
    public boolean delete(Diary diary){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.delete(diary);
            session.getTransaction().commit();
            result = true;
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally {
            return result;
        }
    }
    public String getTableView(String loginAndDate){
        DAO<Food, String> foodStringDAO=new FoodDAO(factory);
        String result="";
        String login=loginAndDate.substring(0, loginAndDate.indexOf('+'));
        String date=loginAndDate.substring(loginAndDate.indexOf('+')+1);
        try(Session session=factory.openSession()){
            String sql="from "+Diary.class.getSimpleName();
            sql+=" where login= :paramLogin and date= :paramDate";
            Query query=session.createQuery(sql);
            query.setParameter("paramLogin", login);
            query.setParameter("paramDate", date);
            List<Diary> diaries=query.list();
            for(Diary d: diaries){
                double coeff=d.getSize()/100.0;
                Food food=foodStringDAO.read(d.getFoodName());
                result+="\n<tr>\n" +
                        "<td></td>\n"+
                        "<td>"+d.getFoodName()+"</td>\n"+
                        "<td>"+d.getSize()+"</td>\n"+
                        "<td>"+food.getCalories()*coeff+"</td>\n"+
                        "<td>"+food.getFats()*coeff+"</td>\n"+
                        "<td>"+food.getProtein()*coeff+"</td>\n"+
                        "<td>"+food.getCarbohydrates()*coeff+"</td>\n"+
                        "<td><input type='checkbox' value='"+d.getId()+"' name='toDelete'></td>\n"+
                        "</tr>\n";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            return result;
        }
    }
}
