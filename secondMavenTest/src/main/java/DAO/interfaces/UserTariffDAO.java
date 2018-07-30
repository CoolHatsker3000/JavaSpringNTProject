package DAO.interfaces;

import entity.UserTariffEntity;

import java.util.List;

public interface UserTariffDAO {
    public List<UserTariffEntity> getAll();
    public UserTariffEntity getTariffByUserID(long user_id);
    public List<UserTariffEntity> getUsersByTariffID(int tariff_id);
    public boolean isIn(long user_id, int tariff_id);
    public boolean add(UserTariffEntity tariffInfoEntity);
    public boolean del(UserTariffEntity tariffInfoEntity);
    public boolean update(UserTariffEntity tariffInfoEntity);
}
