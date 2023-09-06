package lk.ijse.gdse.orm.hibernate.dto;

public class UserDTO {
    private String userName;
    private String password;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
