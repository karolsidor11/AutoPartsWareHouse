package pl.sidor.AutoPartsWareHouse

import models.Body
import pl.sidor.AutoPartsWareHouse.repository.BodyRepository
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PersonTest1 extends Specification {

    @Shared
    Person person

    def setupSpec() {
        print("Witamy w testowanieu Spock")
    }

    void setup() {
        person = new Person()
    }

    def "test should return Person"() {

        when: "Person with set name"
        Person person = new Person(name: "Karol", lastName: "Sidor")

        then: "Person has name"
        person.name == "Karol"
        and:
        person.lastName == "Sidor"

        when:
        person.name = "Jan"

        then:
        person.name == "Jan"
    }


    def "should check a person"() {

        expect:
        new Person(name: "Jan") == new Person(name: "Jan")
    }

    def "setup and cleanup in one test"() {

        setup:
        person.name = "Jan"

        expect:
        person.name == "Jan"

        cleanup:

        println("Imie" + person.name)
    }

    def "paramertyzacja"() {

        when:
        person.name = "Jan"
        person.age = 22


        then:
        person.name == "Jan"
        person.age == 22
    }

    @Unroll("testy #name, #age")
    def " Parametryzacja w tabeli "() {

        when:
        Person person1 = new Person(name: name, age: age)

        then:
        person1.name == name
        person1.age == age

        where:
        name  | lastName | age
        "Jan" | _        | 27
    }


    @Unroll("Wiek: #age czy dorosły #adult")
    def "Parametryzacja w liście"() {

        expect:
        new Person(age: age).adulst == adult
        chekAge == age * age

        where:
        age << [19, 12, 23]
        adult << [true, false, true]
        chekAge = age * age

    }

    @Unroll
    def "Lista prametrów"() {

        expect:
        new Person(age: age).adulst == adult


        where:
        [age, adult] << [[12, false], [20, true]]
    }

    def " Wyjatkie exception NIE_RZUC_WYJATKU"() {

        given:
        Person person1 = new Person()

        when:
        person1.age = 12
        person1.isAdulst()

        then:
        notThrown(Exception)
    }


    def " Zwróc wyjatek is Adult()"() {

        when:

        Person person1 = new Person(age: 0)
        person1.adulst

        then:
        thrown(Exception)

    }

    def "test imienia"() {

        expect:
        new Person(age: 22) == new Person(age: age)
        new Person(name: "Karol").name == name


        where:
        age << 22
        name << ["Karol"]
    }


    def "Spock Mokowanie"() {

        given:
        BodyRepository bodyRepository = Mock(BodyRepository)
        Person person1 = new Person(bodyRepository)
        Body body = new Body.BodyBuilder().id(3).bodyCar("Car").build()
        bodyRepository.findById(3) >> Optional.of(body)

        when:
        bodyRepository.findById(1)
        person1.getById(3)
        println(person1.getById(3).bodyCar)

        then:

        1 * bodyRepository.findById(1)
        _ * person1.getById(_)
        person1.getById(3).bodyCar == "Car"


    }

    @Ignore
    def " Stub testing"() {

        given:
        BodyRepository bodyRepository = Mock(BodyRepository) {
            1 * findById(1) >> Optional.of(new Body.BodyBuilder().id(1).bodyCar("Yellow").build())
        }
        Person person1 = new Person(bodyRepository)

//        Body body = new Body.BodyBuilder().id(1).bodyCar("Yellow").build()
//        bodyRepository.findById(1)>>Optional.of(body)

        when:
        Body body = Optional.of(person1.getById(1)).get()

        then:
        with(body) {
            "Yellow" == bodyCar
            1 == id
        }
    }

}
