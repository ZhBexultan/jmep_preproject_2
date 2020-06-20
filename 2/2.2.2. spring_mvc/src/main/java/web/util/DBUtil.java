package web.util;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    private static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(1L, "BMW", 5, 2014));
        cars.add(new Car(2L, "Audi", 8, 2018));
        cars.add(new Car(3L, "Mercedes-Benz", 220, 2019));
        cars.add(new Car(4L, "Toyota", 70, 2020));
        cars.add(new Car(5L, "Lexus", 10, 2020));
    }

    public List<Car> getCars() {
        return cars;
    }

}
