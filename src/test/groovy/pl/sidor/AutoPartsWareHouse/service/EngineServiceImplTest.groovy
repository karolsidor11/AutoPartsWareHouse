package pl.sidor.AutoPartsWareHouse.service

import models.Engine
import pl.sidor.AutoPartsWareHouse.repository.EngineRepository
import spock.lang.Specification

class EngineServiceImplTest extends Specification {

    private EngineRepository engineRepository;
    private EngineService engineService

    void setup() {
        engineRepository = Mock(EngineRepository)
        engineService = new EngineServiceImpl(engineRepository)
    }

    def "should return engine by id"() {
        given:
        Integer id = 1
        Engine engine = new Engine.EngineBuilder().id(1).torque(22).capacity(22).build()
        engineRepository.findById(id) >> Optional.ofNullable(engine)

        when:
        Engine engine1 = engineService.findById(id)

        then:
        engine1 != null
        engine1 == engine
    }

    def " should return Exception when id <=0"() {
        given:
        Integer id = -1
        engineRepository.findById(id) >> Exception

        when:
        engineService.findById(id)
        then:
        thrown(Exception)
    }

    def " should return empty list"() {
        given:
        List<Engine> engineList = new ArrayList<>()
        engineRepository.findAll() >> engineList

        when:
        List<Engine> actual = engineService.findAll()

        then:
        actual.isEmpty()
        actual.size() == 0

    }

    def " should return list engines"() {
        given:
        List<Engine> engineList = new ArrayList<>()
        Engine engine = new Engine.EngineBuilder().id(1).torque(220).build()
        Engine engine1 = new Engine.EngineBuilder().id(2).torque(230).build()
        engineList.add(engine)
        engineList.add(engine1)

        engineRepository.findAll() >> engineList

        when:
        List<Engine> actual = engineService.findAll()

        then:
        actual != null
        actual.size() == 2
        actual == engineList
    }
}
