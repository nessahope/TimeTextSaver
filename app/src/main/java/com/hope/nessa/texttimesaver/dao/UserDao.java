package com.hope.nessa.texttimesaver.dao;

import com.hope.nessa.texttimesaver.model.Contact;
import com.hope.nessa.texttimesaver.model.User;

import java.util.Collection;
import java.util.LinkedList;

public class UserDao {
    private LinkedList<User> users = new LinkedList<>();

    public UserDao() {
    }

    public UserDao(LinkedList<User> users) {
        this.users = users;
    }

    public boolean addUser(User user) {
        if (users.contains(user)) {
            return false;
        } else {
            users.add(user);
            return true;
        }
    }

    public boolean removeUser(User user) {
        if (!users.contains(user)) {
            return false;
        } else {
            users.remove(user);
            return true;
        }
    }

    public boolean updateUser(User user, User newUser) {
        if (!users.contains(user)) {
            return false;
        } else {
            users.remove(user);
            users.add(newUser);
            return true;
        }
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByIndex(User user) {
        if (users.contains(user)) {
            return users.get(users.indexOf(user));
        }
        return null;
    }

    public User getUserById(int id) {
        if (users.size() - 1 >= id) {
            return users.get(id);
        }
        return null;
    }

    public boolean contains(User user) {
        return users.contains(user);
    }

    public boolean containsByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        users.clear();
    }

    public Collection<User> getAll() {
        return users;
    }

}
