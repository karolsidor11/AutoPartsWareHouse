package pl.sidor.AutoPartsWareHouse.dao;

import models.Chassis;
import pl.sidor.AutoPartsWareHouse.service.ChassisService;

import java.util.ArrayList;
import java.util.List;

public class ChassisDaoImit implements ChassisService {

    private List<Chassis> chassisList;

    public ChassisDaoImit() {
        chassisList = new ArrayList<>();
        chassisList.add(new Chassis(1, "XDrive", "Brembo", "McPerson", "AVG"));
        chassisList.add(new Chassis(2, "4Motion", "AVG", "McPerson", "GT"));
        chassisList.add(new Chassis(3, "4Matic", "Brembo", "McPerson", "AVG"));
        chassisList.add(new Chassis(4, "Quattro", "AVG", "McPerson", "GT"));
    }

    @Override
    public Chassis findById(int id) {
        if (id > 0) {
            return chassisList.stream().filter(chassis -> chassis.getId() == id).findFirst().get();
        }
        throw new NullPointerException("Id nie moze być ujemnen");
    }

    @Override
    public List<Chassis> findAllChassis() {
        return chassisList;
    }
}
