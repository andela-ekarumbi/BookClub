package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class StudentMemberTest {

    private StudentMember studentEston = new StudentMember("studE");

    @Before
    public void beforeTestGetSchool() {
        studentEston.setSchool("Kayamba high school");
    }

    @Test
    public void testGetSchool() throws Exception {
        String studentMemberSchool = studentEston.getSchool();
        assertNotSame(null, studentMemberSchool);
        assertEquals("Kayamba high school", studentMemberSchool);
    }
}