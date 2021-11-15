package DAO;

import DAO_Interfaces.Client_Interface;
import entity.Client;
import entity.Menu;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ClientDAO implements Client_Interface {

    private static final EntityManagerFactory MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("Restaurant_DB");
    @PersistenceContext
    private EntityManager entityManager;


    public int create(Client client) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(client);
        entityTransaction.commit();
        System.out.println("Your temporary account has been created to place an order with id " + client.getId());
        return client.getId();

    }

    public void update(int id, Client client) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Client edit_Client = entityManager.find(Client.class, id);
        edit_Client.setName(client.getName());
        edit_Client.setPhone(client.getPhone());
        entityManager.persist(edit_Client);
        entityTransaction.commit();
        System.out.println("The client information was changed.");
    }

    public void delete(int id) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Client client = entityManager.find(Client.class, id);
        entityManager.remove(client);
        entityTransaction.commit();
        System.out.println("The client with id " + client.getId() + " called "
                + client.getName() + " with phone " + client.getPhone() + " is delete.");
    }

    public void getAll() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Client a";
        TypedQuery<Client> typedQuery = entityManager.createQuery(query, Client.class);
        List<Client> clients = typedQuery.getResultList();
        for (Client client : clients)
            System.out.println("The number of client № " + client.getId() + ". The name is "
                    + client.getName() + ". The number phone is: " + client.getPhone());
    }

    public void getAllbyNameAsc() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Client a ORDER BY name";
        TypedQuery<Client> typedQuery = entityManager.createQuery(query, Client.class);
        List<Client> clients = typedQuery.getResultList();
        for (Client client : clients)
            System.out.println("The id: " + client.getId() + ". The name is "
                    + client.getName() + ". The number phone is: " + client.getPhone());
    }

    public void getAllbyNameDesc() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Client a ORDER BY name DESC";
        TypedQuery<Client> typedQuery = entityManager.createQuery(query, Client.class);
        List<Client> clients = typedQuery.getResultList();
        for (Client client : clients)
            System.out.println("The id: " + client.getId() + ". The name is "
                    + client.getName() + ". The number phone is: " + client.getPhone() + "\n");
    }
    public void getClientById(int id) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT a FROM Client a WHERE a.id = :id1";
        TypedQuery<Client> typedQuery = entityManager.createQuery(query, Client.class);
        typedQuery.setParameter("id1", id);
        Client client = typedQuery.getSingleResult();
        System.out.println("The id: " + client.getId() + ". The name is "
                + client.getName() + ". The number phone is: " + client.getPhone() + "\n");
    }

    }