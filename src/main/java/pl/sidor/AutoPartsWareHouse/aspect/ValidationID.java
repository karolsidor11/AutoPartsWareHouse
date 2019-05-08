package pl.sidor.AutoPartsWareHouse.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import pl.sidor.AutoPartsWareHouse.exception.WrongIDException;

@Aspect
public class ValidationID {

    //    TODO Debaguj- nie działa prawidłowo
    @Before(value = "execution(* pl.sidor.AutoPartsWareHouse.service.BodyServiceImpl.findById(id))", argNames = "id")
    public int validateID(int id) throws WrongIDException {
        if (id <= 0) {
            throw new WrongIDException("Nieprawidłowe ID !!!");
        }
        return id;
    }
}
