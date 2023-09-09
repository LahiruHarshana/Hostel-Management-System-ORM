package lk.ijse.gdse.orm.hibernate.dao.custom;


import lk.ijse.gdse.orm.hibernate.dao.CrudDAO;
import lk.ijse.gdse.orm.hibernate.entity.Reservation;

public interface ReservationDAO extends CrudDAO<Reservation,String> {
    String getNextId();
}
