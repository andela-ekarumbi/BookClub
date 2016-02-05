package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryMembersTest {

    // Private variables to use in testing

    private LibraryMembers libraryMembers = new LibraryMembers();

    private Member testMember1;

    private Member testMember2;

    private Member testMember3;

    // Test methods

    @Before
    public void beforeTestAddNewMember() {
        testMember1 = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void testAddNewMember() throws Exception {
        assertTrue(libraryMembers.addNewMember(testMember1));
    }

    @Before
    public void beforeTestGetAllMembers() {

        // Add five member objects to libraryMembers

        for (int i = 0; i < 5; i++) {
            libraryMembers.addNewMember(Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS));
        }
    }

    @Test
    public void testGetAllMembers() throws Exception {
        List<Member> members = libraryMembers.getAllMembers();
        assertNotSame(null, members);
        assertEquals(5, members.size());
    }

    @Test
    public void testGetMemberById() throws Exception {

    }

    @Test
    public void testUpdateMemberDetails() throws Exception {

    }

    @Test
    public void testDeleteMember() throws Exception {

    }
}