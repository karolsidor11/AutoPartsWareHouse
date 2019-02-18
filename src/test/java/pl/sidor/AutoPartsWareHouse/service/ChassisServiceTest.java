//package pl.sidor.AutoPartsWareHouse.service;
//
//import org.junit.Test;
//import pl.sidor.AutoPartsWareHouse.dao.ChassisDaoImit;
//import pl.sidor.AutoPartsWareHouse.model.Chassis;
//
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//
//public class ChassisServiceTest {
//
//    private ChassisDaoImit chassisDaoImit;
//
//    public ChassisServiceTest() {
//        chassisDaoImit = new ChassisDaoImit();
//    }
//
//    @Test
//    public void shouldFindChassisByID() {
//        Optional<Chassis> byId = chassisDaoImit.findById(1);
//
//        assertEquals(1, byId.get().getId());
//
//    }
//
//    @Test(expected = NoSuchElementException.class)
//    public void shouldNotFindChassisByID() {
//
//        Optional<Chassis> byId = chassisDaoImit.findById(10);
//    }
//}
