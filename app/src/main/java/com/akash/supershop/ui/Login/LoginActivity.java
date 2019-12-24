package com.akash.supershop.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akash.supershop.R;
import com.akash.supershop.ui.ShopOwner.ShopOwnerActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_edit_text);
        password = findViewById(R.id.password_edit_text);
        loginbtn = findViewById(R.id.loginbtn);
    }

    public void loginStudent(View view) {
        String emailid = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        Toast.makeText(LoginActivity.this,"success",Toast.LENGTH_SHORT).show();
            if(emailid.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("1234")){
                Intent intent=new Intent(LoginActivity.this, ShopOwnerActivity.class);
                startActivity(intent);
                finish();
            }



    }
}
