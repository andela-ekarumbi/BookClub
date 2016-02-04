package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.*;

public class LogEntryTest {

    // Private variable(s) to use during testing

    private LogEntry logEntry = new LogEntry();

    private Member member;

    private Date timeStart;

    private Date timeEnd;

    private StaffMember staffMember;

    @Before
    public void beforeTestGetMember() {
        member = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        logEntry.setMember(member);
    }

    @Test
    public void testGetMember() throws Exception {
        Member logMember = logEntry.getMember();
        assertNotSame(null, logMember);
        assertEquals(member, logMember);
    }

    @Test
    public void testGetEntryDescription() throws Exception {

    }

    @Test
    public void testGetTimeStart() throws Exception {

    }

    @Test
    public void testGetTimeEnd() throws Exception {

    }

    @Test
    public void testGetLoggedBy() throws Exception {

    }
}