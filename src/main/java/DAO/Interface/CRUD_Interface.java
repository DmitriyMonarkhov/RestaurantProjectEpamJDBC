package DAO.Interface;

import java.util.List;

public interface CRUD_Interface <T> {

    int create(T t);
    List <T> getAll();
    void update(int x,T t);
    void delete(int x);
}
