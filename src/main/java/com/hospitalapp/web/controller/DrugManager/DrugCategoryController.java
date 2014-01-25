package com.hospitalapp.web.controller.DrugManager;

import com.hospitalapp.drugmanager.domain.DrugCategory;
import com.hospitalapp.drugmanager.service.DrugCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("drugCategory")
public class DrugCategoryController {

    private DrugCategoryService drugCategoryService;

    @Autowired
    public void setDrugCategoryService(DrugCategoryService drugCategoryService){
        this.drugCategoryService = drugCategoryService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap modelMap){
        modelMap.addAttribute("categories", drugCategoryService.list());
        return "/drugCategory/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@ModelAttribute DrugCategory drugCategory){
        return "/drugCategory/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid DrugCategory drugCategory, BindingResult result){
        if(result.hasErrors()){
            return "/drugCategory/create";
        }
        drugCategoryService.save(drugCategory);
        return "redirect:list";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, ModelMap modelMap){
        DrugCategory drugCategory = drugCategoryService.findById(id);
        modelMap.addAttribute("drugCategory", drugCategory);
        return "/drugCategory/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute DrugCategory drugCategory){
        drugCategoryService.update(drugCategory);
        return "redirect:list";
    }
}
