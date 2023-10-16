package lk.ijse.gdse.orm.hibernate.bo.custom.impl;

import lk.ijse.gdse.orm.hibernate.bo.custom.UserBo;
import lk.ijse.gdse.orm.hibernate.dao.DAOFactory;
import lk.ijse.gdse.orm.hibernate.dao.custom.UserDAO;
import lk.ijse.gdse.orm.hibernate.dto.UserDTO;
import lk.ijse.gdse.orm.hibernate.entity.User;

public class UserBoImpl implements UserBo {
    UserDAO userDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveUser(UserDTO userDTO) {
        return userDAO.save(new User(
                userDTO.getUserName(),
                userDTO.getPassword()
        ));
    }

    @Override
    public UserDTO getUser(UserDTO userDTO) {
        User user= userDAO.getItem(userDTO.getUserName());
        if (user.getUsrName().equals(userDTO.getUserName())){
            return new UserDTO(user.getUsrName(),user.getPassword()) ;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean uptdUsr(UserDTO userDTO) {
        return userDAO.update(new User(
                userDTO.getUserName(),
                userDTO.getPassword()
        ));
    }
}
