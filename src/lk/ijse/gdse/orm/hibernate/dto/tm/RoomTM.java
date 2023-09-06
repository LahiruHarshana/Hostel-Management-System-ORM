package lk.ijse.gdse.orm.hibernate.dto.tm;


public class RoomTM {
    private String id;
    private String type;
    private int qty;
    private String keyMoney;

    public RoomTM(String id, String type, int qty, String keyMoney) {
        this.id = id;
        this.type = type;
        this.qty = qty;
        this.keyMoney = keyMoney;
    }

    public RoomTM() {
    }
}
