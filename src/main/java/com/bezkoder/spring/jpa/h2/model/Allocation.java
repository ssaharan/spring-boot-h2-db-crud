package com.bezkoder.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int allocationId;
    @Column(name="allocation_starts")
    private Date allocationStarts;
    @Column(name="allocation_ends")
    private Date allocationEnds;
//    private BillingSlab billingSlab;
//    private Project project;
    
    
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public int getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(int allocationId) {
        this.allocationId = allocationId;
    }

    public Date getAllocationStarts() {
        return allocationStarts;
    }

    public void setAllocationStarts(Date allocationStarts) {
        this.allocationStarts = allocationStarts;
    }

    public Date getAllocationEnds() {
        return allocationEnds;
    }

    public void setAllocationEnds(Date allocationEnds) {
        this.allocationEnds = allocationEnds;
    }

//    public BillingSlab getBillingRate() {
//        return billingSlab;
//    }
//
//    public void setBillingRate(BillingSlab billingRate) {
//        this.billingSlab = billingRate;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee userInfo) {
        this.employee = userInfo;
    }
}
