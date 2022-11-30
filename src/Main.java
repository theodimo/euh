import api.User;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //User newUser = new User("Dimos", "Theocharis", "thanatopios7", 1234, "user");
        ArrayList<User> users = new ArrayList<>();

        String name, surname, username, type;
        int password, confirmationPassword;

        System.out.println("Give name: ");
        name = scanner.nextLine();

        System.out.println("Give surname: ");
        surname = scanner.nextLine();

        System.out.println("Give username: ");
        username = scanner.nextLine();

        System.out.println("Give password: ");
        password = scanner.nextInt();

        System.out.println("Give type: ");
        type = scanner.nextLine();






    }
}
