package lk.ijse.gdse.orm.hibernate.bo;

import java.util.List;

public interface CrudBO<T,J> extends SuperBo{

    boolean save(T t);

    boolean update(T t);

    boolean delete(J j);

    T find(J j);

    List<T> getAll();

}
