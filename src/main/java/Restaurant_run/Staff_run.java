package Restaurant_run;

import Service.ClientService;
import Service.MenuService;
import Service.OrderService;
import entity.Client;
import entity.Menu;

import java.util.Scanner;

public class Staff_run {

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
                        "4. Get all active dish \n 5. Most expensive dish \n 6. Cheapest dish \n " +
                        "7. Get all list of dishes sort by in sequence \n 8. Get all list of dishes sort by in descending order \n " +
                        "9. Get dish by id \n Clients: \n 10. Update client information \n 11. Delete client \n " +
                        "12. Get all clients sort by in sequence \n 13. Get all clients sort by in descending order \n " +
                        "14. Get client by id \n 15. Orders info \n 16. Exit from app");

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
                        MenuService.getCheapestMenuItem();
                        break;
                    case ("7"):
                        MenuService.getAllMenuItemsOrderByNameAsc();
                        break;
                    case ("8"):
                        MenuService.getAllMenuItemsOrderByNameDesc();
                        break;
                    case ("9"): {
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        MenuService.getById(id);
                        break;
                    }
                    case ("10"): {
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
                    case ("11"): {
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        ClientService.delete(id);
                        break;
                    }
                    case ("12"):
                        ClientService.getAllbyNameAsc();
                        break;
                    case ("13"):
                        ClientService.getAllbyNameDesc();
                        break;
                    case ("14"): {
                        System.out.println("Input id");
                        int id = scanner.nextInt();
                        ClientService.getClientById(id);
                        break;
                    }
                    case ("15"): {
                        OrderService.getOrders();
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
