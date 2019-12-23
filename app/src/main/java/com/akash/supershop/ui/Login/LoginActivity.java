package com.akash.supershop.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akash.supershop.R;
import com.akash.supershop.ui.ShopOwner.ShopOwnerActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginStudent(View view) {
        Intent intent=new Intent(LoginActivity.this, ShopOwnerActivity.class);
        startActivity(intent);
        finish();
    }
}
