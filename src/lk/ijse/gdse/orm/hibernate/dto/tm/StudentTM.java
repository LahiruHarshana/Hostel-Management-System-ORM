package lk.ijse.gdse.orm.hibernate.dto.tm;

import java.sql.Date;

public class StudentTM {
    private String id;
    private String name;
    private Date dob;
    private String contact;
    private String address;
    private String gender;

    public StudentTM(String id, String name, Date dob, String contact, String address, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
    }

    public StudentTM() {
    }
}
