package restaurantRun;

import service.ClientService;
import service.MenuService;
import service.OrderService;
import entity.Client;
import entity.Menu;

import java.util.Scanner;

public class StaffRun {

    public static void stuffCheck() {
        System.out.println("Please input the password");
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine(); //password - "admin"
        String password = "admin";
        if (pass.equals(password)) { //
            stuffMenu();
        } else {
            System.out.println("Wrong password try again");
            stuffCheck();
        }
    }

    private static void stuffMenu() {
        try {
            while (true) {
                System.out.println("Choose necessary operation");
                System.out.println("Menu: \n 1. Create new dish \n 2. Edit dish \n 3. Delete a dish \n " +
                        "4. Get all active dish \n 5. Most expensive dish  \n 6. Get all list of dishes sort by in sequence \n " +
                        "7. Get all list of dishes sort by in descending order \n " +
                        "8. Get dish by id \n Clients: \n 9. Update client information \n 10. Delete client \n " +
                        "11. Get all clients sort by in sequence \n 12. Get all clients sort by in descending order \n " +
                        "13. Get client by id \n 14. Orders info \n 15. Orders with price \n 16. Exit from app");

                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();
                switch (choice) {
                    case ("1"): {
                        System.out.println("Input the name of dish");
                        String dish = scanner.nextLine();
                        System.out.println("Input the info about dish");
                        String info = scanner.nextLine();
                        System.out.println("Input price");
                        int price = scanner.nextInt();
                        Menu menu = new Menu(dish, info, price);
                        MenuService.create(menu);
                        break;
                    }
                    case ("2"): {
                        MenuService.getAll();
                        System.out.println("Input the name of dish");
                        String dish = scanner.nextLine();
                        System.out.println("Input the info about dish");
                        String info = scanner.nextLine();
                        System.out.println("Input price");
                        int price = scanner.nextInt();
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        Menu menu = new Menu(dish, info, price);
                        MenuService.update(id, menu);
                        break;
                    }
                    case ("3"): {
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        MenuService.delete(id);
                        break;
                    }
                    case ("4"):
                        MenuService.getAll();
                        break;
                    case ("5"):
                        MenuService.getMostExpensiveMenuItem();
                        break;
                    case ("6"):
                        MenuService.getAllMenuItemsOrderByNameAsc();
                        break;
                    case ("7"):
                        MenuService.getAllMenuItemsOrderByNameDesc();
                        break;
                    case ("8"): {
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        MenuService.getById(id);
                        break;
                    }
                    case ("9"): {
                        System.out.println("Input the name of client");
                        String name = scanner.nextLine();
                        System.out.println("Input the phone number");
                        String phone = scanner.nextLine();
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        Client client = new Client(name, phone);
                        ClientService.update(id, client);
                        break;
                    }
                    case ("10"): {
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        ClientService.delete(id);
                        break;
                    }
                    case ("11"):
                        ClientService.getAllbyNameAsc();
                        break;
                    case ("12"):
                        ClientService.getAllbyNameDesc();
                        break;
                    case ("13"): {
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        ClientService.getClientById(id);
                        break;
                    }
                    case ("14"): {
                        OrderService.getOrders();
                        break;
                    }
                    case ("15"): {
                        OrderService.getAllOrderWithCostByCost();
                        break;
                    }
                    case ("16"):
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
