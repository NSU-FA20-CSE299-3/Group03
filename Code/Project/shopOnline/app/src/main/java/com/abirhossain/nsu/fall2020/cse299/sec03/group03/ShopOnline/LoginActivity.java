package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class LoginActivity extends AppCompatActivity {

    private EditText InputNumber, InputPassword;
    private Button LoginBtn;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InputNumber = findViewById(R.id.login_phone_number_input);
        InputPassword = findViewById(R.id.login_password_input);
        LoginBtn = findViewById(R.id.Login_Page_login);
        loadingBar = new ProgressDialog(this);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });




    }

    private void loginUser() {
        String userPhone = InputNumber.getText().toString();
        String userPass = InputPassword.getText().toString();

        if(TextUtils.isEmpty(userPhone)){
            makeText(this,"Please Enter Your Phone Number", LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(userPass)){
            makeText(this,"Please Enter Your Password", LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Logging Into Your Account");
            loadingBar.setMessage("Please Wait while we check the credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            allowAccess(userPhone,userPass);
        }

    }

    private void allowAccess(String userPhone, String userPass) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

    }


}