package lk.ijse.gdse.orm.hibernate.entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "reservation")
public class Reservation implements SuperEntity{
    @Id
    @Column(name = "reservation_id",length = 50)
    private String reservationID;
    @Column(name = "reservation_date")
    private Date date;
    @Column(name = "reservation_status",length = 50)
    private String status;
    @Column(name = "key_money_exp_date")
    private Date expDate;

    @ManyToOne
            @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
            @JoinColumn(name = "room_id")
    Room room;

   /* @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "reservation")
    List<StudentReservation> reservations = new ArrayList<>();*/

    public Reservation() {
    }

    public Reservation(String reservationID, Date date, String status, Date expDate, Student student, Room room) {
        this.reservationID = reservationID;
        this.date = date;
        this.status = status;
        this.expDate = expDate;
        this.student = student;
        this.room = room;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
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

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
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
                "reservationID='" + reservationID + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", expDate=" + expDate +
                ", student=" + student +
                ", room=" + room +
                '}';
    }
}
