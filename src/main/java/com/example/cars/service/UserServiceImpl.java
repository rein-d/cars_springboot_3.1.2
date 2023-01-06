package com.example.cars.service;

import com.example.cars.dao.UserDao;
import com.example.cars.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao usersDao;

    public UserServiceImpl(UserDao usersDao) {
        this.usersDao = usersDao;
    }
    @Override
    public List<User> getUsers() {
        return usersDao.findAll();
    }

    @Override
    public User getUser(Long id) {
        return usersDao.getReferenceById(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        usersDao.save(user);
    }

    @Transactional
    @Override
    public void saveUser(Long id, String firstName, String lastName, String email) {
        User existingUser = getUser(id);
        existingUser.setFirstName(firstName);
        existingUser.setLastName(lastName);
        existingUser.setEmail(email);
        usersDao.save(existingUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        usersDao.deleteById(id);
    }
}
