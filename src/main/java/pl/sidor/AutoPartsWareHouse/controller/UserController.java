package pl.sidor.AutoPartsWareHouse.controller;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.AutoPartsWareHouse.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<User> save() {
        User user = User.builder()
                .name("Mariusz")
                .lastName("Max")
                .email("jankowalski@wp.pl")
                .build();
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {

        List<User> all = userService.findAll();
        HttpStatus httpStatus = !all.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(all, httpStatus);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable int id) {

        Optional<User> byId = Optional.of(userService.findById(id));
        HttpStatus httpStatus = byId.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(byId.get(), httpStatus);
    }
}
