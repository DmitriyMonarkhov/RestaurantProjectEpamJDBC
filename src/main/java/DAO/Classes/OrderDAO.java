package DAO.Classes;

import DAO.Interface.Order_Interface;
import DataBase.DB;
import entity.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderDAO implements Order_Interface<Order> {
    DB db = new DB();

    public boolean create(Order order) {
        try {
            String sql = "INSERT INTO `orders` (client_id, menu_id) VALUES (?, ?)";
            PreparedStatement prepSt = db.getDataBaseConnection().prepareStatement(sql);
            prepSt.setInt(1, order.getClient_id());
            prepSt.setInt(2, order.getMenu_id());
            prepSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The order was created.");
        return true;
    }

    public List<Order> getOrders() {
        ResultSet resultSet = null;
        Order order;
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM `orders`";
        try (PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient_id(resultSet.getInt("client_id"));
                order.setMenu_id(resultSet.getInt("menu_id"));
                list.add(order);
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
        return list;
    }
    public List<Order> getAllOrderWithCostByCost() {
        List<Order> list = new ArrayList<>();
        ResultSet resultSet = null;
        Order order;
        String sql = "SELECT orders.id, price FROM `orders` INNER JOIN `menu` ON menu.id = orders.menu_id ORDER BY price";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                order = new Order();
                order.setId(resultSet.getInt(1));
                order.setMenu_id(resultSet.getInt(2));
                list.add(order);
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
        return list;
    }
}