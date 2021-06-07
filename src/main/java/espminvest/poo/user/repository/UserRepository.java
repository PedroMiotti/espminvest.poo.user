package espminvest.poo.user.repository;

import espminvest.poo.user.common.datatype.UserBean;
import espminvest.poo.user.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, Integer>  {

    @Override
    UserModel save(UserModel user);

    @Override
    Optional<UserModel> findById(Integer id);

    @Override
    Iterable<UserModel> findAll();

    @Override
    void deleteById(Integer id);

}
