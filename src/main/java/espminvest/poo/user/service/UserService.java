package espminvest.poo.user.service;

import espminvest.poo.user.common.datatype.UserBean;
import espminvest.poo.user.model.UserModel;
import espminvest.poo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserBean createUser(UserBean user){
        return userRepository.save(new UserModel(user)).toBean();
    }

    public UserBean findBy(Integer id) {
        return userRepository.findById(id).get().toBean();
    }

    public List<UserBean> listAll() {
        // ERROR -> Returning all the users with the same id
        return userRepository.findAll()
                .stream()
                .map(userModel -> userModel.toBean())
                .collect(Collectors.toList());
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

}
