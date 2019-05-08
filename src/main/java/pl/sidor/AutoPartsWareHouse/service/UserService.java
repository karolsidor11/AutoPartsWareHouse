package pl.sidor.AutoPartsWareHouse.service;

import models.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    User findByEmail(String email);

    User save(User user);

    List<User> findAll();
}
