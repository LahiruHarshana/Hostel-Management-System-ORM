package lk.ijse.gdse.orm.hibernate.entity;


import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "res_id",length = 50)
    private String id;
    @Column(name = "res_date",columnDefinition = "date")
    private Date date;
    @Column(name = "res_status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "student_type_id",
            referencedColumnName = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "room_id",
            referencedColumnName = "room_id")
    private Room room;

    public Reservation(String id, Date date, String status, Student student, Room room) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
    }

    public Reservation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", room=" + room +
                '}';
    }
}
