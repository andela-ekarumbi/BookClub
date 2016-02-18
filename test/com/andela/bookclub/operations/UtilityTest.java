package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.StudentMember;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilityTest {

    private List<Member> membersTestList;
    private StudentMember studentTosin;
    private StudentMember studentUpdateTosin;

    @Before
    public void beforeTestSearchByPropertyValue() {

        StudentMember studentEston = new StudentMember("studE");
        StudentMember studentThomas = new StudentMember("studT");
        StudentMember studentHannah = new StudentMember("studH");
        StudentMember studentJohn = new StudentMember("studJ");
        StudentMember studentMichael = new StudentMember("studM");

        membersTestList = new ArrayList<>();
        membersTestList.add(studentEston);
        membersTestList.add(studentHannah);
        membersTestList.add(studentJohn);
        membersTestList.add(studentMichael);
        membersTestList.add(studentThomas);
    }

    @Test
    public void testSearchByPropertyValue() throws Exception {
        int testSearchInteger =
                Utility.searchByPropertyValue(membersTestList, "id", "studJ");
        assertNotSame(-1, testSearchInteger);
        assertEquals(2, testSearchInteger);
    }

    @Before
    public void beforeTestCopyFieldsFromObject() {
        studentTosin = new StudentMember("studT");
        studentTosin.setSchool("Andela Institute");
        studentTosin.setSurname("Adesanya");

        studentUpdateTosin = new StudentMember(null);
        studentUpdateTosin.setSchool("Nigeria School of Hard Knocks");
        studentTosin.setFirstName("Oluwatosin");
    }

    @Test
    public void testCopyFieldsFromObject() throws Exception {
        Utility.copyFieldsFromObject(studentTosin, studentUpdateTosin);

        assertEquals("Nigeria School of Hard Knocks", studentTosin.getSchool());
        assertEquals("Oluwatosin", studentTosin.getFirstName());
    }
}