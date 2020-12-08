package com.abirhossain.nsu.fall2020.cse299.sec03.group03.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private Button signUpBtn;
    private EditText inputName, inputPhone, inputPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signUpBtn =(Button)findViewById(R.id.SignUp_Page_SignUp);
        inputName = (EditText)findViewById(R.id.SignUp_UserName_input);
        inputPhone = (EditText)findViewById(R.id.SignUp_phone_number_input);
        inputPass = (EditText)findViewById(R.id.signUp_password_input);



    }
}