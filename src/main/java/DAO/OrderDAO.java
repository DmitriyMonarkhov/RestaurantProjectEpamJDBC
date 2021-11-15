package DAO;

import DAO_Interfaces.Order_Interface;
import entity.Client;
import entity.Menu;
import entity.Order;
import org.hibernate.Session;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional

public class OrderDAO implements Order_Interface <Order> {


    private static final EntityManagerFactory MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("Restaurant_DB");
    @PersistenceContext
    private EntityManager entityManager;

    public int create(Order order) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(order);
        entityTransaction.commit();
        System.out.println("Congratulations! \n " +
                "Your number of order " + order.getId());
        return order.getId();
    }

    public void getOrders() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT o FROM Order o";
        TypedQuery<Order> typedQuery = entityManager.createQuery(query, Order.class);
        List<Order> orders = typedQuery.getResultList();
        for (Order order : orders)
            System.out.println("Order with № " + order.getId() + " the id of client " + order.getClient_id()
            + " the dish id " + order.getMenu_id());
    }
}