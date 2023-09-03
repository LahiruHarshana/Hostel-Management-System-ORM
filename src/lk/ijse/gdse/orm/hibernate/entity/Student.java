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
    private String contact_no;
    private Date dob;
    private String gender;

}
