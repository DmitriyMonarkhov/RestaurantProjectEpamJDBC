package DAO;

import DAO_Interfaces.Menu_Interface;
import entity.Client;
import entity.Menu;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MenuDAO implements Menu_Interface {

    private static final EntityManagerFactory MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("Restaurant_DB");
    @PersistenceContext
    private EntityManager entityManager;


    public int create(Menu menu) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(menu);
        entityTransaction.commit();
        System.out.println("The dish with id  " + menu.getId() + "  and name  " + menu.getDishes() + "  was created.");
        return menu.getId();
    }

    public void update(int id, Menu menu) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Menu edit_menu = entityManager.find(Menu.class, id);
        edit_menu.setDishes(menu.getDishes());
        edit_menu.setInfo(menu.getInfo());
        edit_menu.setPrice(menu.getPrice());
        entityManager.persist(edit_menu);
        entityTransaction.commit();
        System.out.println("The dish was updated.");
    }

    public void delete(int id) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Menu menu = entityManager.find(Menu.class, id);
        entityManager.remove(menu);
        entityTransaction.commit();
        System.out.println("The dish called " + menu.getDishes() + " is delete.");
    }

    public void getAll() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM Menu i";
        TypedQuery<Menu> typedQuery = entityManager.createQuery(query, Menu.class);
        List<Menu> menu = typedQuery.getResultList();
        for (Menu dish : menu)
            System.out.println("№ " + dish.getId() + "  "
                    + dish.getDishes() + "  " + dish.getInfo() + "   Price " + dish.getPrice());

    }

    public void getAllByDishAsc() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM Menu i";
        TypedQuery<Menu> typedQuery = entityManager.createQuery(query, Menu.class);
        List<Menu> menu = typedQuery.getResultList();
        for (Menu dish : menu)
            System.out.println("The number of dish № " + dish.getId() + "\n"
                    + dish.getDishes() + "  price is " + dish.getPrice() + "Inforamaition: "
                    + dish.getInfo() + "\n");


    }

    @Override
    public void getAllMenuItemsOrderByNameAsc() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Menu a ORDER BY dishes";
        TypedQuery<Menu> typedQuery = entityManager.createQuery(query, Menu.class);
        List<Menu> menus = typedQuery.getResultList();
        for (Menu menu : menus)
            System.out.println("The id: " + menu.getId() + "  " +menu.getDishes() + "  " + menu.getInfo()
                    + ". Price: " + menu.getPrice());
    }

    @Override
    public void getAllMenuItemsOrderByNameDesc() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Menu a ORDER BY dishes DESC";
        TypedQuery<Menu> typedQuery = entityManager.createQuery(query, Menu.class);
        List<Menu> menus = typedQuery.getResultList();
        for (Menu menu : menus)
            System.out.println("The id: " + menu.getId() + "  " + menu.getDishes() + "  " + menu.getInfo()
                    + ". Price: " + menu.getPrice());
    }

    @Override
    public void getById(int id) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Menu a WHERE a.id = :id1";
        TypedQuery<Menu> typedQuery = entityManager.createQuery(query, Menu.class);
        typedQuery.setParameter("id1", id);
        Menu menu = typedQuery.getSingleResult();
        System.out.println("The id: " + menu.getId() + "  " + menu.getDishes() + "  " + menu.getInfo()
                + " Price: " + menu.getPrice());
    }

    @Override
    public void getMostExpensiveMenuItem() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Menu a WHERE price =(SELECT MAX(price) FROM a)";
        TypedQuery<Menu> typedQuery = entityManager.createQuery(query, Menu.class);
        Menu menu = typedQuery.getSingleResult();
        System.out.println("ID of dish: : " + menu.getId() + "  " + menu.getDishes() + "  " + menu.getInfo()
                + " Price: " + menu.getPrice());
    }

    @Override
    public void getCheapestMenuItem() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Menu a WHERE price =(SELECT MIN (price) FROM a)";
        TypedQuery<Menu> typedQuery = entityManager.createQuery(query, Menu.class);
        Menu menu = typedQuery.getSingleResult();
        System.out.println("ID of dish: : " + menu.getId() + "  " + menu.getDishes() + "  " + menu.getInfo()
                + " Price: " + menu.getPrice());
    }
}
