package lk.ijse.gdse.orm.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//hi
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id",length = 50)
    private String id;
    @Column(name = "room_type")
    private String type;
    @Column(name = "room_key_money")
    private String key_money;
    @Column(name = "room_qty")
    private int qty;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "room")
    private List<Reservation> reservations = new ArrayList<>();

    public Room(String id, String type, String keyMoney, int qty) {
        this.id=id;
        this.type=type;
        this.key_money=keyMoney;
        this.qty=qty;
    }

    public Room(String id, String type, String key_money, int qty, List<Reservation> reservations) {
        this.id = id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
        this.reservations = reservations;
    }

    public Room() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey_money() {
        return key_money;
    }

    public void setKey_money(String key_money) {
        this.key_money = key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", key_money='" + key_money + '\'' +
                ", qty=" + qty +
                ", reservations=" + reservations +
                '}';
    }
}
