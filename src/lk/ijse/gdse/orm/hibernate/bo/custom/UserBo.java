package lk.ijse.gdse.orm.hibernate.bo.custom;

import lk.ijse.gdse.orm.hibernate.bo.SuperBo;
import lk.ijse.gdse.orm.hibernate.dto.UserDTO;

public interface UserBo extends SuperBo {

    boolean saveUser(UserDTO userDTO);

    boolean getUser(UserDTO userDTO);
}
