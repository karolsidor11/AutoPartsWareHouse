package pl.sidor.AutoPartsWareHouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Body;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sidor.AutoPartsWareHouse.repository.BodyRepository;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    String name;
    String lastName;
    Integer age;
    @Autowired
    BodyRepository bodyRepository;

    public Person(BodyRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }

    public boolean isAdulst() throws Exception {
        if (age == 0 || age < 0) {
            throw new Exception("Wiek nie może być ujemny");
        }
        return age > 18;
    }

    public Body getById(int id) {

        Optional<Body> byId = bodyRepository.findById(id);
        return byId.get();
    }

}
