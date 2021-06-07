package espminvest.poo.user.service;

import espminvest.poo.user.common.datatype.UserBean;
import espminvest.poo.user.model.UserModel;
import espminvest.poo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserBean createUser(UserBean user){
        return userRepository.save(new UserModel(user)).to();
    }

    public UserBean findBy(Integer id) {
        return userRepository
                .findById(id)
                .map(userModel -> userModel.to())
                .orElse(null);
    }

    public List<UserBean> listAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(UserModel::to)
                .collect(Collectors.toList());
    }

}
