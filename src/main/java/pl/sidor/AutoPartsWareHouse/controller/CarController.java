package pl.sidor.AutoPartsWareHouse.controller;

import models.Body;
import models.Car;
import models.Chassis;
import models.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.AutoPartsWareHouse.exception.IncorrectObjectException;
import pl.sidor.AutoPartsWareHouse.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> findAllCar() {

        Optional<List<Car>> allCar1 = Optional.ofNullable(carService.findAllCar());

        HttpStatus httpStatus = HttpStatus.OK;

        return allCar1.map(cars -> new ResponseEntity<>(allCar1.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> saveCar(@RequestBody Car car) throws IncorrectObjectException {

        carService.saveCar(car);

        HttpStatus httpStatus = HttpStatus.OK;

        return new ResponseEntity<Car>(car, httpStatus);

    }

    private Car initCar() {
        Engine.EngineBuilder builder = Engine.builder();
        Body.BodyBuilder bodyBuilder = Body.builder();
        Chassis.ChassisBuilder chassisBuilder = Chassis.builder();
        Car.CarBuilder carBuilder = Car.builder();

        Engine build = builder.id(1).power(230).capacity(2.4).torque(300).build();
        Body build1 = bodyBuilder.id(1).bodyCar("Avant").color("Blue").door(4).build();
        Chassis build2 = chassisBuilder.id(1).drive("Quattro").brakes("Brembo").steering("Avg").suspension("McPerson").build();
        return carBuilder.id(2).body(build1).chassis(build2).engine(build).color("Blue").name("Audi").build();
    }
}
