package lk.ijse.gdse.orm.hibernate.dto.tm;

import java.sql.Date;

public class ReservationTM {
    private String resId;
    private String roomId;
    private String stdId;
    private String stdName;
    private Date date;
    private String keyMoney;
    private String sts;
    private Date exDate;


    public ReservationTM(String resId, String roomId, String stdId, String stdName, Date date, String keyMoney, String sts, Date exDate) {
        this.resId = resId;
        this.roomId = roomId;
        this.stdId = stdId;
        this.stdName = stdName;
        this.date = date;
        this.keyMoney = keyMoney;
        this.sts = sts;
        this.exDate = exDate;
    }

    public ReservationTM() {
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public Date getExDate() {
        return exDate;
    }

    public void setExDate(Date exDate) {
        this.exDate = exDate;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ReservationTM{" +
                "resId='" + resId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", stdId='" + stdId + '\'' +
                ", stdName='" + stdName + '\'' +
                ", date=" + date +
                ", keyMoney='" + keyMoney + '\'' +
                ", sts='" + sts + '\'' +
                ", exDate=" + exDate +
                '}';
    }

}
