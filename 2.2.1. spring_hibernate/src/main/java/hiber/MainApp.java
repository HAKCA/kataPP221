package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User nikita = new User("Никита", "Литвинков", "nikitka@mail.ru");
      User vasya = new User("Vasya", "Gorohov", "vaska@mail.ru");
      User gennadiy = new User("Gennadiy", "Sarkochev", "genka@mail.ru");

      Car lada = new Car("Lada", 5);
      Car audi = new Car("Audi", 3);
      Car toyota = new Car("Toyota", 7);

      nikita.setCar(lada);
      vasya.setCar(audi);
      gennadiy.setCar(toyota);

      userService.add(nikita);
      userService.add(vasya);
      userService.add(gennadiy);

      System.out.println(userService.getUserByCar("Audi", 3).getFirstName());
      userService.listUsers();

      context.close();
   }
}
