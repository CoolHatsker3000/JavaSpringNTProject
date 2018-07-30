package DAO.interfaces;

import entity.TariffInfoEntity;

import java.util.List;

public interface TariffInfoDAO {
    public List<TariffInfoEntity> getAll();
    public TariffInfoEntity get(int tariff_id,int attr_id);
    public boolean add(TariffInfoEntity tariffInfoEntity);
    public boolean del(TariffInfoEntity tariffInfoEntity);
    public boolean update(TariffInfoEntity tariffInfoEntity);
}
