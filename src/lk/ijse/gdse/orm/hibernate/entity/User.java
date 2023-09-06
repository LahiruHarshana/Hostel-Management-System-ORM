package lk.ijse.gdse.orm.hibernate.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "usr_name",length = 50)
    private String usrName;
    @Column(name = "usr_pw")
    private String password;

    public User(String usrName, String password) {
        this.usrName = usrName;
        this.password = password;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "usrName='" + usrName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
