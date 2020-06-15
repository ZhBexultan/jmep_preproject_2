package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);
        carService.addCar(new Car("A1", 1));
        carService.addCar(new Car("A2", 2));
        carService.addCar(new Car("A3", 3));
        carService.addCar(new Car("A4", 4));

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", carService.getCarById(1L)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", carService.getCarById(2L)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", carService.getCarById(3L)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", carService.getCarById(4L)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        System.out.println("Get User by Car name and series");
        System.out.println(userService.getUserByCarNameAndSeries("A3", 3).getFirstName());
        System.out.println(userService.getUserByCarNameAndSeries("A2", 2).getFirstName());

        context.close();
    }
}
