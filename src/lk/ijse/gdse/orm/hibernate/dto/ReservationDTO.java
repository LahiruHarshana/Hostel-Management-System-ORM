package lk.ijse.gdse.orm.hibernate.dto;

import java.sql.Date;

public class ReservationDTO {
    private String resId;
    private Date date;
    private String stdId;
    private String roomId;
    private String sts;
    private String stdNameTxt;
    private String roomType;
    private String keyMoney;

    public ReservationDTO(String resId, Date date, String stdId, String roomId, String sts, String stdNameTxt, String roomType, String keyMoney) {
        this.resId = resId;
        this.date = date;
        this.stdId = stdId;
        this.roomId = roomId;
        this.sts = sts;
        this.stdNameTxt = stdNameTxt;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getStdNameTxt() {
        return stdNameTxt;
    }

    public void setStdNameTxt(String stdNameTxt) {
        this.stdNameTxt = stdNameTxt;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public ReservationDTO() {
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "resId='" + resId + '\'' +
                ", date=" + date +
                ", stdId='" + stdId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", sts='" + sts + '\'' +
                ", stdNameTxt='" + stdNameTxt + '\'' +
                ", roomType='" + roomType + '\'' +
                ", keyMoney='" + keyMoney + '\'' +
                '}';
    }
}
