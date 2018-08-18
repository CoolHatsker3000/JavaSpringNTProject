package services;

import dao.OperationsServiceImpl;
import dao.UserDAO;
import entity.UserEntity;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService extends AbstractService<User, UserEntity> {

    @Autowired
    public UserService(UserDAO dao) {
        super(dao);
    }

    @Override
    UserEntity ModelToEntity(User user) {
        return new UserEntity(user);
    }

    @Override
    User EntityToModel(UserEntity userEntity) {
        User user=new User();
        user.setUserId(String.valueOf(userEntity.getUserId()));
        user.setUserBalance(String.valueOf(userEntity.getUserBalance()));
        return user;
    }

    @Override
    long getId(User user) {
        return Long.valueOf(user.getUserId());
    }


}
