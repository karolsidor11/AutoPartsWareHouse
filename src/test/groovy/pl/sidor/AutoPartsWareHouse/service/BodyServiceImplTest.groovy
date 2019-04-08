package pl.sidor.AutoPartsWareHouse.service

import models.Body
import pl.sidor.AutoPartsWareHouse.repository.BodyRepository

class BodyServiceImplTest extends spock.lang.Specification {

    private BodyServiceImpl bodyService
    private BodyRepository bodyRepository

    void setup() {
        bodyRepository = Mock(BodyRepository)
        bodyService = new BodyServiceImpl(bodyRepository)
    }

    def 'should find by ID'() {

        given:
        Integer givenId = 1
        Body body = Body.builder().id(1).color("red").bodyCar("Avant").build()
        bodyRepository.findById(givenId) >> Optional.of(body)

        when:
        Body actualBody = bodyService.findById(givenId)

        then:
        actualBody.getId() == givenId
        actualBody==body
    }

    def "should return Exception when ID=<0"() {
        given:
        Integer id = 0
        bodyRepository.findById(id) >> new Exception()
        when:
        bodyService.findById(id)
        then:
        thrown(Exception)
    }

    def "should return empty body list"() {
        given:
        List<Body> bodyList = new ArrayList<>()
        bodyRepository.findAll() >> bodyList

        when:
        List<Body> bodies = bodyService.findAllBody()

        then:
        bodies.size() == 0
        bodies.isEmpty()
    }

    def " should return list body"() {
        given:
        List<Body> bodyList = new ArrayList<>();
        Body body = new Body.BodyBuilder().id(1).bodyCar("Avant").build()
        bodyList.add(body)
        bodyRepository.findAll() >> bodyList

        when:
        List<Body> actual = bodyService.findAllBody()

        then:
        actual != null
        actual == bodyList
        actual.size() == 1
        actual.get(0).id == 1
    }
}
