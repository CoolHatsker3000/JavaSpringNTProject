package services;

import dao.TariffDAO;
import entity.TariffEntity;
import models.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TariffService extends AbstractService<Tariff, TariffEntity> {

    @Autowired
    public TariffService(TariffDAO dao){
        super(dao);
    }

    @Override
    protected TariffEntity ModelToEntity(Tariff tariff) {
        return new TariffEntity(tariff);
    }

    @Override
    protected Tariff EntityToModel(TariffEntity tariffEntity) {
        Tariff tariff=new Tariff();
        tariff.setTariffId(String.valueOf(tariffEntity.getTariffId()));
        tariff.setTariffName(tariffEntity.getTariffName());
        return tariff;
    }

    @Override
    long getId(Tariff tariff) {
        return Long.valueOf(tariff.getTariffId());
    }
}
