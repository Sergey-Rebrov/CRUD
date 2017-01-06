package com.firsttask.controller;

import com.firsttask.model.Search;
import com.firsttask.model.User;
import com.firsttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;

/**
 * Created by Sergey on 21.11.2016.
 */
@Controller
public class UserController {

    private UserService userService;
    private static Search search;
    static {
        search = new Search();
    }

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users")
    public String listUsers(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("user", new User());
        model.addAttribute("search", search);
        model.addAttribute("listUsers", this.userService.listUsers(search.getContent(), offset, maxResults));
        model.addAttribute("count", this.userService.countUsers(UserController.search.getContent()));
        model.addAttribute("offset", offset);
        return "/users";
    }

    @RequestMapping(value = "/search")
    public String searchUsers(@ModelAttribute Search search, Model model, Integer offset, Integer maxResults) {
        model.addAttribute("user", new User());
        UserController.search = search;
        model.addAttribute("count", this.userService.countUsers(UserController.search.getContent()));
        model.addAttribute("offset", offset);
        model.addAttribute("listUsers", this.userService.listUsers(UserController.search.getContent(), offset, maxResults));
        return "/users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute User user) {
        if (user.getId() == 0)
        {
            this.userService.addUser(user);
        } else
        {
            this.userService.updateUser(user);
        }
        search.setContent("");
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        search.setContent("");
        return "redirect:/users";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model, Integer offset, Integer maxResults){
        model.addAttribute("user", userService.getUserByID(id));
        model.addAttribute("search", search);
        model.addAttribute("listUsers", this.userService.listUsers(search.getContent(), offset, maxResults));
        model.addAttribute("count", this.userService.countUsers(UserController.search.getContent()));
        model.addAttribute("offset", offset);
        return "/users";
    }
}
