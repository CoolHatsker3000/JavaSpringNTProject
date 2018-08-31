package controllers;

import models.TariffAttr;
import models.TariffInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/tariffs/edit")
public class TariffEditorController {
    @Autowired
    private TariffService tariffService;
    @Autowired
    private TariffAttrsAndInfoService tariffAttrsAndInfoService;
    @Autowired
    private TariffAttrsService tariffAttrsService;
    @Autowired
    private TariffInfoService tariffInfoService;
    @RequestMapping(value = "/{tariffId}",method = RequestMethod.GET)
    public ModelAndView EditTariff(@PathVariable int tariffId){
        Map<String, Object> models = new HashMap<String, Object>();
        List<TariffAttr> attrs=tariffAttrsService.getAll();
        Map<TariffAttr, TariffInfo> tariffInfoMap = new HashMap<TariffAttr, TariffInfo>();
        List<TariffAttr> otherAttrs=new LinkedList<TariffAttr>();
        for (TariffAttr ta:
                attrs) {
            TariffInfo tariffInfo=tariffInfoService.getById(new Long[]{new Long(tariffId), Long.parseLong(ta.getAttrId())});
            if (tariffInfo.getAttrV()==null) otherAttrs.add(ta);
            else
                tariffInfoMap.put(ta,tariffInfo);
        }
        models.put("attrs",tariffInfoMap);
        models.put("otherAttrs",otherAttrs);
        models.put("tariff",tariffService.getById(tariffId));
        return new ModelAndView("edit_tariff",models);
    }
    @RequestMapping(value = "/{tariffId}",method = RequestMethod.POST)
    public String UpdateTariff(@RequestParam Map<String,String> attrs,@PathVariable int tariffId){
        for (Map.Entry<String,String> attr:
                attrs.entrySet()) {
            if (attr.getValue().equals("") || attr.getValue()==null) continue;
            TariffInfo tariffInfo = new TariffInfo();
            tariffInfo.setTariffId(String.valueOf(tariffId));
            tariffInfo.setAttrV(attr.getValue());
            if (attr.getKey().startsWith("-")) {
                tariffInfo.setAttrId(attr.getKey().substring(1));
                tariffInfoService.create(tariffInfo);
            } else {
                tariffInfo.setAttrId(attr.getKey());
                tariffInfoService.update(tariffInfo);
            }

        }
        return "redirect:/tariffs/edit/"+String.valueOf(tariffId);
    }
    @RequestMapping(value = "/{tariffId}/add",params = {"attrsToAdd"},method = RequestMethod.POST)
    public String AddAttrToTariff(@PathVariable String tariffId,@RequestParam("attrsToAdd") int[] attrIds){
        for (int attrId:attrIds
             ) {
            TariffInfo ti=new TariffInfo();
            ti.setTariffId(tariffId);
            ti.setAttrId(String.valueOf(attrId));
            ti.setAttrV("?");
            tariffInfoService.create(ti);
        }
        return "redirect:/tariffs/edit/"+tariffId;
    }
    @RequestMapping(value = "/{tariffId}/del/{attrId}")
    public String DelAttrFromTariff(@PathVariable String tariffId,@PathVariable int attrId){
        tariffInfoService.delete(Integer.parseInt(tariffId),attrId);
        return "redirect:/tariffs/edit/"+tariffId;
    }
    @RequestMapping(value = "/{tariffId}/new",params = {"attrName"},method = RequestMethod.POST)
    public String AddAttr(@PathVariable String tariffId,
                                @RequestParam("attrName") String attrName){
        TariffAttr tariffAttr=new TariffAttr();
        tariffAttr.setAttrId("1");
        tariffAttr.setAttrName(attrName);
        tariffAttrsService.create(tariffAttr);
        return "redirect:/tariffs/edit/"+tariffId;
    }
}
