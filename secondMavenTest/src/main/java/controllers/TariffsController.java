package controllers;

import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/tariffs")
public class TariffsController {
    @Autowired
    private UserTariffService userTariffService;
    @Autowired
    private TariffService tariffService;
    @Autowired
    private TariffAttrsAndInfoService tariffAttrsAndInfoService;
    @Autowired
    private TariffAttrsService tariffAttrsService;
    @Autowired
    private TariffInfoService tariffInfoService;
    @RequestMapping
    public ModelAndView TariffsPage(@CookieValue("currentUserId") String userId){
        Map<String, Object> models = new HashMap<String, Object>();
        Map<Tariff,Map<String,String>> tariffsInfo=new HashMap<Tariff, Map<String, String>>();
        for (Tariff tariff:
             tariffService.getAll()) {
            Map<String,String> attrInfo=tariffAttrsAndInfoService.getAttrInfo(Integer.parseInt(tariff.getTariffId()));
            tariffsInfo.put(tariff,attrInfo);
        }
        models.put("tariffsInfo",tariffsInfo);
        models.put("userTariff",new UserTariff());
        UserTariff userTariff=userTariffService.getById(Long.parseLong(userId));
        if (userTariff!=null)
            models.put("tariffId",userTariff.getTariffID());
        else
            models.put("tariffId",-1);
        return new ModelAndView("tariffs",models);
    }

    @RequestMapping(value = "/new",params = {"tariffName"},method = RequestMethod.POST)
    public String CreateNewTariff(@RequestParam("tariffName") String tariffName){
        Tariff tariff=new Tariff();
        tariff.setTariffName(tariffName);
        tariff.setTariffId("2");
        tariffService.create(tariff);
        return "redirect:/tariffs";
    }

    @RequestMapping(params = {"tariffIdToDelete"}, method = RequestMethod.POST)
    public String DeleteTariff(@RequestParam("tariffIdToDelete") int tariffId){
        userTariffService.UnsubscribeUsers(tariffId);
        tariffInfoService.deleteInfoAboutTariff(tariffId);
        tariffService.delete(tariffId);
        return "redirect:/tariffs";
    }



}
