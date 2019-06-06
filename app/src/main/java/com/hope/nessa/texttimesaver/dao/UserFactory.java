package com.hope.nessa.texttimesaver.dao;

public class UserFactory {
    private static UserDao userdao = new UserDao();

    public static UserDao getUserdao() {
        return userdao;
    }

    public UserFactory(){

    }
}
