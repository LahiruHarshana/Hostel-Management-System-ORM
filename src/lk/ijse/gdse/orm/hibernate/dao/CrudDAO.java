package lk.ijse.gdse.orm.hibernate.dao;

import java.util.List;

public interface CrudDAO<T,J> extends SuperDAO{
    boolean save(T dto);
    boolean update(T dto);
    boolean delete(J id);
    List<T> getAll();
    T getItem(J id);
}
