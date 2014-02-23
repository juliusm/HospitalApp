package com.hospitalapp.web.controller.uam;

import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.domain.User;
import com.hospitalapp.uam.dto.UserDTO;
import com.hospitalapp.uam.dto.validator.UserDTOValidator;
import com.hospitalapp.uam.service.RoleService;
import com.hospitalapp.uam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new UserDTOValidator());
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@ModelAttribute UserDTO userDTO){
        return "user/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid UserDTO userDTO, BindingResult result){
        if(result.hasErrors()){
            return "user/create";
        }
        userService.save(userDTO);
        return "redirect:list";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap modelMap){
        List<UserDTO> users = userService.list();
        modelMap.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, ModelMap modelMap){
        UserDTO user = userService.findById(id);
        modelMap.addAttribute("user", user);
        return "user/get";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(@PathVariable Long id, ModelMap modelMap){
        UserDTO userDTO = userService.findById(id);
        modelMap.addAttribute("userDTO", userDTO);
        return "/user/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute UserDTO userDTO, BindingResult result){
        if(result.hasErrors()){
            return "/user/edit";
        }
        userService.update(userDTO);
        return "redirect:get/"+userDTO.getId();
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.GET)
    public String displayChangePasswordForm(){
        return "";
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public String changePassword(){
        return "";
    }

    @ModelAttribute("roles")
    public List<Role> listRoles(){
        return roleService.list();
    }

}
