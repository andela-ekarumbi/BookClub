package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;


public class MemberTest {

    // Private variable to use for testing

    Member member = mock(Member.class, Mockito.CALLS_REAL_METHODS);

    @Before
    public void beforeTestGetSurname() {
        member.setSurname("Smith");
    }

    @Test
    public void testGetSurname() throws Exception {
        String memberSurname = member.getSurname();
        assertNotSame(null, memberSurname);
        assertEquals("Smith", memberSurname);
    }

    @Before
    public void beforeTestGetFirstName() {
        member.setFirstName("John");
    }

    @Test
    public void testGetFirstName() throws Exception {
        String memberFirstName = member.getFirstName();
        assertNotSame(null, memberFirstName);
        assertEquals("John", memberFirstName);
    }

    @Before
    public void beforeTestGetMiddletName() {
        member.setMiddleName("Kamau");
    }

    @Test
    public void testGetMiddleName() throws Exception {
        String memberMiddleName = member.getMiddleName();
        assertNotSame(null, memberMiddleName);
        assertEquals("Kamau", memberMiddleName);
    }

    @Before
    public void beforeTestGetNationalIdNumber() {
        member.setNationalIdNumber("27855410");
    }

    @Test
    public void testGetNationalIdNumber() throws Exception {
        String membernationalIdNumber = member.getNationalIdNumber();
        assertNotSame(null, membernationalIdNumber);
        assertEquals("27855410", membernationalIdNumber);
    }

    @Before
    public void beforeTestGetAge() {
        member.setAge(25);
    }

    @Test
    public void testGetAge() throws Exception {
        int memberAge = member.getAge();
        assertNotSame(0, memberAge);
        assertEquals(25, memberAge);
    }

    @Before
    public void beforeTestGetGender() {
        member.setGender("M");
    }

    @Test
    public void testGetGender() throws Exception {
        String memberGender = member.getGender();
        assertNotSame(null, memberGender);
        assertEquals(1, memberGender.length());
        assertEquals("M", memberGender);
    }

    @Before
    public void beforeGetGetEmail() {
        member.setEmailAddress("foo@bar.com");
    }

    @Test
    public void testGetEmailAddress() throws Exception {
        String memberEmailAddress = member.getEmailAddress();
        assertNotSame(null, memberEmailAddress);
        assertEquals("foo@bar.com", memberEmailAddress);
    }

    @Before
    public void beforeGetPhoneNumber() {
        member.setPhoneNumber("0723220576");
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        String memberPhoneNumber = member.getPhoneNumber();
        assertNotSame(null, memberPhoneNumber);
        assertEquals("0723220576", memberPhoneNumber);
    }

    @Before
    public void beforeTestGetJoinedDate() {
        member.setJoinedDate(new Date());
    }

    @Test
    public void testGetJoinedDate() throws Exception {
        Date memberJoinedDate = member.getJoinedDate();
        assertNotSame(null, memberJoinedDate);
    }
}