package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.StudentMember;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryMembersTest {

    private LibraryMembers libraryMembers;

    private LibraryMembers libraryMembers2;

    private LibraryMembers libraryMembers3;

    private Member memberEston;

    private String memberEstonId;

    private String deleteMemberId;

    @Test
    public void testAddNewMember() throws Exception {
        memberEston = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        assertTrue(libraryMembers.addNewMember(memberEston));
    }

    @Before
    public void beforeTestGetAllMembers() {
        libraryMembers = new LibraryMembers();

        for (int i = 0; i < 5; i++) {
            Member addMember = new StudentMember();
            addMember.setId(Integer.toString(i));
            libraryMembers.addNewMember(addMember);
        }
    }

    @Test
    public void testGetAllMembers() throws Exception {
        List<Member> members = libraryMembers.getAllMembers();
        assertNotNull(members);
        assertEquals(5, members.size());
    }

    @Before
    public void beforeTestGetMemberById() {
        libraryMembers2 = new LibraryMembers();
        memberEstonId = "123457";
        memberEston = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        memberEston.setId(memberEstonId);
        libraryMembers2.addNewMember(memberEston);
    }

    @Test
    public void testGetMemberById() throws Exception {
        Member testGetMember = libraryMembers2.getMemberById(memberEstonId);
        assertNotNull(testGetMember);
        assertEquals(memberEston.getId(), testGetMember.getId());
    }

    @Before
    public void beforeTestUpdateMemberDetails() {
        libraryMembers3 = new LibraryMembers();
        memberEston = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        memberEston.setId("6789");
        libraryMembers3.addNewMember(memberEston);
    }

    @Test
    public void testUpdateMemberDetails() throws Exception {
        Member updateMember = Mockito.mock(Member.class, Mockito.CALLS_REAL_METHODS);
        updateMember.setSurname("Kariuki");
        updateMember.setFirstName("John");

        assertTrue(libraryMembers3.updateMemberDetails("6789", updateMember));

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
        libraryMembers.deleteMember(deleteMemberId);

        assertEquals(null, libraryMembers.getMemberById(deleteMemberId));
    }
}