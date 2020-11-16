package com.mobile.ordercoffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    EditText edtName, edtPass, edtConfirmPass;
    Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.reg_edtName);
        edtPass = findViewById(R.id.reg_edtPass);
        edtConfirmPass = findViewById(R.id.reg_edtConfirmPass);
        btnLogin = findViewById(R.id.reg_btnLogin);
        btnRegister = findViewById(R.id.reg_btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String pass = edtPass.getText().toString();
                String confirm = edtConfirmPass.getText().toString();
                if(pass.compareToIgnoreCase(confirm) == 0) {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("pass", pass);
                    setResult(101, intent);
                    finish();
                    Toast.makeText(RegisterActivity.this, "Registered !!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
