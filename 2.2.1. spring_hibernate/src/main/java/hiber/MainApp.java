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
        User user = new User("User1", "Lastname1", "user1@mail.ru");
        user.setCar(new Car(777, "BMW"));
        userService.add(user);
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car(123, "Mercedes")));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car(444, "Ford")));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car(333, "Toyota")));


        List<User> users = userService.listUsers();
        Car car=new Car(777, "BMW");
        User bmwOwner = userService.getUserByCar(car);

        System.out.println("Владелец машины "+car.getModel()+" "+bmwOwner);

        for (User usr : users) {
            System.out.println("Id = " + usr.getId());
            System.out.println("First Name = " + usr.getFirstName());
            System.out.println("Last Name = " + usr.getLastName());
            System.out.println("Email = " + usr.getEmail());
            System.out.println();
        }
        context.close();
    }
}
