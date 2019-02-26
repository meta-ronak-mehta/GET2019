package com.metacube.ead5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.ead5.model.User;
import com.metacube.ead5.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model m) {
//        m.addAttribute("x",new User());
        return "user/add";
    }
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
        userService.add(user);
        return "redirect:/user/all";
    }
    
    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public ModelAndView get( @PathVariable("userId") Integer userId) {
        User user = userService.get(userId);
        return new ModelAndView("user/edit", "user",user);
    }
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        userService.update(user);
        return "redirect:/user/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<User> user = userService.getAll(); 
        return new ModelAndView("user/all", "user", user);
    }
    
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String delete(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
        return "redirect:/user/all";
    }
    
    
    @RequestMapping(value = "/search_by", method = RequestMethod.GET)
    public String searchByFirstName() {
        return "user/search_by";
    }
    
    
//    @RequestMapping(value = "/search_result", method = RequestMethod.GET)
//    public ModelAndView searchResult() {
//        List<User> user = userService.getByAttribute(Attribute.contact_no,"45"); 
//        return new ModelAndView("user/search_result", "user", user);
//    }
//    
    @RequestMapping(value = "/search_result", method = RequestMethod.GET)
    public ModelAndView searchResult(String attribute, String attribute_value) {
        List<User> user = userService.getByAttribute(attribute,attribute_value); 
        return new ModelAndView("user/search_result", "user", user);
    }
       
       

    

    
}
