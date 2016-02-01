package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class StudentMemberTest {

    private StudentMember studentMember = new StudentMember();

    @Before
    public void beforeTestGetSchool() {
        studentMember.setSchool("Kayamba high school");
    }

    @Test
    public void testGetSchool() throws Exception {
        String studentMemberSchool = studentMember.getSchool();
        assertNotSame(null, studentMemberSchool);
        assertEquals("Kayamba high school", studentMemberSchool);
    }
}