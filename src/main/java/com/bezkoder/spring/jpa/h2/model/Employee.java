package com.bezkoder.spring.jpa.h2.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @Column(name="name")
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private RoleType role;
//    @Column(name="band")
    private String band;
    @Column(name="joining_date")
    private Date joiningDate;
    @Column(name="release_date")
    private Date releaseDate;
    @Column(name="is_billable")
    private boolean billable;
    
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    Set<Allocation> allocations;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

//    public Set<Allocation> getAllocations() {
//        return allocations;
//    }
//
//    public void setAllocations(Set<Allocation> allocations) {
//        this.allocations = allocations;
//    }

}
