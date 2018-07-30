package DAO.interfaces;

import entity.TariffAttrEntity;

import java.util.List;

public interface TariffAttrDAO {
    public List<TariffAttrEntity> getAll();
    public TariffAttrEntity get(int id);
    public boolean add(TariffAttrEntity tariffAttrEntity);
    public boolean del(TariffAttrEntity tariffAttrEntity);
    public boolean update(TariffAttrEntity tariffAttrEntity);
}
