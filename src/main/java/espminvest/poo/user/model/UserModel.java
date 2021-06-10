package espminvest.poo.user.model;

import espminvest.poo.user.common.datatype.UserBean;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int user_id;
    private String user_name;

    public UserModel(){}

    public UserModel(UserBean user){
        this.user_name = user.getName();
    }

    public UserBean toBean() {
        UserBean user = new UserBean();
        user.setId(user_id);
        user.setName(user_name);
        return user;
    }

}
