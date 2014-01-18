package com.hospitalapp.web.controller;

import com.hospitalapp.drugmanager.service.DrugManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("drugmanager")
public class DrugController {

    private DrugManagerService drugManagerService;

    @Autowired
    public void setDrugManagerService(DrugManagerService drugManagerService){
        this.drugManagerService = drugManagerService;
    }

    @RequestMapping(value = {"/","listCategories"}, method = RequestMethod.GET)
    public String listCategories(ModelMap modelMap){

        modelMap.addAttribute("categories", drugManagerService.listCategories());
        return "/drugmanager/listCategories";
    }
}
