package Restaurant_run;

import Service.ClientService;
import Service.MenuService;
import Service.OrderService;
import entity.Client;
import entity.Menu;

import java.util.Scanner;


public class Restaurant {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" ** NICE TO SEE YOU IN OUR RESTAURANT SHEF'S CHOISE **\n");
        while (true) {
            System.out.println("** Choose necessary function **\n" +
                    "1 - Menu of the restaurant for the client\n" +
                    "9 - Service menu for staff\n" +
                    "0 - Leave the app \n");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    Client_run.clientRun();
                    break;
                case "9":
                    Staff_run.stuffCheck();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Wrong choice, please repeat the input");

            }
        }
    }
}


