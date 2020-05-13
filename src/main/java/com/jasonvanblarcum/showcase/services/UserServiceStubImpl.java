package com.jasonvanblarcum.showcase.services;

import com.jasonvanblarcum.showcase.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceStubImpl implements UserService {


    public boolean authenticate(String username, String password) {
        return Objects.equals(username, password);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
