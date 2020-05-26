package com.KSTech.learnmicroserviceswithspringboot.user;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


@Component
public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList();

    // Static blocks
    static  {
        users.add(new User(1, "Mohammad Kamar Shad", new Date()));
        users.add(new User(2, "Uzair", new Date()));
        users.add(new User(3, "Rashiq", new Date()));
        users.add(new User(4, "Irshad", new Date()));
    }

    private static long userCount = 4;

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getUserId() == null) {
            user.setUserId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User find(Long id) {
        for(User user: users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    public User delete(Long id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            User user =  iterator.next();
            if (user.getUserId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}