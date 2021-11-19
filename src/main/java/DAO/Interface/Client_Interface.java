package DAO.Interface;

import entity.Client;

import java.util.List;

public interface Client_Interface extends CRUD_Interface<Client> {
    List <Client> getAllbyNameAsc();
    List <Client> getAllbyNameDesc();
    Client getClientById(int x);
    }
