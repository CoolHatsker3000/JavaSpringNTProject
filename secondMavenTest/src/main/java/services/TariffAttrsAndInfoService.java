package services;

import entity.TariffInfoEntity;
import models.TariffAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TariffAttrsAndInfoService {
    @Autowired
    private TariffAttrsService attrsService;
    @Autowired
    private TariffInfoService infoService;

    public Map<String,String> getAttrInfo(int tariffId){
        List<TariffInfoEntity> tariffInfoList=infoService.getInfoById(tariffId);
        Map<String,String> attrInfo=new HashMap<String, String>();
        for (TariffInfoEntity tie:
             tariffInfoList) {
            TariffAttr tariffAttr= attrsService.getById(tie.getAttrId());
            attrInfo.put(tariffAttr.getAttrName(),tie.getAttrV());
        }
        return attrInfo;
    }



}
