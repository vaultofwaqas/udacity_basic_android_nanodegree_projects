package com.waqkz.reportcard;

/**
 * Created by Waqas on 8/11/2016.
 */
public class ReportCard {

    private String mSubjects;
    private int mTermPercent;
    private int mExamPercent;
    private int mAvgPercent;
    private String mGrade;

    public ReportCard(String subjects, int termPercent, int examPercent, int avgPercent, String grade) {

        mSubjects = subjects;
        mTermPercent = termPercent;
        mExamPercent = examPercent;
        mAvgPercent = avgPercent;
        mGrade = grade;
    }

    public String getSubjects() {
        return mSubjects;
    }

    public int getTermPercent() {
        return mTermPercent;
    }

    public void setTermPercent(int termPercent) {
        mTermPercent = termPercent;
    }

    public int getExamPercent() {
        return mExamPercent;
    }

    public void setExamPercent(int examPercent) {
        mExamPercent = examPercent;
    }

    public int getAvgPercent() {
        return mAvgPercent;
    }

    public String getGrade() {
        return mGrade;
    }

    @Override
    public String toString() {
        return "Report Card {" +
                "\n   mSubjects = '" + mSubjects + '\'' + ",\n   " +
                "mTermPercent = " + mTermPercent  + ",\n   "  +
                "mExamPercent = " + mExamPercent  + ",\n   " +
                "mAvgPercent = " + mAvgPercent  + ",\n   " +
                "mGrade = '" + mGrade + '\'' + ".\n" +
                '}';
    }
}
