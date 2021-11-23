package dao.interfaces;

import entity.Menu;

import java.util.List;

public interface MenuInterface extends CRUDInterface<Menu> {

    List <Menu> getAllMenuItemsOrderByNameAsc();
    List <Menu> getAllMenuItemsOrderByNameDesc();
    Menu getById(int id);
    Menu getMostExpensiveMenuItem();
}
