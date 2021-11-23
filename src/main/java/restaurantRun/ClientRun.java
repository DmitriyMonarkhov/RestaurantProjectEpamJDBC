package restaurantRun;

import service.ClientService;
import service.MenuService;
import service.OrderService;
import entity.Client;
import entity.Order;

import java.util.Scanner;

public class ClientRun {
    static int choice;
    static boolean create_order;

    public static void clientRun() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String phone;

        System.out.println("Please enter your name");
        name = scanner.nextLine();
        System.out.println("Please enter your mobile phone");
        phone = scanner.nextLine();
        Client client = new Client(name, phone);
        ClientService.create(client);
        makeOrder();
    }

    public static void makeOrder() {
        try {
            int id_client = ClientService.getLastID();
            MenuService.getAll();
            System.out.println("\n* Please choose the position from menu *");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            Order order = new Order(id_client, choice);
            create_order = OrderService.create(order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (create_order = true) {
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
