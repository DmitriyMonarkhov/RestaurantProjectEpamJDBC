package DAO_Interfaces;

import entity.Order;

import java.util.List;

public interface Order_Interface <T> {
    int create(T t);
    void getOrders ();
    }

