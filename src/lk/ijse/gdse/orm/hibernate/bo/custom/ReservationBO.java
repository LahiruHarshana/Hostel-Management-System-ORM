package lk.ijse.gdse.orm.hibernate.bo.custom;


import lk.ijse.gdse.orm.hibernate.bo.SuperBo;
import lk.ijse.gdse.orm.hibernate.dto.ReservationDTO;
import lk.ijse.gdse.orm.hibernate.dto.RoomDTO;
import lk.ijse.gdse.orm.hibernate.dto.StudentDTO;

import java.util.List;

public interface ReservationBO extends SuperBo {
    List<ReservationDTO> getAllReservation();

   List<String> getRoomIds();

    List<String> getStdId();

    RoomDTO getRoom(String value);

    StudentDTO getStd(String value);

    boolean saveRes(ReservationDTO reservationDTO);

    boolean updateRes(ReservationDTO reservationDTO);

    boolean deleteRes(String text);

    String getNextId();

}
