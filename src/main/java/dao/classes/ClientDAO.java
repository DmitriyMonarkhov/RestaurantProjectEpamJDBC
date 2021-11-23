package dao.classes;

import dao.interfaces.ClientInterface;
import dataBase.DB;
import entity.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements ClientInterface {
    DB db = new DB();

    public int create(Client client) {
            try{
                String sql = "INSERT INTO `client` (name, phone) VALUES (?, ?)";
                PreparedStatement prepSt = db.getDataBaseConnection().prepareStatement(sql);
                prepSt.setString(1, client.getName());
                prepSt.setString(2, client.getPhone());
                prepSt.executeUpdate();
            }catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        return client.getId();
    }

    public void update(int id, Client client) {
    }

    public void delete(int id) {
        String sql = "DELETE FROM `client` WHERE `id` = ?";
        try {
            PreparedStatement prepSt = db.getDataBaseConnection().prepareStatement(sql);
            prepSt.setInt(1, id);
            prepSt.executeUpdate();
            System.out.println("Сlient has been deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getAll() {
        ResultSet resultSet =null;
        Client client;
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM `client`";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)){
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setPhone(resultSet.getString("phone"));
                list.add(client);
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

    public List<Client> getAllbyNameAsc() {
        ResultSet resultSet =null;
        Client client;
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM `client` ORDER BY `name`";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)){
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setPhone(resultSet.getString("phone"));
                list.add(client);
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

    public List<Client> getAllbyNameDesc() {
        ResultSet resultSet =null;
        Client client;
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM `client` ORDER BY `name` DESC";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)){
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setPhone(resultSet.getString("phone"));
                list.add(client);
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
    public Client getClientById(int id) {
        ResultSet resultSet = null;
        Client client = new Client();
        String sql = "SELECT * FROM `client` WHERE id = ?";
        try (PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setPhone(resultSet.getString("phone"));
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
        return client;
    }
    public Integer getLastID() {
        ResultSet resultSet =null;
        int id = 0;
        String sql = "SELECT MAX(`id`) FROM `client`;";
        try(PreparedStatement statement = db.getDataBaseConnection().prepareStatement(sql)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (SQLException | ClassNotFoundException e){
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
        return id;
    }
    }