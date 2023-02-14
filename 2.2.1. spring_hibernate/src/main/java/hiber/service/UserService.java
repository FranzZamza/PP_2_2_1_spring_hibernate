package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

// В сервис добавьте метод, который с помощью hql-запроса будет доставать юзера, владеющего машиной по ее модели и серии.
public interface UserService {
    void add(User user);

    User getUserByCar(Car car);

    List<User> listUsers();
}
