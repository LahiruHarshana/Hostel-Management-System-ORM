package lk.ijse.gdse.orm.hibernate.bo.custom;


import lk.ijse.gdse.orm.hibernate.bo.SuperBo;
import lk.ijse.gdse.orm.hibernate.dto.StudentDTO;

public interface StudentBO extends SuperBo {
    List<StudentDTO> getAll();

    boolean saveStd(StudentDTO studentDTO);

    boolean updateStd(StudentDTO studentDTO);

    StudentDTO getStudent(String sid);

    boolean deleteStd(String text);
}
