package lk.ijse.gdse.orm.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_type_id")
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "key_money")
    String key_money;

    @Column(name = "qty")
    int qty;

}