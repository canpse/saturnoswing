package lucas.app;

import lucas.model.User;
import lucas.model.bo.UserBo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter your username and password");
            Scanner keyboard = new Scanner(System.in);
            String login = keyboard.next();
            String password = keyboard.next();
            if (UserBo.login(login, password)){
                AppCycle app = new AppCycle(keyboard, new User(login, password));
            } else {
                System.out.println("Please try again");
            }
        }

    }

}