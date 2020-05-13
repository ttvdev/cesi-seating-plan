package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.model.Office;
import com.cesi.seatingplan.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/office")
public class OfficeRestController {

    @Autowired
    private OfficeRepository officeRepository;

    @PostMapping(path="/add")
    public Office addNewOffice(@RequestBody Office newOffice) {
        return officeRepository.save(newOffice);
    }

    @GetMapping(path="/{id}")
    public Office getOffice(@PathVariable Integer id) {
        return officeRepository.findById(id).get();
    }

    @GetMapping(path="/all")
    public Iterable<Office> getAllOffices() { return officeRepository.findAll(); }

    @PutMapping(path = "/edit/{id}")
    public Office editOffice(@RequestBody Office newOffice, @PathVariable Integer id) {
        return officeRepository.findById(id).map(
                office -> {
                    office.setName(newOffice.getName());
                    office.setIdBuilding(newOffice.getIdBuilding());
                    office.setUser(newOffice.getUser());
                    office.setFree(newOffice.getFree());
                    office.setUser(newOffice.getUser());
                    return officeRepository.save(office);
                }).orElseGet(() -> {
            newOffice.setId(id);
            return officeRepository.save(newOffice);
        });
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOffice(@PathVariable Integer id) {
        officeRepository.deleteById(id);
        return "Deleled";
    }
}
