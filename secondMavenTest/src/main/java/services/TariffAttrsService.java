package services;

import dao.OperationsServiceImpl;
import dao.TariffAttrDAO;
import entity.TariffAttrEntity;
import models.TariffAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TariffAttrsService extends AbstractService<TariffAttr, TariffAttrEntity> {
    @Autowired
    public TariffAttrsService(TariffAttrDAO dao) {
        super(dao);
    }

    @Override
    TariffAttrEntity ModelToEntity(TariffAttr tariffAttr) {
        return new TariffAttrEntity(tariffAttr);
    }

    @Override
    TariffAttr EntityToModel(TariffAttrEntity tariffAttrEntity) {
        TariffAttr tariffAttr=new TariffAttr();
        tariffAttr.setAttrId(String.valueOf(tariffAttrEntity.getAttrId()));
        tariffAttr.setAttrName(tariffAttrEntity.getAttrName());
        return tariffAttr;
    }

    @Override
    long getId(TariffAttr tariffAttr) {
        return Integer.parseInt(tariffAttr.getAttrId());
    }
}
