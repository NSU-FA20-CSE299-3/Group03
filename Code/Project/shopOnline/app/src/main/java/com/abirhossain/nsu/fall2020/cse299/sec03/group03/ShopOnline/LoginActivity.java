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
import android.widget.TextView;
import android.widget.Toast;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ModelClasses.Users;
import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import io.paperdb.Paper;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class LoginActivity extends AppCompatActivity {

    private EditText InputNumber, InputPassword;
    private Button LoginBtn;
    private ProgressDialog loadingBar;
    private TextView admin, nonAdmin;

    private String PhnDb = "Users";
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InputNumber = findViewById(R.id.login_phone_number_input);
        InputPassword = findViewById(R.id.login_password_input);
        LoginBtn = findViewById(R.id.Login_Page_login);
        admin = findViewById(R.id.EnterAdminPanel);
        nonAdmin = findViewById(R.id.EnterNonAdminPanel);

        loadingBar = new ProgressDialog(this);
        checkBox = findViewById(R.id.remembeMe_chkbox);
        Paper.init(this);



        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginBtn.setText("Admin Login");
                admin.setVisibility(View.INVISIBLE);
                nonAdmin.setVisibility(View.VISIBLE);
                PhnDb = "Admins";

            }
        });

        nonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginBtn.setText("Login");
                admin.setVisibility(View.VISIBLE);
                nonAdmin.setVisibility(View.INVISIBLE);
                PhnDb = "Users";
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

        if (checkBox.isChecked()){
            Paper.book().write(Prevalent.UserPhoneKey,phone);
            Paper.book().write(Prevalent.UserPasswordKey,password);
        }

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child(PhnDb).child(phone).exists()){

                    Users userData = snapshot.child(PhnDb).child(phone).getValue(Users.class);
                    if (userData.getPhone().equals(phone)){
                        if (userData.getPassword().equals(password)){

                            if(PhnDb.equals("Admins")){
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent AdminLoginActivityIntent = new Intent(LoginActivity.this, ProductCatagoryAdmin.class);
                                startActivity(AdminLoginActivityIntent);

                            }
                            else if (PhnDb.equals("Users")){
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Intent loginActivityIntent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(loginActivityIntent);

                            }

                        }
                        else {

                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                    }


                }
                else{
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this, "Account with this number doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}