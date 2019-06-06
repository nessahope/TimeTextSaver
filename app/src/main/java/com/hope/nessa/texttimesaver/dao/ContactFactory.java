package com.hope.nessa.texttimesaver.dao;

public class ContactFactory {
    private static ContactDao contactDao = new ContactDao();

    public static ContactDao getContactDao() {
        return contactDao;
    }

    public ContactFactory(){

    }
}
