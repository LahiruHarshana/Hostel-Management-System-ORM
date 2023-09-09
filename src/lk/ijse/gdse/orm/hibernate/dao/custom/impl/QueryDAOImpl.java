package lk.ijse.gdse.orm.hibernate.dao.custom.impl;

import lk.ijse.gdse.orm.hibernate.dao.custom.QueryDAO;
import lk.ijse.gdse.orm.hibernate.dto.ReservationDTO;

import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<ReservationDTO> getAllReservation() {
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            List<Object[]> list = session.createNativeQuery("select r.res_id,r.res_date,r.res_status,o.room_key_money,r.room_id,r.student_type_id,o.room_type,s.student_name from room o INNER JOIN reservation r ON o.room_id=r.room_id INNER JOIN student s  ON r.student_type_id=s.student_id;").list();

            transaction.commit();
            session.close();
            if (list.isEmpty()) {
                System.out.println("empty");
            } else {
                for (Object[] objects : list) {
                    reservationDTOS.add(new ReservationDTO(
                            (String) objects[0],
                            (Date) objects[1],
                            (String) objects[5],
                            (String) objects[4],
                            (String) objects[2],
                            (String) objects[7],
                            (String) objects[6],
                            (String) objects[3]
                    ));
                }
            }
            return reservationDTOS;
        }
    }

}
