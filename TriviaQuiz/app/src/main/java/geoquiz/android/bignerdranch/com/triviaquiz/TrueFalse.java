package geoquiz.android.bignerdranch.com.triviaquiz;

import android.support.v7.app.ActionBarActivity;

/**
 * Created by Waqas on 4/24/2015.
 */
public class TrueFalse extends ActionBarActivity {
    private int mQuestion;
    private boolean mTrueQuestion;
    public TrueFalse(int question, boolean trueQuestion) {
        setQuestion(question);
        setTrueQuestion(trueQuestion);
    }
    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }
}
