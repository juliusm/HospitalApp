package com.hospitalapp.web.controller.uam;

import com.hospitalapp.uam.domain.Module;
import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.domain.User;
import com.hospitalapp.uam.service.RoleService;
import com.hospitalapp.uam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService){
        this.roleService = roleService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Role.class, "role",
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) {
                        Long id = new Long(text);
                        Role role = roleService.findById(id);
                        super.setValue(role);
                    }
                });
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@ModelAttribute User user){
        return "user/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute User user, BindingResult result){
        userService.save(user);
        return "redirect:list";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap modelMap){
        List<User> users = userService.list();
        modelMap.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, ModelMap modelMap){
        User user = userService.findById(id);
        modelMap.addAttribute("user", user);
        return "user/get";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(@PathVariable Long id, ModelMap modelMap){
        User user = userService.findById(id);
        modelMap.addAttribute("user", user);
        return "/user/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute User user, ModelMap modelMap){
        userService.update(user);
        return "redirect:get/"+user.getId();
    }

    @ModelAttribute("roles")
    public List<Role> listRoles(){
        return roleService.list();
    }

}
