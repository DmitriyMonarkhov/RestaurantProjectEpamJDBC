package DAO_Interfaces;

import entity.Client;

public interface Client_Interface extends CRUD_Interface <Client>{
    void getAllbyNameAsc();
    void getAllbyNameDesc();
    void getClientById(int x);
    }
