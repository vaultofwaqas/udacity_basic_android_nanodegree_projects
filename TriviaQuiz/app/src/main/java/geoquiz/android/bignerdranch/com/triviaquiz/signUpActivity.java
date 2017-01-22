package geoquiz.android.bignerdranch.com.triviaquiz;

import android.content.Context;
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
public class signUpActivity extends ActionBarActivity {

    public static final String string_array = "geoquiz.android.bignerdranch.com.string_array";

    private Button mLogin;
    private Button mSignUp;
    private Button mBack;
    private EditText username2;
    private EditText firstName;
    private EditText lastName;
    private EditText emailAddress;
    private EditText createPassword;
    private EditText confirmPassword;

    /*public static final String PREFS_NAME = "myPreferencesFile";*/


    ArrayList<String> myStringArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mLogin = (Button)findViewById(R.id.logIn);
        mLogin.setEnabled(false);

        username2 = (EditText)findViewById(R.id.user_name2);
        firstName = (EditText)findViewById(R.id.first_name);
        lastName = (EditText)findViewById(R.id.last_name);
        emailAddress = (EditText)findViewById(R.id.email_address);

        final String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

        createPassword = (EditText)findViewById(R.id.create_password);
        confirmPassword = (EditText)findViewById(R.id.confirm_password);

        mSignUp = (Button)findViewById(R.id.sign_up);
        mSignUp.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (mSignUp.isPressed()){

                    if( username2.getText().toString().length() == 0 )
                        username2.setError( "Username is required!" );
                    else{
                        myStringArray.add(username2.getText().toString());
                        username2.setEnabled(false);}

                    if( firstName.getText().toString().length() == 0 )
                        firstName.setError( "First name is required!" );
                    else{
                        myStringArray.add(firstName.getText().toString());
                        firstName.setEnabled(false);}

                    if( lastName.getText().toString().length() == 0 )
                        lastName.setError( "Last name is required!" );
                    else{
                        myStringArray.add(lastName.getText().toString());
                        lastName.setEnabled(false);}

                    if (emailAddress.getText().toString().trim().matches(emailPattern)){
                        myStringArray.add(emailAddress.getText().toString());
                        emailAddress.setEnabled(false);}
                    else{
                        emailAddress.setError( "Email Address is required or is invalid!" );}

                    if ((createPassword.getText().toString().equals(confirmPassword.getText().toString()) && createPassword.getText().length() != 0)){
                        myStringArray.add(createPassword.getText().toString());
                        confirmPassword.setEnabled(false);
                        createPassword.setEnabled(false);}
                    else{
                        createPassword.setError( "Password is required or doesn't match!" );}

                    if(username2.getText().toString().length() !=0 && firstName.getText().toString().length() !=0 && lastName.getText().toString().length() !=0
                            && emailAddress.getText().toString().matches(emailPattern) && createPassword.getText().toString().equals(confirmPassword.getText().toString()))
                        Toast.makeText(signUpActivity.this, "You have successfully signed up!", Toast.LENGTH_SHORT).show();
                }


                /*SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("myStringArray", ObjectSer)*/

                if (username2.getText().toString().length() !=0 && firstName.getText().toString().length() !=0 && lastName.getText().toString().length() !=0
                        && emailAddress.getText().toString().matches(emailPattern) && createPassword.getText().toString().equals(confirmPassword.getText().toString()))
               {
                mLogin = (Button)findViewById(R.id.logIn);
                mLogin.setEnabled(true);
                mLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent i = new Intent(signUpActivity.this,loginActivity.class);
                        i.putStringArrayListExtra("string_array", myStringArray);
                        startActivity(i);
                    }
                });}

            }
        });

        mBack = (Button)findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUpActivity.this, titleActivity.class);
                startActivity(intent);
            }
        });

    }
}
