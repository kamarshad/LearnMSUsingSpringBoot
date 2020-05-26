package com.KSTech.learnmicroserviceswithspringboot.user;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

interface UserService {
    public List<User> findAll();
    public User save(User user);
    public User find(Long id);
    public User delete(Long id);
}
