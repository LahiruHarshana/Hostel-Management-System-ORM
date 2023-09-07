package lk.ijse.gdse.orm.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "key_money")
    String key_money;

    @Column(name = "qty")
    int qty;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "room")
    List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }

    public Room(String id, String type, String key_money, int qty) {
        this.id = id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getKey_money() {
        return key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKey_money(String key_money) {
        this.key_money = key_money;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", key_money='" + key_money + '\'' +
                ", qty=" + qty +
                '}';
    }
}