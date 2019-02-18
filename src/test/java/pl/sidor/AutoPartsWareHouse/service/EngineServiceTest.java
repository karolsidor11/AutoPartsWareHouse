//package pl.sidor.AutoPartsWareHouse.service;
//
//import org.junit.Test;
//import pl.sidor.AutoPartsWareHouse.dao.EngineDaoImit;
//import pl.sidor.AutoPartsWareHouse.model.Engine;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class EngineServiceTest {
//
//    private EngineDaoImit engineDaoImit;
//
//    public EngineServiceTest() {
//        engineDaoImit= new EngineDaoImit();
//    }
//
//    @Test
//    public void shouldReturnListEngine(){
//        List<Engine> all = engineDaoImit.findAll();
//
//        assertNotNull(all);
//        assertEquals(4, all.size());
//    }
//
//    @Test
//    public void shouldFindByCapacity(){
//        List<Engine> byCapacity = engineDaoImit.findByCapacity(2.2);
//
//        assertNotNull(byCapacity);
//        assertEquals(2.2, byCapacity.get(0).getCapacity(),0.2);
//    }
//
//    @Test
//    public void shouldFindBYPower(){
//
//        List<Engine> byPower = engineDaoImit.findByPower(430);
//
//        assertNotNull(byPower);
//        assertEquals(430, byPower.get(0).getPower());
//    }
//}
