package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;

import java.util.ArrayList;
import java.util.List;

public class LibraryMembers {

    // Private variables

    private List<Member> members;

    // Constructors

    public LibraryMembers() {
        this.members = new ArrayList<>();
    }

    // Public methods

    public boolean addNewMember(Member newMember) {
        return false;
    }

    public List<Member> getAllMembers() {
        return null;
    }

    public Member getMemberById(String id) {
        return  null;
    }

    public boolean updateMemberDetails(String id, Member member) {
        return false;
    }

    public boolean deleteMember(String id) {
        return false;
    }
}