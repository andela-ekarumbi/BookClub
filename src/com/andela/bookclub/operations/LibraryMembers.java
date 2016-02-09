package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LibraryMembers {

    private List<Member> members;

    public LibraryMembers() {
        this.members = new ArrayList<>();
    }

    /**
     * Adds a new member to the members collection
     * @param newMember The member to be added.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean addNewMember(Member newMember) {
        try {
            return members.add(newMember);
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Returns a list of all the members in the collection.
     * @return A List object containing all the members in the collection.
     * */

    public List<Member> getAllMembers() {
        return members;
    }

    /**
     * Returns the member with the given id.
     * @param id The id of the member to be retrieved.
     * @return A Member object if found, or null otherwise.
     * */

    public Member getMemberById(String id) {
        int foundPosition = memberSearch(id);

        if (foundPosition == -1) {
            return null;
        } else {
            return members.get(foundPosition);
        }
    }

    private int memberSearch(String id) {
        return Utility.searchById(members, id);
    }

    /**
     * Updates the member with the given id, using the details in the given object.
     * @param id The id of the member to be updated.
     * @param member The Member object containing the update details.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean updateMemberDetails(String id, Member member) {

        try {
            Member existingMember = getMemberById(id);

            if (existingMember != null) {

                Class memberClass = Member.class;

                Field[] memberFields = memberClass.getDeclaredFields();

                for (Field field: memberFields) {

                    field.setAccessible(true);

                    if (field.get(member) != null) {

                        Object incomingValue = field.get(member);

                        field.set(existingMember, incomingValue);
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Deletes the member with the given id.
     * @param id The id of the member to be deleted.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean deleteMember(String id) {
        try {

            int deleteIndex = memberSearch(id);

            if (deleteIndex == -1) {
                return false;
            } else {
                members.remove(deleteIndex);
                return true;
            }
        } catch (Exception exception){
            return false;
        }
    }
}
