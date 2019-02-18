package pl.sidor.AutoPartsWareHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.AutoPartsWareHouse.model.Body;
import pl.sidor.AutoPartsWareHouse.model.Car;
import pl.sidor.AutoPartsWareHouse.model.Chassis;
import pl.sidor.AutoPartsWareHouse.model.Engine;
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

        Optional<Optional<List<Car>>> allCar = Optional.ofNullable(carService.findAllCar());

        HttpStatus httpStatus = HttpStatus.OK;

        return new ResponseEntity(allCar.get(), httpStatus);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> saveCar() {

        Car car1 = new Car(1, "Audi", "A6", null, null, null, "Red");

        Engine.EngineBuilder builder = Engine.builder();
        Body.BodyBuilder bodyBuilder = Body.builder();
        Chassis.ChassisBuilder chassisBuilder = Chassis.builder();
        Car.CarBuilder carBuilder = Car.builder();

        Engine build = builder.id(1).power(230).capacity(2.4).torque(300).build();
        Body build1 = bodyBuilder.id(1).bodyCar("Avant").color("Blue").door(4).build();
        Chassis build2 = chassisBuilder.id(1).drive("Quattro").brakes("Brembo").steering("Avg").suspension("McPerson").build();
        Car build3 = carBuilder.id(2).body(build1).chassis(build2).engine(build).color("Blue").name("Audi").model("A6").build();

//        carService.saveCar(build3);

        HttpStatus httpStatus = HttpStatus.OK;

        return new ResponseEntity<Car>(car1, httpStatus);

    }
}
