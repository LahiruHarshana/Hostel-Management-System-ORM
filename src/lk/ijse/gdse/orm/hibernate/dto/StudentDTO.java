package lk.ijse.gdse.orm.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class StudentDTO {
    private String sId;
    private String name;
    private String address;
    private String contact;
    private Date dob;
    private String gen;

}
