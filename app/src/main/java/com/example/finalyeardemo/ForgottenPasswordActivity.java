package com.example.finalyeardemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgottenPasswordActivity extends AppCompatActivity {
    EditText email;
    Button sendemail;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);

        email = findViewById(R.id.editText_user_email);
        sendemail = findViewById(R.id.button_send_email);
        firebaseAuth = FirebaseAuth.getInstance();

        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = email.getText().toString();

                if (useremail.equals("")) {
                    Toast.makeText(ForgottenPasswordActivity.this, "Please enter your registered email", Toast.LENGTH_LONG).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ForgottenPasswordActivity.this, "Reset Email Sent to user Account", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(ForgottenPasswordActivity.this, MainActivity.class));
                            }else{
                                Toast.makeText(ForgottenPasswordActivity.this, "Error in sending Password Reset Email", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });



    }
}
