package com.cesi.seatingplan.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Office implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer idBuilding;

    private Integer idRoom;

    @JsonManagedReference
    @OneToOne(mappedBy = "office")
    private User user;

    private Integer idFuturUser;

    private Date busyUntil;

    private Boolean free;

    public Office(){
        this.free = true;
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

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(Integer idBuilding) {
        this.idBuilding = idBuilding;
    }

    public Boolean getFree() { return free; }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIdFuturUser() {
        return idFuturUser;
    }

    public void setIdFuturUser(Integer idFuturUser) {
        this.idFuturUser = idFuturUser;
    }

    public Date getBusyUntil() {
        return busyUntil;
    }

    public void setBusyUntil(Date busyUntil) {
        if (this.user.getId() != null) {
            this.busyUntil = this.user.getExitDate();
        }
        this.busyUntil = busyUntil;
    }
}
