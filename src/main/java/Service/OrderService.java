package Service;

import DAO.Classes.OrderDAO;
import entity.Menu;
import entity.Order;

import java.util.List;

public class OrderService {

    private static final OrderDAO orderDAO = new OrderDAO();

    public static boolean create (Order order){
        return orderDAO.create(order);}

    public static List<Order> getOrders (){
        List<Order> list = orderDAO.getOrders();
        System.out.println("\n Orders from database: ");
        list.forEach(System.out::println);
        return list;
    }
    public static List<Order> getAllOrderWithCostByCost() {
        List<Order> list = orderDAO.getAllOrderWithCostByCost();
        System.out.println("\n orders with costs: ");
        list.forEach(System.out::println);
        return list;
    }
    }
