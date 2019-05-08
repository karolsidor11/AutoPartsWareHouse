package pl.sidor.AutoPartsWareHouse.service

import models.Role
import models.User
import pl.sidor.AutoPartsWareHouse.repository.UserRepository
import spock.lang.Specification

class UserServiceImplTest extends Specification {

    private UserService userService
    private UserRepository repository

    void setup() {
        repository = Mock(UserRepository)
        userService = new UserServiceImpl(repository)
    }

    def " should return user by id"() {
        given:
        Integer id = 1
        Role role = Role.builder().id(1).role("USER").build()
        User user = User.builder().id(1).name("Karol").lastName("Sidor")
                .email("karolsidor11@wp.pl").role(role) build()
        repository.findById(id) >> Optional.ofNullable(user)
        when:
        User actualUser = userService.findById(id)
        then:
        actualUser == user
    }

    def " should return exception when id is incorect"() {
        given:
        Integer id = 999
        repository.findById(id) >> Optional.empty()
        when:
        userService.findById(id)
        then:
        thrown(NoSuchElementException)
    }

    def "should return user by email"() {
        given:
        String email = "karolsidor11@wp.pl"
        Role role = Role.builder().id(1).role("USER").build()
        User user = User.builder().id(1).name("Karol").lastName("Sidor").email(email).role(role).build()
        repository.findByEmail(email) >> user

        when:
        User actualUser = userService.findByEmail(email)

        then:
        actualUser == user
    }

    def "should exception when email is  incorect"() {
        given:
        String email = "sdf"
        repository.findByEmail(email)>>  null
        when:
        userService.findByEmail(email)

        then:
        thrown(IllegalArgumentException)
    }

    def" should return user list"(){

    }


}
