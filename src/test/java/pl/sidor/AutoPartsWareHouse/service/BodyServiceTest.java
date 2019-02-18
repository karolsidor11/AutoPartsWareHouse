//package pl.sidor.AutoPartsWareHouse.service;
//
//import org.junit.Test;
//import org.mockito.Mock;
//import pl.sidor.AutoPartsWareHouse.dao.BodyDaoImit;
//import pl.sidor.AutoPartsWareHouse.model.Body;
//import pl.sidor.AutoPartsWareHouse.repository.BodyRepository;
//
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class BodyServiceTest {
//
//    private BodyDaoImit bodyDaoImit;
//    @Mock
//    private BodyRepository bodyRepository;
//    private Body body;
//
//    public BodyServiceTest() {
//        bodyDaoImit = new BodyDaoImit();
//
//    }
//
//    @Test
//    public void shouldFindBodyById() {
//        Optional<Body> byId = bodyDaoImit.findById(1);
//
//        BodyService bodyService = new BodyServiceImpl(bodyRepository);
//        bodyService.findById(1);
//
//        assertNotNull(byId.get());
//        assertEquals(1, byId.get().getId());
//    }
//
//    @Test(expected = NoSuchElementException.class)
//    public void shouldBodyByBadID() {
//
//        Optional<Body> byId = bodyDaoImit.findById(10);
//
//    }
//
//    @Test
//    public void shouldGetBodyCarById() {
//
//        Optional<Body> byId = bodyDaoImit.findById(1);
//
//        assertNotNull(byId.get());
//        assertEquals("Avant", byId.get().getBodyCar());
//    }
//}
