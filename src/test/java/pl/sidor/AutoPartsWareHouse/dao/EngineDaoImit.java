//package pl.sidor.AutoPartsWareHouse.dao;
//
//import pl.sidor.AutoPartsWareHouse.model.Engine;
//import pl.sidor.AutoPartsWareHouse.service.EngineService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class EngineDaoImit implements EngineService {
//
//
//    private List<Engine> engineList;
//
//
//    public EngineDaoImit() {
//        engineList= new ArrayList<>();
//        engineList.add( new Engine(1, 2.2, 230, 500));
//        engineList.add( new Engine(2, 5.2, 330, 400));
//        engineList.add( new Engine(3, 4.2, 430, 300));
//        engineList.add( new Engine(4, 3.2, 530, 200));
//    }
//
//    @Override
//    public List<Engine> findAll() {
//        return engineList;
//    }
//
//    @Override
//    public List<Engine> findByCapacity(double capacity) {
//        return engineList.stream().filter(engine -> engine.getCapacity()==capacity).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Engine> findByPower(int power) {
//        return engineList.stream().filter(engine -> engine.getPower()==power).collect(Collectors.toList());
//    }
//}
