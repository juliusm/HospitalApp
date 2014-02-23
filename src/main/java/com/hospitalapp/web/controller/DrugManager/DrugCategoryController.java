package com.hospitalapp.web.controller.DrugManager;

import com.hospitalapp.drugmanager.dto.DrugCategoryDTO;
import com.hospitalapp.drugmanager.dto.validator.DrugCategoryDTOValidator;
import com.hospitalapp.drugmanager.service.DrugCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("drugCategory")
public class DrugCategoryController {

    @Autowired
    private DrugCategoryService drugCategoryService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new DrugCategoryDTOValidator());
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap modelMap){
        modelMap.addAttribute("categories", drugCategoryService.list());
        return "/drugCategory/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@ModelAttribute DrugCategoryDTO drugCategoryDTO){
        return "/drugCategory/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid DrugCategoryDTO drugCategoryDTO, BindingResult result){
        if(result.hasErrors()){
            return "/drugCategory/create";
        }
        drugCategoryService.save(drugCategoryDTO);
        return "redirect:list";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, ModelMap modelMap){
        DrugCategoryDTO drugCategoryDTO = drugCategoryService.findById(id);
        modelMap.addAttribute("drugCategoryDTO", drugCategoryDTO);
        return "/drugCategory/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid DrugCategoryDTO drugCategoryDTO, BindingResult result){
        if(result.hasErrors()){
            return "/drugCategory/edit";
        }
        drugCategoryService.update(drugCategoryDTO);
        return "redirect:list";
    }
}
