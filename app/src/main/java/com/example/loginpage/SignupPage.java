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

public class SignupPage extends AppCompatActivity {
    EditText name,email,mob,pass;
    ImageView signup_btn;
    TextView olduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        mob = findViewById(R.id.et_mob);
        pass = findViewById(R.id.et_pass);
        signup_btn = findViewById(R.id.iv_signup);
        olduser = findViewById(R.id.tv_olduser);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().getInsetsController().hide(WindowInsets.Type.statusBars());
        }

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().isEmpty()){
                    name.setError("required");
                    return;
                }
                if (email.getText().toString().trim().isEmpty()){
                    email.setError("required");
                    return;
                }
                if (mob.getText().toString().trim().isEmpty()){
                    mob.setError("required");
                    return;
                }
                if (pass.getText().toString().trim().isEmpty()){
                    pass.setError("required");
                }
                Bundle bundle = new Bundle();
//                bundle.putString("email",email.getText().toString().trim());/
                Intent i = new Intent(SignupPage.this, MainActivity.class);
                i.putExtra("email",email.getText().toString().trim());
                startActivity(i);

            }
        });
        olduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupPage.this,LoginPage.class);
                startActivity(i);
            }
        });

    }
}