package lk.ijse.gdse.orm.hibernate.bo.custom.impl;

import lk.ijse.gdse.orm.hibernate.bo.custom.ReservationBO;
import lk.ijse.gdse.orm.hibernate.dao.DAOFactory;
import lk.ijse.gdse.orm.hibernate.dao.custom.QueryDAO;
import lk.ijse.gdse.orm.hibernate.dao.custom.ReservationDAO;
import lk.ijse.gdse.orm.hibernate.dao.custom.RoomDAO;
import lk.ijse.gdse.orm.hibernate.dao.custom.StudentDAO;
import lk.ijse.gdse.orm.hibernate.dto.ReservationDTO;
import lk.ijse.gdse.orm.hibernate.dto.RoomDTO;
import lk.ijse.gdse.orm.hibernate.dto.StudentDTO;
import lk.ijse.gdse.orm.hibernate.entity.Reservation;
import lk.ijse.gdse.orm.hibernate.entity.Room;
import lk.ijse.gdse.orm.hibernate.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    ReservationDAO reservationDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);
    QueryDAO queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    @Override
    public List<ReservationDTO> getAllReservation() {
        List<ReservationDTO> reservationDTOS = queryDAO.getAllReservation();
        return reservationDTOS;
    }

    @Override
    public List<String> getRoomIds() {
        List<String> roomIds = new ArrayList<>();
        for (Room room : roomDAO.getAll()) {
            roomIds.add(room.getId());
        }
        return roomIds;
    }

    @Override
    public List<String> getStdId() {
        List<String> stIds = new ArrayList<>();
        for (Student student : studentDAO.getAll()) {
            stIds.add(student.getId());
        }
        return stIds;
    }

    @Override
    public RoomDTO getRoom(String value) {
        Room room = roomDAO.getItem(value);
        return new RoomDTO(
                room.getId(),
                room.getType(),
                room.getQty(),
                room.getKey_money());
    }

    @Override
    public StudentDTO getStd(String value) {
        Student student = studentDAO.getItem(value);
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender()
        );
    }
    @Override
    public boolean saveRes(ReservationDTO reservationDTO) {
        Student student = studentDAO.getItem(reservationDTO.getStdId());
        Room room = roomDAO.getItem(reservationDTO.getRoomId());
        room.setQty(room.getQty() - 1);

        if (roomDAO.update(room)) {
            return reservationDAO.save(new Reservation(
                    reservationDTO.getResId(),
                    reservationDTO.getDate(),
                    reservationDTO.getSts(),
                    student,
                    room
            ));
        }
        return false;
    }
    @Override
    public boolean updateRes(ReservationDTO reservationDTO) {
        Reservation reservation=reservationDAO.getItem(reservationDTO.getResId());
        reservation.setStatus(reservationDTO.getSts());
        reservation.setDate(reservationDTO.getDate());
        return reservationDAO.update(reservation);
    }

    @Override
    public boolean deleteRes(String text) {
        return reservationDAO.delete(text);
    }

    @Override
    public String getNextId() {
        String id = reservationDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("RES", "")) + 1;
        return String.format("RES%03d", newId);
    }

}
