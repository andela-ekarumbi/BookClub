package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.Model;

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
        return memberSearch(id);
    }

    private Member memberSearch(String id) {

        // First sort the members list

        Collections.sort(members);

        // Then do a binary search for the member with the given id

        int start = 0;

        int length = members.size();

        int end = length - 1;

        while (start <= end) {

            if (members.get(start).getId().equals(id)) {
                return members.get(start);
            }

            if (members.get(end).getId().equals(id)) {
                return members.get(end);
            }

            int mid = Math.floorDiv((start + end), 2);

            if (members.get(mid).getId().equals(id)) {
                return members.get(mid);
            } else {

                if (members.get(mid).getId().compareTo(id) < 0) {
                    end = mid - 1;
                    start += 1;
                } else {
                    start = mid + 1;
                    end -= 1;
                }
            }
        }

        return null;
    }

    public boolean updateMemberDetails(String id, Member member) {
        return false;
    }

    public boolean deleteMember(String id) {
        return false;
    }
}
