package DAO.Classes;

import DAO.Interface.Menu_Interface;
import DataBase.DB;
import entity.Menu;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO implements Menu_Interface {
    DB db = new DB();

    public int create(Menu menu) {
        try{
            String sql = "INSERT INTO `menu` (dishes, info, price) VALUES (?, ?, ?)";
            PreparedStatement prepSt = db.getDataBaseConnection().prepareStatement(sql);
            prepSt.setString(1, menu.getDishes());
            prepSt.setString(2, menu.getInfo());
            prepSt.setInt(3, menu.getPrice());
            prepSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The dish with name  " + menu.getDishes() +  " and info " +menu.getInfo() + " was created.");
        return menu.getId();
    }

    public void update(int id, Menu menu) {
        try {
            String sql = "UPDATE `menu` SET `dishes` = ?, `info` = ?, `price` = ?, WHERE `id` = ?";

            PreparedStatement prepSt = db.getDataBaseConnection().prepareStatement(sql);
            prepSt.setString(1, menu.getDishes());
            prepSt.setString(2, menu.getInfo());
            prepSt.setInt(3, menu.getPrice());
            prepSt.setInt(4, id);
            prepSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The dish was updated.");
    }

    public void delete(int id) {
        String sql = "DELETE FROM `menu` WHERE `id` = ?";
        try {
            PreparedStatement prepSt = db.getDataBaseConnection().prepareStatement(sql);
            prepSt.setInt(1, id);
            prepSt.executeUpdate();
            System.out.println("Dish has been deleted.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List <Menu> getAll() {
        ResultSet resultSet =null;
        Menu menu;
        List<Menu> list = new ArrayList<>();
        String sql = "SELECT * FROM `menu`";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)){
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                menu = new Menu();
                menu.setId(resultSet.getInt("id"));
                menu.setDishes(resultSet.getString("dishes"));
                menu.setInfo(resultSet.getString("info"));
                menu.setPrice(resultSet.getInt("price"));
                list.add(menu);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if(resultSet !=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    public List <Menu> getAllMenuItemsOrderByNameAsc() {
        ResultSet resultSet =null;
        Menu menu;
        List<Menu> list = new ArrayList<>();
        String sql = "SELECT * FROM `menu` ORDER BY `dishes`";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)){
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                menu = new Menu();
                menu.setId(resultSet.getInt("id"));
                menu.setDishes(resultSet.getString("dishes"));
                menu.setInfo(resultSet.getString("info"));
                menu.setPrice(resultSet.getInt("price"));
                list.add(menu);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if(resultSet !=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public List <Menu> getAllMenuItemsOrderByNameDesc() {
        ResultSet resultSet =null;
        Menu menu;
        List<Menu> list = new ArrayList<>();
        String sql = "SELECT * FROM `menu` ORDER BY `dishes` DESC ";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)){
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                menu = new Menu();
                menu.setId(resultSet.getInt("id"));
                menu.setDishes(resultSet.getString("dishes"));
                menu.setInfo(resultSet.getString("info"));
                menu.setPrice(resultSet.getInt("price"));
                list.add(menu);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if(resultSet !=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public Menu getById (int id) {
        ResultSet resultSet = null;
        Menu menu = new Menu();
        String sql = "SELECT * FROM `menu` WHERE id = ?";
        try (PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                menu.setId(resultSet.getInt("id"));
                menu.setDishes(resultSet.getString("dishes"));
                menu.setInfo(resultSet.getString("info"));
                menu.setPrice(resultSet.getInt("price"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return menu;
    }

    public Menu getMostExpensiveMenuItem() {
        ResultSet resultSet = null;
        Menu menu = new Menu();
        String sql = "SELECT * FROM `menu` WHERE price =(SELECT MAX(price) FROM `menu`);";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)) {
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                menu.setId(resultSet.getInt("id"));
                menu.setDishes(resultSet.getString("dishes"));
                menu.setInfo(resultSet.getString("info"));
                menu.setPrice(resultSet.getInt("price"));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return menu;
    }

}
