package lk.ijse.gdse.orm.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private String id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_address")
    private String address;
    @Column(name = "contact_num")
    private String contact_num;
    @Column(name = "student_dob")
    private Date dob;
    @Column(name = "student_gender")
    private String gender;

    public Student() {
    }

    public Student(String id, String name, String address, String contact_num, Date dob, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact_num = contact_num;
        this.dob = dob;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
