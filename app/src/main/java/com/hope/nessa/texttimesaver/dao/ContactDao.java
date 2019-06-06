package com.hope.nessa.texttimesaver.dao;

import com.hope.nessa.texttimesaver.model.Contact;

import java.util.Collection;
import java.util.LinkedList;

public class ContactDao {
    private LinkedList<Contact> contacts = new LinkedList<>();

    public ContactDao() {
    }

    public ContactDao(LinkedList<Contact> contact) {
        this.contacts = contact;
    }

    public boolean addUser(Contact contact) {
        if (contacts.contains(contact)) {
            return false;
        } else {
            contacts.add(contact);
            return true;
        }
    }

    public boolean removeUser(Contact contact) {
        if (!contacts.contains(contact)) {
            return false;
        } else {
            contacts.remove(contact);
            return true;
        }
    }

    public boolean updateUser(Contact contact, Contact newContact) {
        if (!contacts.contains(contact)) {
            return false;
        } else {
            contacts.remove(contact);
            contacts.add(newContact);
            return true;
        }
    }

    public Contact getContactByPhoneNumber(String phoneNumber) {
        for (Contact con : contacts) {
            if (con.getPhoneNumber().equals(phoneNumber)) {
                return con;
            }
        }
        return null;
    }

    public Contact getUserByFirstName(String firstname){
        for(Contact contact : contacts){
            if(contact.getFirstName().equals(firstname));
            return contact;
        }
        return null;
    }

    public Contact getUserByIndex(Contact contact) {
        if (contacts.contains(contact)) {
            return contacts.get(contacts.indexOf(contact));
        }
        return null;
    }

    public Contact getUserById(int id) {
        if (contacts.size() - 1 >= id) {
            return contacts.get(id);
        }
        return null;
    }

    public boolean contains(Contact contact) {
        return contacts.contains(contact);
    }

    public boolean containsByName(String name) {
        for (Contact user : contacts) {
            if (user.getFirstName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        contacts.clear();
    }

    public Collection<Contact> getAll() {
        return contacts;
    }

}
