package service;

import dao.classes.MenuDAO;
import entity.Menu;

import java.util.List;

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

    public static List<Menu> getAll () {
        List<Menu> list = menuDAO.getAllMenuItemsOrderByNameAsc();
        System.out.println("\n Menu from database: ");
        list.forEach(System.out::println);
        return list;
    }

    public static List<Menu> getAllMenuItemsOrderByNameAsc() {
        List<Menu> list = menuDAO.getAllMenuItemsOrderByNameAsc();
        System.out.println("\n Menu from database ordering by ASC: ");
        list.forEach(System.out::println);
        return list;}

    public static List<Menu>  getAllMenuItemsOrderByNameDesc() {
        List<Menu> list = menuDAO.getAllMenuItemsOrderByNameDesc();
        System.out.println("\n Menu from database ordering by DESC: ");
        list.forEach(System.out::println);
        return list;
    }

    public static Menu getById(int id) {
        Menu menu = menuDAO.getById(id);
        System.out.println(menu);
        return menu;
    }
    public static Menu getMostExpensiveMenuItem () {
        Menu menu = menuDAO.getMostExpensiveMenuItem();
        System.out.println("The most expensive menu item: " + menu);
        return menu;
    }
}
