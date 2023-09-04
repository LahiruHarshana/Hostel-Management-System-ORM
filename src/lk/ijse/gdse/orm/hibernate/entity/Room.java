package lk.ijse.gdse.orm.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
@Column(name = "room_type")
    String id;
}