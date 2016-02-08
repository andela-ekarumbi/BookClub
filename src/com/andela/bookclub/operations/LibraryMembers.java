package com.andela.bookclub.operations;

import com.andela.bookclub.models.Member;

import java.lang.reflect.Field;
import java.util.ArrayList;
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

    public boolean updateMemberDetails(String id, Member member) {

        // We will (attempt to) use type reflection to detect changes in the
        // incoming object and apply them to the existing object.

        try {
            Member existingMember = getMemberById(id);

            // Proceed only if there is a member with the given id

            if (existingMember != null) {

                // Get Class object for Member

                Class memberClass = Member.class;

                // Get array of Field objects for private fields in memberClass

                Field[] memberFields = memberClass.getDeclaredFields();

                // Iterate through field array

                for (Field field: memberFields) {

                    // Make private field acessible

                    field.setAccessible(true);

                    // Proceed only if the value of this field in the incoming
                    // object is not null

                    if (field.get(member) != null) {

                        // Obtain the value of this field in the incoming object

                        Object incomingValue = field.get(member);

                        // Set the value of this field in the existing object to the new
                        // value

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

    public boolean deleteMember(String id) {
        try {
            // Obtain the index of the object to be deleted

            int deleteIndex = memberSearch(id);

            // Delete only if index is valid

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
