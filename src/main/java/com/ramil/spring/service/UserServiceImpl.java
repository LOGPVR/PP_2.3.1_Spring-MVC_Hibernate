package com.ramil.spring.service;

import com.ramil.spring.dao.UserDao;
import com.ramil.spring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void saveOrUpdateUser(User user) {
        if (user.getId() != null) {
            userDao.updateUser(user);
        } else {
            userDao.saveUser(user);
        }
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
