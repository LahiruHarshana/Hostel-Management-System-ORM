package lk.ijse.gdse.orm.hibernate.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.dao.custom.RoomDAO;
import lk.ijse.gdse.orm.hibernate.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room dto) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable save = session.save(dto);
            transaction.commit();
            return save != null;
        }
    }

    @Override
    public boolean update(Room dto) {
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
            Room room = session.get(Room.class, id);
            session.delete(room);
            transaction.commit();
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Room> getAll() {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Room> query = criteriaBuilder.createQuery(Room.class);
            query.from(Room.class);
            List<Room> resultList = session.createQuery(query).getResultList();
            transaction.commit();
            return resultList;
        }
    }

    @Override
    public Room getItem(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Room room = session.get(Room.class, id);
            transaction.commit();
            return room;
        }
    }
}
