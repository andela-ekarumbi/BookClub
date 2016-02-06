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

    private String member1Id;

    // Utility methods

    private void addMember1() {
        member1Id = "12345";
        testMember1 = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        testMember1.setId(member1Id);
        libraryMembers.addNewMember(testMember1);
    }

    // Test methods

    @Before
    public void beforeTestAddNewMember() {
        addMember1();
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
        assertTrue(members.size() >= 5);
    }

    @Before
    public void beforeTestGetMemberById() {
        addMember1();
        Member m = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        m.setId("678910");
        libraryMembers.addNewMember(m);
    }

    @Test
    public void testGetMemberById() throws Exception {
        Member member1 = libraryMembers.getMemberById(member1Id);
        assertNotSame(null, member1);
        assertEquals(testMember1.getId(), member1.getId());
    }

    @Before
    public void beforeTestUpdateMemberDetails() {
        addMember1();
    }

    @Test
    public void testUpdateMemberDetails() throws Exception {
        // Prepare member object to use for update

        Member updateMember = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        updateMember.setSurname("Kariuki");
        updateMember.setFirstName("John");

        // Do update

        libraryMembers.updateMemberDetails(member1Id, updateMember);

        // Confirm update

        Member confirmMember = libraryMembers.getMemberById(member1Id);

        assertEquals("Kariuki", confirmMember.getSurname());
        assertEquals("John", confirmMember.getFirstName());
    }

    @Before
    public void beforeTestDeleteMember() {
        addMember1();
    }

    @Test
    public void testDeleteMember() throws Exception {

        // Exercise the deletion

        libraryMembers.deleteMember(member1Id);

        // Confirm deletion

        Member deletedMember = libraryMembers.getMemberById(member1Id);
        assertEquals(null, deletedMember);
    }
}