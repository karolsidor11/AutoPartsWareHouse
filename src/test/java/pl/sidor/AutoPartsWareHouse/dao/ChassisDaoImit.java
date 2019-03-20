//package pl.sidor.AutoPartsWareHouse.dao;
//
//import pl.sidor.AutoPartsWareHouse.models.Chassis;
//import pl.sidor.AutoPartsWareHouse.service.ChassisService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class ChassisDaoImit implements ChassisService {
//
//    private List<Chassis> chassisList;
//
//    public ChassisDaoImit() {
//        chassisList = new ArrayList<>();
//        chassisList.add(new Chassis(1, "XDrive", "Brembo", "McPerson", "AVG"));
//        chassisList.add(new Chassis(2, "4Motion", "AVG", "McPerson", "GT"));
//        chassisList.add(new Chassis(3, "4Matic", "Brembo", "McPerson", "AVG"));
//        chassisList.add(new Chassis(4, "Quattro", "AVG", "McPerson", "GT"));
//    }
//
//    @Override
//    public Optional<Chassis> findById(int id) {
//        return Optional.ofNullable(chassisList.stream().filter(chassis -> chassis.getId() == id).findFirst().get());
//    }
//}
