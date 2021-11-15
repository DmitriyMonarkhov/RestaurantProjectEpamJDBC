package DAO_Interfaces;

import entity.Menu;

import java.util.List;

public interface Menu_Interface extends CRUD_Interface <Menu>{

    void getAllMenuItemsOrderByNameAsc();
    void getAllMenuItemsOrderByNameDesc();
    void getById(int id);
    void getMostExpensiveMenuItem();
    void getCheapestMenuItem();
}
