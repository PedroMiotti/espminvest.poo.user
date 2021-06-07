package espminvest.poo.user.model;

import espminvest.poo.user.common.datatype.UserBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserModel {

    @Id
    private int user_id;
    private String user_name;

    public UserModel(){}

    public UserModel(UserBean user){
        this.user_id = user.getId();
        this.user_name = user.getName();
    }

    public UserBean to() {
        UserBean user = new UserBean();
        user.setName(user_name);
        return user;
    }

}
