package com.example.nirronyhossain.smarthouserent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.nirronyhossain.smarthouserent.RegistrationForm1;

public class RegistrationForm extends AppCompatActivity {

    private EditText registration_name_editText, registration_email_editText, registration_password_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        registration_name_editText = findViewById(R.id.registrationNameID);
        registration_email_editText = findViewById(R.id.registrationEmailID);
        registration_password_editText = findViewById(R.id.registrationPasswordID);
    }

    public void RegistrationButtonID(View view) {
        String registration_name = registration_name_editText.getText().toString();
        String registration_email= registration_email_editText.getText().toString();
        String registration_password = registration_password_editText.getText().toString();

        if(registration_name.isEmpty()){
            registration_name_editText.setError(getString(R.string.empty_field_error_msg));
            return;
        }
        if (registration_email.isEmpty()){
            registration_email_editText.setError(getString(R.string.empty_field_error_msg));
            return;
        }
        if (registration_password.isEmpty()){
            registration_password_editText.setError(getString(R.string.empty_field_error_msg));
            return;
        }

        Intent intent = new Intent(RegistrationForm.this, RegistrationForm1.class);
        intent.putExtra("NAME", registration_name);
        intent.putExtra("EMAIL", registration_email);
        intent.putExtra("PASSWORD", registration_password);
        startActivity(intent);
    }
}
