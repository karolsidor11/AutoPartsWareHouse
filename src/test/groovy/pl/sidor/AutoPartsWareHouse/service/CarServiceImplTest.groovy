package pl.sidor.AutoPartsWareHouse.service

import models.Body
import models.Car
import models.Chassis
import models.Engine
import pl.sidor.AutoPartsWareHouse.exception.IncorrectObjectException
import pl.sidor.AutoPartsWareHouse.repository.CarRepository
import spock.lang.Specification

class CarServiceImplTest extends Specification {

    private CarRepository carRepository
    private CarService carService

    void setup() {
        carRepository = Mock(CarRepository)
        carService = new CarServiceImpl(carRepository)
    }

    def "should find by ID"() {
        given:
        Integer id = 1
        Car car = new Car.CarBuilder().id(1).body().chassis().name("Audi").build()
        carRepository.findById(id) >> Optional.of(car)
        when:
        Car actualCar = carService.findById(id)
        then:
        actualCar != null
        actualCar == car
    }

    def "should return IllegalArgumentException"() {
        given:
        Integer id = 0
        carRepository.findById(id) >> new Exception()
        when:
        carService.findById(id)
        then:
        thrown(Exception)
    }

    def "should return empty list Car"() {
        given:
        List<Car> carList = new ArrayList<>()
        carRepository.findAll() >> carList

        when:
        List<Car> actualCarList = carService.findAllCar()

        then:
        actualCarList.isEmpty()
        0 == actualCarList.size()
    }

    def " should return Car List"() {
        given:

        List<Car> carList = new ArrayList<>();
        Car car = new Car.CarBuilder().id(1).name("Audi").build()
        Car car2 = new Car.CarBuilder().id(2).name("BMW").build()
        Car car3 = new Car.CarBuilder().id(3).name("Mercedes").build()
        Car car4 = new Car.CarBuilder().id(4).name("Fiat").build()

        carList.add(car)
        carList.add(car2)
        carList.add(car3)
        carList.add(car4)

        carRepository.findAll() >> carList

        when:
        List<Car> actualCarList = carService.findAllCar()

        then:
        !actualCarList.isEmpty()
        actualCarList.size() == 4
        actualCarList == carList
    }

    def "should save Car"() {
        given:
        Car car = new Car.CarBuilder()
                .id(1)
                .name("Audi")
                .models("A6")
                .chassis(new Chassis())
                .engine(new Engine())
                .body(new Body())
                .build()

        carRepository.save(car) >> car

        when:
        carService.saveCar(car)

        then:
        _ * carService.saveCar(car)

    }

    def " should return IncorrectObjectException"() {
        given:
        Car car = null
        carRepository.save(car)

        when:
        carService.saveCar(car)

        then:
        thrown(IncorrectObjectException)
    }

}
