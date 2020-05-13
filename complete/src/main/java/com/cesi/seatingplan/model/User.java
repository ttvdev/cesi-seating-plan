package com.cesi.seatingplan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    @DateTimeFormat(pattern="dd/MM/YYYY")
    private Date entryDate;

    @DateTimeFormat(pattern="dd/MM/YYYY")
    private Date exitDate;

    @JsonBackReference
    @OneToOne()
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;

    public User(){}
    public User(String n, String e, Date entry, Date exit) {
        this.name = n;
        this.email = e;
        this.entryDate = entry;
        this.exitDate = exit;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
