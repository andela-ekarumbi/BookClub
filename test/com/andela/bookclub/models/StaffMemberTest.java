package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class StaffMemberTest {

    private StaffMember staffEston = new StaffMember("staffE");

    @Before
    public void beforeTestGetSalaryValue() {
        staffEston.setSalaryValue(10000d);
    }

    @Test
    public void testGetSalaryValue() throws Exception {
        double staffMemberSalary = staffEston.getSalaryValue();
        assertNotSame(0.0, staffMemberSalary);
        assertEquals(10000d, staffMemberSalary, 0.0);
    }
}