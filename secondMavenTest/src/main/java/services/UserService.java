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
    protected UserEntity ModelToEntity(User user) {
        return new UserEntity(user);
    }

    @Override
    protected User EntityToModel(UserEntity userEntity) {
        User user=new User();
        if (userEntity==null){
            return user;
        }
        user.setUserId(String.valueOf(userEntity.getUserId()));
        user.setUserPassword(userEntity.getUserPassword());
        user.setUserBalance(String.valueOf(userEntity.getUserBalance()));
        return user;
    }

    @Override
    protected long getId(User user) {
        return Long.valueOf(user.getUserId());
    }

    public User selectUser(User user){
        user.setUserBalance("0.0");
        UserDAO dao=(UserDAO) this.currentDAO;
        User result=EntityToModel(dao.selectUser(ModelToEntity(user)));
        return result;
    }


}
