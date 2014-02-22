package com.hospitalapp.web.controller.uam;

import com.hospitalapp.commons.Exception.EntryNotFoundException;
import com.hospitalapp.uam.domain.Module;
import com.hospitalapp.uam.domain.ModuleGroup;
import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.service.ModuleGroupService;
import com.hospitalapp.uam.service.ModuleService;
import com.hospitalapp.uam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("role")
public class RoleController {

    private static final Logger LOGGER = Logger.getLogger(RoleController.class.getName());

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModuleGroupService moduleGroupService;

    @Autowired
    private ModuleService moduleService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Module.class, "modules",
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) {
                        Long id = new Long(text);
                        Module module = moduleService.findById(id);
                        super.setValue(module);
                    }
                });
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap modelMap){
        List<Role> roles = roleService.list();
        modelMap.addAttribute("roles", roles);
        return "role/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@ModelAttribute Role role){
        return "role/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute Role role, BindingResult result){
        roleService.save(role);
        return "redirect:list";
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, ModelMap modelMap){
        Role role = roleService.findById(id);
        modelMap.addAttribute("role", role);
        return "role/get";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, ModelMap modelMap){
        Role role = roleService.findById(id);
        modelMap.addAttribute("role", role);
        return "role/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute Role role, ModelMap modelMap){
        try {
            roleService.update(role);
            return "redirect:get/"+role.getId();
        }catch (EntryNotFoundException e){
            modelMap.addAttribute("role", role);
            return "role/edit";
        }
    }

    @ModelAttribute("moduleGroups")
    public List<ModuleGroup> listModuleGroups(){
        return moduleGroupService.list();
    }
}
