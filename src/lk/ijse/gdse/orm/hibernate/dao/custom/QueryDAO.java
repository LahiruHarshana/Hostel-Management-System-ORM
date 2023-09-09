package lk.ijse.gdse.orm.hibernate.dao.custom;


import lk.ijse.gdse.orm.hibernate.dao.SuperDAO;
import lk.ijse.gdse.orm.hibernate.dto.ReservationDTO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<ReservationDTO> getAllReservation();
}
