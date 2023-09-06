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

    public StudentDTO() {
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dob=" + dob +
                ", gen='" + gen + '\'' +
                '}';
    }
}
