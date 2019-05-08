package pl.sidor.AutoPartsWareHouse.service;

import lombok.extern.slf4j.Slf4j;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.AutoPartsWareHouse.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) {

        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);

    }

    @Override
    public User findByEmail(String email) {

        return Optional.ofNullable(userRepository.findByEmail(email)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User save(User user) {

      return Optional.of(userRepository.save(user)).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
