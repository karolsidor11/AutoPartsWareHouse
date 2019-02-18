package pl.sidor.AutoPartsWareHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.AutoPartsWareHouse.model.Body;
import pl.sidor.AutoPartsWareHouse.service.BodyService;

import java.util.List;
import java.util.Optional;

@RestController
public class BodyController {
    
    private BodyService bodyService;

    @Autowired
    public BodyController(BodyService bodyService) {
        this.bodyService = bodyService;
    }

    @RequestMapping(value = "body/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Body> getBodyByID(@PathVariable int id) {

        Optional<Body> byId = Optional.ofNullable(bodyService.findById(id));

        HttpStatus httpStatus = HttpStatus.OK;

        return new ResponseEntity<>(byId.get(), httpStatus);

    }

    @RequestMapping(value = "bodies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Body>> getAllBody() {

        Optional<List<Body>> allBody = Optional.ofNullable(bodyService.findAllBody());

        HttpStatus httpStatus = HttpStatus.OK;

        return new ResponseEntity<>(allBody.get(), httpStatus);

    }
}
