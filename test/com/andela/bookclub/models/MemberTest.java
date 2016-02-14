package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;


public class MemberTest {

    Member memberJohn = mock(Member.class, Mockito.CALLS_REAL_METHODS);

    @Before
    public void beforeTestGetSurname() {
        memberJohn.setSurname("Smith");
    }

    @Test
    public void testGetSurname() throws Exception {
        String memberSurname = memberJohn.getSurname();
        assertNotSame(null, memberSurname);
        assertEquals("Smith", memberSurname);
    }

    @Before
    public void beforeTestGetFirstName() {
        memberJohn.setFirstName("John");
    }

    @Test
    public void testGetFirstName() throws Exception {
        String memberFirstName = memberJohn.getFirstName();
        assertNotSame(null, memberFirstName);
        assertEquals("John", memberFirstName);
    }

    @Before
    public void beforeTestGetMiddletName() {
        memberJohn.setMiddleName("Kamau");
    }

    @Test
    public void testGetMiddleName() throws Exception {
        String memberMiddleName = memberJohn.getMiddleName();
        assertNotSame(null, memberMiddleName);
        assertEquals("Kamau", memberMiddleName);
    }

    @Before
    public void beforeTestGetNationalIdNumber() {
        memberJohn.setNationalIdNumber("27855410");
    }

    @Test
    public void testGetNationalIdNumber() throws Exception {
        String membernationalIdNumber = memberJohn.getNationalIdNumber();
        assertNotSame(null, membernationalIdNumber);
        assertEquals("27855410", membernationalIdNumber);
    }

    @Before
    public void beforeTestGetAge() {
        memberJohn.setAge(25);
    }

    @Test
    public void testGetAge() throws Exception {
        int memberAge = memberJohn.getAge();
        assertNotSame(0, memberAge);
        assertEquals(25, memberAge);
    }

    @Before
    public void beforeTestGetGender() {
        memberJohn.setGender("M");
    }

    @Test
    public void testGetGender() throws Exception {
        String memberGender = memberJohn.getGender();
        assertNotSame(null, memberGender);
        assertEquals(1, memberGender.length());
        assertEquals("M", memberGender);
    }

    @Before
    public void beforeGetGetEmail() {
        memberJohn.setEmailAddress("foo@bar.com");
    }

    @Test
    public void testGetEmailAddress() throws Exception {
        String memberEmailAddress = memberJohn.getEmailAddress();
        assertNotSame(null, memberEmailAddress);
        assertEquals("foo@bar.com", memberEmailAddress);
    }

    @Before
    public void beforeGetPhoneNumber() {
        memberJohn.setPhoneNumber("0723220576");
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        String memberPhoneNumber = memberJohn.getPhoneNumber();
        assertNotSame(null, memberPhoneNumber);
        assertEquals("0723220576", memberPhoneNumber);
    }

    @Before
    public void beforeTestGetJoinedDate() {
        memberJohn.setJoinedDate(new Date());
    }

    @Test
    public void testGetJoinedDate() throws Exception {
        Date memberJoinedDate = memberJohn.getJoinedDate();
        assertNotSame(null, memberJoinedDate);
    }
}