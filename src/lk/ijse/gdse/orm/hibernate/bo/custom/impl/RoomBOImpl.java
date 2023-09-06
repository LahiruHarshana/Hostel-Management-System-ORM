package lk.ijse.gdse.orm.hibernate.bo.custom.impl;


import lk.ijse.gdse.orm.hibernate.bo.custom.RoomBO;
import lk.ijse.gdse.orm.hibernate.dao.custom.RoomDAO;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public List<RoomDTO> getAll() {
        List<RoomDTO> roomDTOS = new ArrayList<>();
        for (Room room : roomDAO.getAll()) {
            roomDTOS.add(new RoomDTO(
                    room.getId(),
                    room.getType(),
                    room.getQty(),
                    room.getKey_money()
            ));
        }
        return roomDTOS;
    }

    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        return roomDAO.save(new Room(
                roomDTO.getId(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty()
        ));
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        return roomDAO.update(new Room(
                roomDTO.getId(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty()
        ));
    }

    @Override
    public RoomDTO getRoom(String rid) {
        Room room = roomDAO.getItem(rid);
        if (room!=null){
            return new RoomDTO(
                    room.getId(),
                    room.getType(),
                    room.getQty(),
                    room.getKey_money()
            );
        }
        return null;
    }

    @Override
    public boolean deleteRoom(String text) {
        return roomDAO.delete(text);
    }

}
