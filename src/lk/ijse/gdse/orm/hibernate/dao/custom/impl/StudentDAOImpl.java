package lk.ijse.gdse.orm.hibernate.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.configaration.SessionFactoryConfig;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student dto) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable save = session.save(dto);
            transaction.commit();
            return save != null;
        }
    }

    @Override
    public boolean update(Student dto) {
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
            Student item = session.get(Student.class, id);
            session.delete(item);
            transaction.commit();
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Student> getAll() {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
            query.from(Student.class);
            List<Student> resultList = session.createQuery(query).getResultList();
            transaction.commit();
            return resultList;
        }
    }

    @Override
    public Student getItem(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Student item = session.get(Student.class, id);
            transaction.commit();
            return item;
        }
    }
}
