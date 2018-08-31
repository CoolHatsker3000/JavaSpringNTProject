package services;

import dao.UserTariffDAO;
import entity.UserTariffEntity;
import models.UserTariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTariffService extends AbstractService<UserTariff, UserTariffEntity> {
    @Autowired
    public UserTariffService(UserTariffDAO dao) {
        super(dao);
    }

    @Override
    UserTariffEntity ModelToEntity(UserTariff userTariff) {
        return new UserTariffEntity(userTariff);
    }

    @Override
    UserTariff EntityToModel(UserTariffEntity userTariffEntity) {
        UserTariff userTariff=new UserTariff();
        if (userTariffEntity==null){
            return userTariff;
        }
        userTariff.setUserID(String.valueOf(userTariffEntity.getUserId()));
        userTariff.setTariffID(String.valueOf(userTariffEntity.getTariffId()));
        return userTariff;
    }

    @Override
    long getId(UserTariff userTariff) {
        return Long.parseLong(userTariff.getUserID());
    }

    public void UnsubscribeUsers(int tariffId){
        UserTariffDAO userTariffDAO=(UserTariffDAO) this.currentDAO;
        userTariffDAO.UnsubscribeUsers(tariffId);
    }
}
