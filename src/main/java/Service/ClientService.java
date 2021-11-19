package Service;

import DAO.Classes.ClientDAO;
import entity.Client;

import java.util.List;

public class ClientService {

    private static final ClientDAO clientDAO = new ClientDAO();

    public static int create (Client client) {
        return clientDAO.create(client);
    }
    public static void update (int id, Client client) {
        clientDAO.update(id,client);
    }
    public static void delete (int id) {
        clientDAO.delete(id);
    }
    public static List<Client> getAll() {
        List<Client> list = clientDAO.getAll();
        System.out.println("\n Client clients from database: ");
        list.forEach(System.out::println);
        return list;}

    public static List<Client> getAllbyNameAsc() {
        List<Client> list = clientDAO.getAllbyNameAsc();
        System.out.println("\n Clients from database ordering by ASC: ");
        list.forEach(System.out::println);
        return list;}

    public static List<Client> getAllbyNameDesc () {
        List<Client> list = clientDAO.getAllbyNameDesc();
        System.out.println("\n Clients from database ordering by ASC: ");
        list.forEach(System.out::println);
        return list;}

    public static Client getClientById (int id) {
        Client client = clientDAO.getClientById(id);
        System.out.println(client);
        return client;
    }
    public static Integer getLastID(){
        return clientDAO.getLastID();
    }
}
