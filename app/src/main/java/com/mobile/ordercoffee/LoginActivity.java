package com.mobile.ordercoffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText edtName, edtPass;
    Button btnLogin, btnRegister;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        edtName = findViewById(R.id.login_edtName);
        edtPass = findViewById(R.id.login_edtPass);
        btnLogin = findViewById(R.id.login_btnLogin);
        btnRegister = findViewById(R.id.login_btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String pass = edtPass.getText().toString();
                if(edtName.getText().toString().equals(name) && edtPass.getText().toString().equals(pass))
                {
                    startActivity(new Intent(LoginActivity.this, TopActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Fail to login !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 101)
        {
            username = data.getStringExtra("name");
            password = data.getStringExtra("pass");
        }
    }
}
