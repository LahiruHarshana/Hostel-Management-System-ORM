package lk.ijse.gdse.orm.hibernate.bo.custom;


import lk.ijse.gdse.orm.hibernate.bo.SuperBo;
import lk.ijse.gdse.orm.hibernate.dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBo {
    List<RoomDTO> getAll();

    boolean saveRoom(RoomDTO roomDTO);

    boolean updateRoom(RoomDTO roomDTO);

    RoomDTO getRoom(String rid);

    boolean deleteRoom(String text);
}
