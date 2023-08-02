package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView ChoiceCS, loginwithGG, login, tvEmail, tvPassword;
    EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ChoiceCS = findViewById(R.id.ChoiceCS);
        loginwithGG = findViewById(R.id.loginwithGG);
        login = findViewById(R.id.login);
        tvEmail = findViewById(R.id.tvEmail);
        tvPassword = findViewById(R.id.tvPassword);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        ChoiceCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "this is message", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onLogin(View view) {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if(email.equals("") || password.equals("")) {
            if(email.equals("")) {
                tvEmail.setText("*Email");
                tvEmail.setTextColor(Color.RED);
            } else {
                tvEmail.setText("Email");
                tvEmail.setTextColor(Color.GRAY);
            }
            if(password.equals("")) {
                tvPassword.setText("*Password");
                tvPassword.setTextColor(Color.RED);
            } else {
                tvPassword.setText("Password");
                tvPassword.setTextColor(Color.GRAY);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle("Thông tin trống").setMessage("Vui lòng nhập đủ thông tin");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            tvEmail.setText("Email");
            tvEmail.setTextColor(Color.GRAY);
            tvPassword.setText("Password");
            tvPassword.setTextColor(Color.GRAY);
            String choice = ChoiceCS.getText().toString().trim();
//            if(choice.equals("Chọn cơ sở đào tạo")) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                builder.setTitle("Chọn cơ sở đào tạo").setMessage("Vui lòng chọn cơ sở đào tạo");
//                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
            Intent intent = new Intent(LoginActivity.this, ThongBaoActivity.class);
            startActivity(intent);
        }
    }
}