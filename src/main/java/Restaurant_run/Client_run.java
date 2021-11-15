package Restaurant_run;

import Service.ClientService;
import Service.MenuService;
import Service.OrderService;
import entity.Client;
import entity.Order;

import java.util.Scanner;

public class Client_run {
    static int id_client;
    static int choice;
    static int create_order = 0;

    public static void clientRun() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String phone;

        System.out.println("Please enter your name");
        name = scanner.nextLine();
        System.out.println("Please enter your mobile phone");
        phone = scanner.nextLine();
        Client client = new Client(name, phone);
        id_client = ClientService.create(client);
        makeOrder();
    }

    public static void makeOrder() {
        try {
            MenuService.getAll();
            System.out.println("\n* Please choose the position from menu *");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            Order order = new Order(id_client, choice);
            create_order = OrderService.create(order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (create_order > 0) {
                System.out.println("Do you want order one more dish?\nYes - press - 1 \nNo - press - 2");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case (1):
                        makeOrder();
                    case (2):
                        System.out.println("Thank you for your order");
                        System.exit(0);
                    default:
                        System.out.println("Wrong input");
                        System.exit(0);
                }
            } else {
                System.out.println("Wrong input");
                System.exit(0);
            }
        }
    }
}
