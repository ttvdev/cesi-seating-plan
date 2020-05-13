package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.model.Office;
import com.cesi.seatingplan.model.User;
import com.cesi.seatingplan.repository.OfficeRepository;
import com.cesi.seatingplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Office> listOffices = officeRepository.findAll();
        model.addAttribute("listOffices", listOffices);

        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "home";
    }
}
