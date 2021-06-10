package espminvest.poo.user.rest;

import espminvest.poo.user.common.controller.UserController;
import espminvest.poo.user.common.datatype.UserBean;
import espminvest.poo.user.exception.RecordNotFoundException;
import espminvest.poo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public UserBean saveUser(UserBean user) {
        UserBean savedUser = userService.createUser(user);

        return savedUser;
    }

    @Override
    public UserBean getUserById(String id) {
        Integer userId = Integer.parseInt(id);
        UserBean foundUser = Optional.ofNullable(userService.findBy(userId)).orElseThrow();

        // ERROR -> When user not found not throwing exception (use try catch ?)
        if(foundUser == null){
            throw new RecordNotFoundException(id.toString());
        }

        return foundUser;
    }

    @Override
    public List<UserBean> getUsers() {
        return userService.listAll();
    }

    @Override
    public void deleteUser(String id) {
        Integer userId = Integer.parseInt(id);
        userService.delete(userId);
    }
}
