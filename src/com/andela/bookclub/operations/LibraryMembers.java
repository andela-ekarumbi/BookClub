package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class LibraryMembers {

    // Private variables

    private List<Member> members;

    // Constructors

    public LibraryMembers() {
        this.members = new ArrayList<>();
    }

    // Public methods

    public boolean addNewMember(Member newMember) {
        try {
            return members.add(newMember);
        } catch (Exception exception) {
            return false;
        }
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public Member getMemberById(String id) {

        // First sort the members list using member's id

        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        // Then do a binary search on the members list using
        // the given id

        int foundIndex = Collections.binarySearch()
    }

    public boolean updateMemberDetails(String id, Member member) {
        return false;
    }

    public boolean deleteMember(String id) {
        return false;
    }
}
