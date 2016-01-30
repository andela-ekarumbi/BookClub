package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;


public class MemberTest {

    // Private variable to use for testing

    Member member;

    @Before
    public void beforeTestGetSurname() {
        member = mock(Member.class, Mockito.CALLS_REAL_METHODS);
        member.setSurname("Smith");
    }

    @Test
    public void testGetSurname() throws Exception {
        String memberSurname = member.getSurname();
        assertEquals("Smith", memberSurname);
        assertNotSame("smith", memberSurname);
    }

    @Before
    public void beforeTestGetFirstName() {
        member = mock(Member.class, Mockito.CALLS_REAL_METHODS);
        member.setFirstName("John");
    }

    @Test
    public void testGetFirstName() throws Exception {
        String memberFirstName = member.getFirstName();
        assertEquals("John", memberFirstName);
        assertNotSame("john", memberFirstName);
    }

    @Test
    public void testGetMiddleName() throws Exception {

    }

    @Test
    public void testGetNationalIdNumber() throws Exception {

    }

    @Test
    public void testGetAge() throws Exception {

    }

    @Test
    public void testGetGender() throws Exception {

    }

    @Test
    public void testGetEmailAddress() throws Exception {

    }

    @Test
    public void testGetPhoneNumber() throws Exception {

    }

    @Test
    public void testGetJoinedDate() throws Exception {

    }
}