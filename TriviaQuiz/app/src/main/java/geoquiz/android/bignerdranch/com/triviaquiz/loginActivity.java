package geoquiz.android.bignerdranch.com.triviaquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Waqas on 4/24/2015.
 */
public class loginActivity extends ActionBarActivity {

    private EditText username;
    private EditText password;
    private Button mLogin;
    private Button mSignUp;
    private SharedPreferences loginPrefs;
    private SharedPreferences.Editor loginEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.user_name);
        password = (EditText)findViewById(R.id.password);

        mLogin = (Button)findViewById(R.id.logIn);
        mLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (mLogin.isPressed()){

                    Intent intent = getIntent();
                    ArrayList<String> stringArray = intent.getStringArrayListExtra("string_array");

                    if((stringArray != null) && (username.getText().toString().equals(stringArray.get(0))) && (password.getText().toString().equals(stringArray.get(4))) ) {
                        Intent intent1 = new Intent(loginActivity.this,quizActivity.class);
                        startActivity(intent1);
                    }
                    else{
                        Toast.makeText(loginActivity.this, "Username or Password is invalid!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mSignUp = (Button)findViewById(R.id.sign_up);
        mSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, signUpActivity.class);
                startActivity(intent);
            }
        });
    }

}
