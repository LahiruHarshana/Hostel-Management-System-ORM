package lk.ijse.gdse.orm.hibernate.dto;


import java.sql.Date;

public class StudentDTO {
    private String sId;
    private String name;
    private String address;
    private String contact;
    private Date dob;
    private String gen;

    public StudentDTO(String sId, String name, String address, String contact, Date dob, String gen) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gen = gen;
    }
}
