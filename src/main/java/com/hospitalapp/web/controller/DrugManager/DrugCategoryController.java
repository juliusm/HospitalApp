package com.hospitalapp.web.controller.DrugManager;

import com.hospitalapp.drugmanager.domain.DrugCategory;
import com.hospitalapp.drugmanager.service.DrugManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("drugCategory")
public class DrugCategoryController {

    private DrugManagerService drugManagerService;

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
        return "redirect:list";
    }

    @RequestMapping(value = "edit/{categoryId}", method = RequestMethod.GET)
    public String edit(@PathVariable Long categoryId, ModelMap modelMap){
        DrugCategory drugCategory = drugManagerService.findDrugCategoryById(categoryId);
        modelMap.addAttribute("drugCategory", drugCategory);
        return "/drugCategory/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute DrugCategory drugCategory){
        drugManagerService.updateDrugCategory(drugCategory);
        return "redirect:list";
    }
}
