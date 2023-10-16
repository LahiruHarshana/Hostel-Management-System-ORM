package lk.ijse.gdse.orm.hibernate.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id",length = 50)
    private String id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "student_contact")
    private String contact;
    @Column(name = "student_dob")
    private Date dob;
    @Column(name = "student_gender")
    private String gender;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "student")
    private List<Reservation> reservations = new ArrayList<>();

    public Student(String sId, String name, String address, String contact, Date dob, String gen) {
        this.name=name;
        this.id=sId;
        this.address=address;
        this.contact=contact;
        this.dob=dob;
        this.gender=gen;
    }

    public Student(String id, String name, String address, String contact, Date dob, String gender, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
        this.reservations = reservations;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", reservations=" + reservations +
                '}';
    }

    public Student() {
    }
}
