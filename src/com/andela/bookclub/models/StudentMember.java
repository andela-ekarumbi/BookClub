package com.andela.bookclub.models;

public class StudentMember extends Member {
    private String school;

    public StudentMember(String id) {
        setId(id);
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
