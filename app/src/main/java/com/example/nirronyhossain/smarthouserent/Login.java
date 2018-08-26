package com.example.nirronyhossain.smarthouserent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.nirronyhossain.smarthouserent.RegistrationForm1;

public class Login extends AppCompatActivity {

    private EditText login_Email_EditText, login_Password_EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_Email_EditText = findViewById(R.id.loginEmailID);
        login_Password_EditText = findViewById(R.id.loginPasswordID);


    }


    public void loginButton(View view) {

        String login_Email = login_Email_EditText.getText().toString();
        String login_Password = login_Password_EditText.getText().toString();

        if(login_Email.isEmpty()){
            login_Email_EditText.setError(getString(R.string.empty_field_error_msg));
            return;
        }
        if(login_Password.isEmpty()){
            login_Password_EditText.setError(getString(R.string.empty_field_error_msg));
            return;
        }

        Intent intent = new Intent(Login.this, RentalList.class);
        startActivity(intent);
    }

    public void signUpText(View view) {

        Intent intent = new Intent(Login.this, RegistrationForm.class);
        startActivity(intent);
    }


    public void add_post(View view) {
        Intent intent = new Intent(Login.this, LandLoderAddPost.class);
        startActivity(intent);
    }
}
