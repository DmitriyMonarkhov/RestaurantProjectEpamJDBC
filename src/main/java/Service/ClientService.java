package Service;

import DAO.ClientDAO;
import entity.Client;

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
    public static void getAll () {
        clientDAO.getAll();
    }
    public static void getAllbyNameAsc () {clientDAO.getAllbyNameAsc();}
    public static void getAllbyNameDesc () {clientDAO.getAllbyNameDesc();}
    public static void getClientById (int id) {clientDAO.getClientById(id);}

}
