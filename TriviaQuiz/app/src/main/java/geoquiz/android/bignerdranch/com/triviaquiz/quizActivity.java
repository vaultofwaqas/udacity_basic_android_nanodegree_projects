package geoquiz.android.bignerdranch.com.triviaquiz;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Waqas on 4/24/2015.
 */
public class quizActivity extends ActionBarActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuestionTextView;

    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_first, true),
            new TrueFalse(R.string.question_second, false),
            new TrueFalse(R.string.question_third, true),
            new TrueFalse(R.string.question_fourth, true),
            new TrueFalse(R.string.question_fifth, false),
            new TrueFalse(R.string.question_sixth, true),
            new TrueFalse(R.string.question_seventh, false),
            new TrueFalse(R.string.question_eight, true),
            new TrueFalse(R.string.question_ninth, true),
            new TrueFalse(R.string.question_tenth, false),

    };
    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);

        if (mNextButton.isPressed() && mCurrentIndex>=9){
            mNextButton.setEnabled(false);
        }

        if (mPrevButton.isPressed() && mCurrentIndex<=0){
            mPrevButton.setEnabled(false);
        }

        if (mPrevButton.isPressed() && mCurrentIndex<=9){
            mNextButton.setEnabled(true);
        }

        if (mNextButton.isPressed() && mCurrentIndex>=0){
            mPrevButton.setEnabled(true);
        }

    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;

            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;


            } else {
                messageResId = R.string.incorrect_toast;
            }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();




    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mPrevButton = (Button)findViewById(R.id.prev_button);
        mPrevButton.setEnabled(false);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mTrueButton = (Button)findViewById(R.id.true_button);
        getTrueButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);

                mTrueButton.setEnabled(false);
                mFalseButton.setEnabled(false);
            }
        });
        setFalseButton((Button) findViewById(R.id.false_button));
        getFalseButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);

                mTrueButton.setEnabled(false);
                mFalseButton.setEnabled(false);
            }
        });

        mPrevButton = (Button)findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mNextButton.isPressed()){
                    mTrueButton.setEnabled(true);
                    mFalseButton.setEnabled(true);
                }

                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        updateQuestion();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    public Button getTrueButton() {
        return mTrueButton;
    }

    public void setTrueButton(Button trueButton) {
        mTrueButton = trueButton;
    }

    public Button getFalseButton() {
        return mFalseButton;
    }

    public void setFalseButton(Button falseButton) {
        mFalseButton = falseButton;
    }
}
