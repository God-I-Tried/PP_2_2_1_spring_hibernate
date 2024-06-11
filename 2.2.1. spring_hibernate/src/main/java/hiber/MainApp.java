package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru").setCar(new Car("BMW", 3)));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru").setCar(new Car("Audi", 8)));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru").setCar(new Car("Volvo", 5)));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru").setCar(new Car("Suzuki", 11)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println();
        }

        System.out.println(userService.getUserByCar("Volvo", 5));

        context.close();
    }
}
