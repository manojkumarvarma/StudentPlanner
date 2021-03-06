package com.example.studentplanner;

/**
 * This model will store semester details.
 *
 */

public class StudentTermModel {

    private int termId;
    private String termName;
    private int termStartDate;
    private int termEndDate;

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public int getTermStartDate() {
        return termStartDate;
    }

    public void setTermStartDate(int termStartDate) {
        this.termStartDate = termStartDate;
    }

    public int getTermEndDate() {
        return termEndDate;
    }

    public void setTermEndDate(int termEndDate) {
        this.termEndDate = termEndDate;
    }

}
