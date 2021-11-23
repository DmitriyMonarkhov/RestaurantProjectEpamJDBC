package dao.interfaces;

import java.util.List;

public interface OrderInterface<T> {
    boolean create(T t);
    List<T> getOrders();
    List<T> getAllOrderWithCostByCost();
}


