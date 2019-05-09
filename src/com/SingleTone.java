package com;

public class SingleTone {
    private static SingleTone instance;
    private static String login;
    private SingleTone(String login){
        this.login=login;
    }
    public static SingleTone getInstance(String login){
        if(instance==null){
            instance=new SingleTone(login);
        }
        return instance;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login=login;
    }

}
