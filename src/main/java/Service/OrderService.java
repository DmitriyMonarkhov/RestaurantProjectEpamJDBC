package Service;

import DAO.OrderDAO;
import entity.Order;

import java.util.List;

public class OrderService {

    private static final OrderDAO orderDAO = new OrderDAO();

    public static int create (Order order){return orderDAO.create(order);}
    public static void getOrders (){orderDAO.getOrders();}

    }
