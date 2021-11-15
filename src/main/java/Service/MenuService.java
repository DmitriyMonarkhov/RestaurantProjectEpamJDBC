package Service;

import DAO.MenuDAO;
import entity.Menu;

public class MenuService {

    private static final MenuDAO menuDAO = new MenuDAO();

    public static int create (Menu menu) {
        return menuDAO.create(menu);
    }
    public static void update (int id, Menu menu) {
        menuDAO.update(id,menu);
    }
    public static void delete (int id) {
        menuDAO.delete(id);
    }
    public static void getAll () {menuDAO.getAll();}
    public static void getAllMenuItemsOrderByNameAsc() {menuDAO.getAllMenuItemsOrderByNameAsc();} ;
    public static void getAllMenuItemsOrderByNameDesc() {menuDAO.getAllMenuItemsOrderByNameDesc();};
    public static void getById(int id) {menuDAO.getById(id);};
    public static void getMostExpensiveMenuItem (){menuDAO.getMostExpensiveMenuItem();}
    public static void getCheapestMenuItem (){menuDAO.getCheapestMenuItem();}



}
