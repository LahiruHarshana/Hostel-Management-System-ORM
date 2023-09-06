package lk.ijse.gdse.orm.hibernate.bo.custom.impl;


import lk.ijse.gdse.orm.hibernate.bo.custom.StudentBO;
import lk.ijse.gdse.orm.hibernate.dao.custom.StudentDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<StudentDTO> getAll() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : studentDAO.getAll()) {
            studentDTOS.add(new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender())
            );
        }
        return studentDTOS;
    }

    @Override
    public boolean saveStd(StudentDTO studentDTO) {
        return studentDAO.save(new Student(
                studentDTO.getSId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGen()
        ));
    }

    @Override
    public boolean updateStd(StudentDTO studentDTO) {
        return studentDAO.update(new Student(
                studentDTO.getSId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGen()
        ));
    }

    @Override
    public StudentDTO getStudent(String sid) {
        Student student = studentDAO.getItem(sid);
        if (student!=null){
            return new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender()
            );
        }
        return null;
    }

    @Override
    public boolean deleteStd(String text) {
        return studentDAO.delete(text);
    }
}
