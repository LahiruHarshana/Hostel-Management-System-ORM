package lk.ijse.gdse.orm.hibernate.dao.custom.impl;


import javafx.scene.control.Alert;
import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.dao.custom.ReservationDAO;
import lk.ijse.gdse.orm.hibernate.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation dto) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable save = session.save(dto);
            transaction.commit();
            return save != null;
        }

    }

    @Override
    public boolean update(Reservation dto) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(dto);
            transaction.commit();
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        }

    }

    @Override
    public boolean delete(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, id);
            session.delete(reservation);
            transaction.commit();
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public Reservation getItem(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, id);
            transaction.commit();
            return reservation;
        }
    }

    @Override
    public String getNextId() {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            String newId = "RES000";
            Transaction transaction = session.beginTransaction();
            List list = session.createNativeQuery("select res_id from reservation order by res_id desc limit 1").list();
            if (!list.isEmpty()) newId = (String) list.get(0);
            transaction.commit();
            session.close();
            return newId;
        }
    }
}
