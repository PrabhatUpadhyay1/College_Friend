package com.prabhat.collegefriend.Login_Details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.prabhat.collegefriend.R;

public class Forget_Page extends AppCompatActivity {

    Button submit;
    TextView signin;
    EditText emailforget;
    ProgressDialog dialog;
    FirebaseFirestore mfirestore;
    FirebaseAuth mfirebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget__page);

        submit = findViewById(R.id.button10);
        signin = findViewById(R.id.textView30);
        emailforget = findViewById(R.id.editText12);
        dialog = new ProgressDialog(this);

        //Firebase Instances
        mfirebaseauth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forget_Page.this, Login_Page.class));finish();
            }
        });

        //calling submit method
        Submit();
    }

    private void Submit() {

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = emailforget.getText().toString().trim();
                if (Email.isEmpty()) {
                    emailforget.setError("Please enter your email");
                    emailforget.requestFocus();
                } else {
                    dialog.show();
                    dialog.setMessage("Wait a moment");
                    mfirebaseauth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                dialog.hide();
                                Toast.makeText(Forget_Page.this, "Password has been sent to your Email Id", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            dialog.hide();
                            Toast.makeText(Forget_Page.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
        });
    }
}