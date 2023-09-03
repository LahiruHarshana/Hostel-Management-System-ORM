package lk.ijse.gdse.orm.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    private String id;
    private String name;
    private String address;
    private String contact_no;



}
