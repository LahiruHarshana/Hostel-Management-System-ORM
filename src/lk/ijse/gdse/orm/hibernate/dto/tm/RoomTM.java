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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    @Override
    public String toString() {
        return "RoomTM{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", qty=" + qty +
                ", keyMoney='" + keyMoney + '\'' +
                '}';
    }
}
