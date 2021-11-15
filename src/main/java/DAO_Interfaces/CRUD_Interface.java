package DAO_Interfaces;

import java.util.List;

public interface CRUD_Interface <T> {

    int create(T t);
    void getAll();
    void update(int x,T t);
    void delete(int x);
}
