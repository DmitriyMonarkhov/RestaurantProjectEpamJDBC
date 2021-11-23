package dao.interfaces;

import entity.Client;

import java.util.List;

public interface ClientInterface extends CRUDInterface<Client> {
    List <Client> getAllbyNameAsc();
    List <Client> getAllbyNameDesc();
    Client getClientById(int x);
    }
