package com.company;

import com.model.Food;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class FoodDAO implements DAO<Food, String> {
    private SessionFactory factory;
    public FoodDAO(SessionFactory factory){
        this.factory=factory;
    }
    public boolean create(Food food){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.save(food);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return result;
    }

    public Food read(String foodName) {
        Food result=new Food();

        try(Session session=factory.openSession()){
            result=session.get(Food.class, foodName);
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally {
            if(result==null){
                result=new Food();
                result.setFoodName("???");
                return result;
            }
            return result;
        }
    }
    public boolean update(Food food){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.update(food);
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

    @Override
    public String getTableView(String data) {
        return null;
    }

    public boolean delete(Food food){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.delete(food);
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
}
