package services;


import dao.TariffInfoDAO;
import entity.TariffInfoEntity;
import models.TariffInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class TariffInfoService extends AbstractService<TariffInfo, TariffInfoEntity> {

    @Autowired
    public TariffInfoService(TariffInfoDAO dao) {
        super(dao);
    }

    @Override
    protected TariffInfoEntity ModelToEntity(TariffInfo tariffInfo) {
        return new TariffInfoEntity(tariffInfo);
    }

    @Override
     protected TariffInfo EntityToModel(TariffInfoEntity tariffInfoEntity) {

        TariffInfo tariffInfo=new TariffInfo();
        if (tariffInfoEntity==null){
            return tariffInfo;
        }
        tariffInfo.setTariffId(String.valueOf(tariffInfoEntity.getTariffId()));
        tariffInfo.setAttrId(String.valueOf(tariffInfoEntity.getAttrId()));
        tariffInfo.setAttrV(tariffInfoEntity.getAttrV());
        return tariffInfo;
    }

    @Override
    long getId(TariffInfo tariffInfo) {
        return Long.parseLong(tariffInfo.getTariffId());
    }

    @Override
    public void delete(TariffInfo tariffInfo) {
        this.currentDAO.delete(new Object[] {Long.parseLong(tariffInfo.getTariffId()),Long.parseLong(tariffInfo.getAttrId())});
    }

    public void delete(int tariffId,int attrId){
        this.currentDAO.delete(new Object[] {tariffId,attrId});
    }

    public TariffInfo getById(Long[] ids) {
        return EntityToModel(this.currentDAO.getByID(ids));
    }


    public List<TariffInfoEntity> getInfoById(int tariffId){
        TariffInfoDAO dao=(TariffInfoDAO) this.currentDAO;
        return dao.getInfoById(tariffId);
    }
    public void deleteInfoAboutTariff(int tariffId){
        TariffInfoDAO dao=(TariffInfoDAO) this.currentDAO;
        dao.deleteInfoAboutTariff(tariffId);
    }

}
