package DAO.interfaces;

import entity.TariffEntity;

import java.util.List;

public interface TariffDAO {
    public List<TariffEntity> getAll();
    public TariffEntity get(int id);
    public boolean add(TariffEntity tariffEntity);
    public boolean del(TariffEntity tariffEntity);
    public boolean update(TariffEntity tariffEntity);
}
