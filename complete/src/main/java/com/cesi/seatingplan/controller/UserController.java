package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.model.User;
import com.cesi.seatingplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/newUser")
    public String showNewUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "newUser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userRepository.save(user);

        return "redirect:/";
    }

    @RequestMapping("/editUser/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editUser");
        User user = userRepository.findById(id).get();
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}
