package com.andela.bookclub.models;

/*
* StaffMember extends Member and implements functionality that is specific to staff members.
* */

public class StaffMember extends Member {

    // Private variables

    private double salaryValue;

    // Getters and setters

    public double getSalaryValue() {
        return salaryValue;
    }

    public void setSalaryValue(double salaryValue) {
        this.salaryValue = salaryValue;
    }
}
