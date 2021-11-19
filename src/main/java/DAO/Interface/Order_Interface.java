package DAO.Interface;

import java.util.List;

public interface Order_Interface <T> {
    boolean create(T t);
    List<T> getOrders();
    List<T> getAllOrderWithCostByCost();
}


