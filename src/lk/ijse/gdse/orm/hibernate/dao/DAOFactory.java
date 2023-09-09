package lk.ijse.gdse.orm.hibernate.dao;


import lk.ijse.gdse.orm.hibernate.dao.custom.impl.RoomDAOImpl;
import lk.ijse.gdse.orm.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.gdse.orm.hibernate.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes{
        USER, STUDENT, ROOM,RESERVATIONDAO
    }

    public <T extends SuperDAO>T getDAO(DAOTypes types){
        switch (types){
            case USER:
                return (T) new UserDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case ROOM:
                return (T) new RoomDAOImpl();
            default:
                return null;
        }
    }
}
