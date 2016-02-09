package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.StudentMember;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryMembersTest {

    // Private variables to use in testing

    private LibraryMembers libraryMembers;

    private LibraryMembers libraryMembers2;

    private LibraryMembers libraryMembers3;

    private Member testMember1;

    private String member1Id;

    private String deleteMemberId;

    // Test methods

    @Test
    public void testAddNewMember() throws Exception {
        testMember1 = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        assertTrue(libraryMembers.addNewMember(testMember1));
    }

    @Before
    public void beforeTestGetAllMembers() {
        libraryMembers = new LibraryMembers();

        // Add five member objects to libraryMembers

        for (int i = 0; i < 5; i++) {
            Member addMember = new StudentMember();
            addMember.setId(Integer.toString(i));
            libraryMembers.addNewMember(addMember);
        }
    }

    @Test
    public void testGetAllMembers() throws Exception {
        List<Member> members = libraryMembers.getAllMembers();
        assertNotSame(null, members);
        assertEquals(5, members.size());
    }

    @Before
    public void beforeTestGetMemberById() {
        libraryMembers2 = new LibraryMembers();
        member1Id = "123457";
        testMember1 = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        testMember1.setId(member1Id);
        libraryMembers2.addNewMember(testMember1);
    }

    @Test
    public void testGetMemberById() throws Exception {
        Member member1 = libraryMembers2.getMemberById(member1Id);
        assertNotSame(null, member1);
        assertEquals(testMember1.getId(), member1.getId());
    }

    @Before
    public void beforeTestUpdateMemberDetails() {
        libraryMembers3 = new LibraryMembers();
        testMember1 = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        testMember1.setId("6789");
        libraryMembers3.addNewMember(testMember1);
    }

    @Test
    public void testUpdateMemberDetails() throws Exception {
        // Prepare member object to use for update

        Member updateMember = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        updateMember.setSurname("Kariuki");
        updateMember.setFirstName("John");

        // Do update

        assertTrue(libraryMembers3.updateMemberDetails("6789", updateMember));

        // Confirm update

        Member confirmMember = libraryMembers3.getMemberById("6789");

        assertEquals("6789", confirmMember.getId());
        assertEquals("Kariuki", confirmMember.getSurname());
        assertEquals("John", confirmMember.getFirstName());
    }

    @Before
    public void beforeTestDeleteMember() {
        libraryMembers = new LibraryMembers();
        Member deleteMember = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        deleteMemberId = "delete123";
        deleteMember.setId(deleteMemberId);
        libraryMembers.addNewMember(deleteMember);
    }

    @Test
    public void testDeleteMember() throws Exception {
        // Exercise the deletion

        libraryMembers.deleteMember(deleteMemberId);

        // Confirm deletion

        assertEquals(null, libraryMembers.getMemberById(deleteMemberId));
    }
}