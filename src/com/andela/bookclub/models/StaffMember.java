package com.andela.bookclub.models;

public class StaffMember extends Member {
    private double salaryValue;

    public StaffMember(String id) {
        setId(id);
    }

    public double getSalaryValue() {
        return salaryValue;
    }

    public void setSalaryValue(double salaryValue) {
        this.salaryValue = salaryValue;
    }
}
