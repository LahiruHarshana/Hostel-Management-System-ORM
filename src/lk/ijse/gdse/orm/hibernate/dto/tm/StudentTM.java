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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
