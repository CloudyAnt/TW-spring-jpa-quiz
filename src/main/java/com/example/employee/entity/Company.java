package com.example.employee.entity;

import javax.persistence.Entity;

@Entity
public class Company {
    int id, employeesNumber;
    String companyName;

    public Company(int id, String companyName, int employeesNumber) {
        this.id = id;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public int getId() {
        return id;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public String getCompanyName() {
        return companyName;
    }
}
