package com.andela.bookclub.models;

import java.util.Date;

public class LogEntry extends Model {

    // Private fields

    private Member member;

    private String entryDescription;

    private Date timeStart;

    private Date timeEnd;

    private StaffMember loggedBy;

    // Getters and setters

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getEntryDescription() {
        return entryDescription;
    }

    public void setEntryDescription(String entryDescription) {
        this.entryDescription = entryDescription;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public StaffMember getLoggedBy() {
        return loggedBy;
    }

    public void setLoggedBy(StaffMember loggedBy) {
        this.loggedBy = loggedBy;
    }
}
