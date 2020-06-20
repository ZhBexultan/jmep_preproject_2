package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;
import web.util.DBUtil;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final DBUtil dbUtil = new DBUtil();

    @Override
    public List<Car> getAllCars() {
        return dbUtil.getCars();
    }

}
