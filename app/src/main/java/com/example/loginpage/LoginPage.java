package com.example.loginpage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity {
    EditText email,pass;
    TextView newuser;
    ImageView login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().getInsetsController().hide(WindowInsets.Type.statusBars());
        }
        login_btn = findViewById(R.id.iv_login);
        newuser = findViewById(R.id.tv_newuser);
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_pass);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().trim().isEmpty()){
                    email.setError("required");
                    return;
                }
                if (pass.getText().toString().trim().isEmpty()){
                    pass.setError("requires");
                    return;
                }
//                Bundle bundle = new Bundle();
//                bundle.putString("email",email.getText().toString().trim());
                Intent i = new Intent(LoginPage.this, MainActivity.class);
                i.putExtra("email",email.getText().toString().trim());

                startActivity(i);

            }
        });

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginPage.this,SignupPage.class);
                startActivity(i);
            }
        });

    }
}