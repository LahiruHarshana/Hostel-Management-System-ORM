package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Reservation;
import lk.ijse.gdse.orm.hibernate.entity.Room;
import lk.ijse.gdse.orm.hibernate.entity.Student;
import lk.ijse.gdse.orm.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();
    }
    public static SessionFactoryConfig getInstance(){
        return (null== factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
