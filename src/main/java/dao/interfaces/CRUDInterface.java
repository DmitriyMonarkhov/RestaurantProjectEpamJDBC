package dao.interfaces;

import java.util.List;

public interface CRUDInterface<T> {

    int create(T t);
    List <T> getAll();
    void update(int x,T t);
    void delete(int x);
}
