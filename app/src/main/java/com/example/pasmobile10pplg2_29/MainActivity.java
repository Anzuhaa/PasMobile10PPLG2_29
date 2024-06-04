package com.example.pasmobile10pplg2_29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME ="MyPrefsFile";

    Button btnLogin;
    EditText etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings =getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.txtUsername);
        etPassword = findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("admin")&& etPassword.getText().toString().equals("admin")) {
                    editor.putString("user", etUsername.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, burger_nav.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    etUsername.setText("");
                    etPassword.setText("");
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}