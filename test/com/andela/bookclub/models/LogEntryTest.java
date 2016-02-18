package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.*;

public class LogEntryTest {

    private LogEntry logEntry = new LogEntry();

    private Member memberEston;

    private Date timeStart;

    private Date timeEnd;

    private StaffMember staffJames;

    @Before
    public void beforeTestGetMember() {
        memberEston = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        logEntry.setMember(memberEston);
    }

    @Test
    public void testGetMember() throws Exception {
        Member logMember = logEntry.getMember();
        assertNotSame(null, logMember);
        assertEquals(memberEston, logMember);
    }

    @Before
    public void beforeTestGetEntryDescription() {
        logEntry.setEntryDescription("Lorem ipsum dolor sit amet");
    }

    @Test
    public void testGetEntryDescription() throws Exception {
        String entryDescription = logEntry.getEntryDescription();
        assertNotSame(null, entryDescription);
        assertEquals("Lorem ipsum dolor sit amet", entryDescription);
    }

    @Before
    public void beforeTestGetTimeStart() {
        timeStart = new Date();
        logEntry.setTimeStart(timeStart);
    }

    @Test
    public void testGetTimeStart() throws Exception {
        Date startTime = logEntry.getTimeStart();
        assertNotSame(null, startTime);
        assertEquals(timeStart, startTime);
    }

    @Before
    public void beforeTestGetTimeEnd() {
        timeEnd = new Date();
        logEntry.setTimeEnd(timeEnd);
    }

    @Test
    public void testGetTimeEnd() throws Exception {
        Date endTime = logEntry.getTimeEnd();
        assertNotSame(null, endTime);
        assertEquals(timeEnd, endTime);
    }

    @Before
    public void beforeTestGetLoggedBy() {
        staffJames = new StaffMember("staffJ");
        logEntry.setLoggedBy(staffJames);
    }

    @Test
    public void testGetLoggedBy() throws Exception {
        StaffMember member = logEntry.getLoggedBy();
        assertNotSame(null, member);
        assertEquals(staffJames, member);
    }
}

