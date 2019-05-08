package pl.sidor.AutoPartsWareHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AutoPartsWareHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoPartsWareHouseApplication.class, args);
    }

}
