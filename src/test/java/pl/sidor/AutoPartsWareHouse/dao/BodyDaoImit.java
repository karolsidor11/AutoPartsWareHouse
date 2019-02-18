//package pl.sidor.AutoPartsWareHouse.dao;
//
//import pl.sidor.AutoPartsWareHouse.model.Body;
//import pl.sidor.AutoPartsWareHouse.service.BodyService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class BodyDaoImit implements BodyService {
//
//    private List<Body> bodyList;
//
//    public BodyDaoImit() {
//        bodyList= new ArrayList<>();
//
//        bodyList.add(new Body(1,"Avant", "Red", 5));
//        bodyList.add(new Body(2,"Hatcback", "Red", 4));
//        bodyList.add(new Body(3,"Sedan", "Green", 5));
//        bodyList.add(new Body(4,"Avant", "Blue", 4));
//    }
//
//    @Override
//    public Optional<Body> findById(int id) {
//        return Optional.ofNullable(bodyList.stream().filter(body -> body.getId()==id).findFirst().get());
//    }
//}
