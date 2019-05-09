package com.company;

import com.model.User_data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Users_dataDAO implements DAO<User_data, String> {
    private SessionFactory factory;
    public Users_dataDAO(SessionFactory factory){
        this.factory=factory;
    }

    @Override
    public String getTableView(String data) {
        return null;
    }

    public boolean create(User_data user_data){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.save(user_data);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return result;
    }

    public User_data read(String login) {
        User_data result=new User_data();
        result.setLogin("???");

        try(Session session=factory.openSession()){
            result=session.get(User_data.class, login);
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally {
            return result != null ? result : new User_data();
        }
    }
    public boolean update(User_data user_data){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.update(user_data);
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
    public boolean delete(User_data user_data){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.delete(user_data);
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
