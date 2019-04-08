package pl.sidor.AutoPartsWareHouse.service

import models.Chassis
import pl.sidor.AutoPartsWareHouse.repository.ChassisRepository
import spock.lang.Specification

class ChassisServiceImplTest extends Specification {

    private ChassisRepository chassisRepository
    private ChassisService chassisService

    void setup() {
        chassisRepository = Mock(ChassisRepository)
        chassisService = new ChassisServiceImpl(chassisRepository)
    }

    def "should return chassis by id"() {
        given:
        Integer id = 1
        Chassis chassis = new Chassis.ChassisBuilder().id(1).brakes("Brembo").drive("Quatro").build()
        chassisRepository.findById(id) >> Optional.of(chassis)

        when:
        Chassis chassis1 = chassisService.findById(id)

        then:
        chassis1 != null
    }

    def " should return empty chassis list"() {
        given:
        List<Chassis> chassisList = new ArrayList<>()
        chassisRepository.findAll() >> chassisList

        when:
        List<Chassis> actual = chassisService.findAllChassis()

        then:
        actual.isEmpty()
        actual.size() == 0
    }


    def " should return chassis list"() {
        given:
        List<Chassis> chassisList = new ArrayList<>()
        Chassis chassis = new Chassis.ChassisBuilder().id(1).drive("XDrive").brakes("Brembo").build()
        Chassis chassis1 = new Chassis.ChassisBuilder().id(2).drive("Quattro").brakes("Brembo").build()
        chassisList.add(chassis)
        chassisList.add(chassis1)
        chassisRepository.findAll() >> chassisList

        when:
        List<Chassis> actual = chassisService.findAllChassis()

        then:
        actual!=null
        actual==chassisList
        actual.size()==2
    }
}
