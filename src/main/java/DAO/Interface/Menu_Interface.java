package DAO.Interface;

import entity.Menu;

import java.util.List;

public interface Menu_Interface extends CRUD_Interface<Menu> {

    List <Menu> getAllMenuItemsOrderByNameAsc();
    List <Menu> getAllMenuItemsOrderByNameDesc();
    Menu getById(int id);
    Menu getMostExpensiveMenuItem();
}
