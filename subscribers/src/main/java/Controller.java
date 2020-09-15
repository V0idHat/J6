import model.User;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    static void readAll() {
        try {
            UserService.getAllUsers().forEach(user -> System.out.println(user));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static void readOne(int id) {
        try {
            System.out.println(UserService.findUserById(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static void deleteOne(int id) {
        try {
            UserService.removeUserById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        {

        }
    }

    static void save(User user) {
        try {
            UserService.addUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static void update(User user, int id) {
        try {
            UserService.updateUserById(user, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.next();

        System.out.println("Enter Email : ");
        String email = sc.next();

        System.out.println("Enter Mobile : ");
        long mob = sc.nextLong();

        save(new User(name, email, mob));
        System.out.println("Subscriber Added Successfully!!");

    }
}
