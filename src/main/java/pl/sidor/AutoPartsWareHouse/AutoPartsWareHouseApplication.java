package pl.sidor.AutoPartsWareHouse;

import models.Body;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class AutoPartsWareHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoPartsWareHouseApplication.class, args);
    }


}

class b{
    public static void main(String[] args) {

        Body body= new Body();

        body.setColor("Green");

        System.out.println(body.getColor());
        System.out.println(body.toString());
    }
}
