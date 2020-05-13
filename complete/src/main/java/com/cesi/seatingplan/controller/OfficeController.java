package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.model.Office;
import com.cesi.seatingplan.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OfficeController {

    @Autowired
    private OfficeRepository officeRepository;

    @RequestMapping("/newOffice")
    public String showNewOfficePage(Model model) {
        Office office = new Office();
        model.addAttribute("office", office);

        return "newOffice";
    }

    @RequestMapping(value = "/saveOffice", method = RequestMethod.POST)
    public String saveOffice(@ModelAttribute("office") Office office) {
        officeRepository.save(office);

        return "redirect:/";
    }

    @RequestMapping("/editOffice/{id}")
    public ModelAndView showEditOfficePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editOffice");
        Office office = officeRepository.findById(id).get();
        mav.addObject("office", office);

        return mav;
    }

    @RequestMapping("/deleteOffice/{id}")
    public String deleteOffice(@PathVariable(name = "id") int id) {
        officeRepository.deleteById(id);
        return "redirect:/";
    }
}
