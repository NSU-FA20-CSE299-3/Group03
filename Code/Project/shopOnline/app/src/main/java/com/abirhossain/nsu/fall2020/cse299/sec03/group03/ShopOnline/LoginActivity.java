package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ModelClasses.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class LoginActivity extends AppCompatActivity {

    private EditText InputNumber, InputPassword;
    private Button LoginBtn;
    private ProgressDialog loadingBar;
    private String PhnDb = "Users";
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InputNumber = findViewById(R.id.login_phone_number_input);
        InputPassword = findViewById(R.id.login_password_input);
        LoginBtn = findViewById(R.id.Login_Page_login);
        loadingBar = new ProgressDialog(this);
        checkBox = findViewById(R.id.remembeMe_chkbox);

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

    private void allowAccess(String phone, String password) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child(PhnDb).child(phone).exists()){

                    Users userData = snapshot.child(PhnDb).child(phone).getValue(Users.class);
                    if (userData.getPhone().equals(phone)){
                        if (userData.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                            Intent loginActivityIntent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(loginActivityIntent);
                        }
                        else {

                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                    }


                }
                else{
                    Toast.makeText(LoginActivity.this, "Account with this number doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}