package lk.ijse.gdse.orm.hibernate.dto;

public class RoomDTO {
    private String id;
    private String type;
    private int qty;
    private String keyMoney;

    public RoomDTO(String id, String type, int qty, String keyMoney) {
        this.id = id;
        this.type = type;
        this.qty = qty;
        this.keyMoney = keyMoney;
    }
}
