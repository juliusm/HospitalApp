package com.hospitalapp.web.controller.DrugManager;

import com.hospitalapp.drugmanager.domain.DrugCategory;
import com.hospitalapp.drugmanager.service.DrugManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("drugCategory")
public class DrugCategoryController {

    private DrugManagerService drugManagerService;
    private static final Logger LOGGER = Logger.getLogger(DrugCategoryController.class.getName());

    @Autowired
    public void setDrugManagerService(DrugManagerService drugManagerService){
        this.drugManagerService = drugManagerService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap modelMap){

        modelMap.addAttribute("categories", drugManagerService.listCategories());
        return "/drugCategory/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@ModelAttribute DrugCategory drugCategory){
        return "/drugCategory/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute DrugCategory drugCategory){
        drugManagerService.saveCategory(drugCategory);
        LOGGER.log(Level.INFO, drugCategory.getId().toString());
        return "redirect:list";
    }
}