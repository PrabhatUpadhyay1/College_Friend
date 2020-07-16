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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.prabhat.collegefriend.Home_page;
import com.prabhat.collegefriend.R;

import java.util.HashMap;
import java.util.Map;

public class SignUp_Page extends AppCompatActivity {

    Button Register;
    EditText Name;
    EditText Emailregister;
    EditText passwordregister;
    EditText phone;
    TextView sign_in;
    ProgressDialog dialog;
    FirebaseAuth mfirebaseauth;
    FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up__page);

        sign_in = (TextView) findViewById(R.id.textView28);
        Name = (EditText) findViewById(R.id.editText8);
        Emailregister = (EditText) findViewById(R.id.editText9);
        phone = (EditText) findViewById(R.id.editText10);
        passwordregister = (EditText) findViewById(R.id.editText11);
        Register = (Button) findViewById(R.id.button9);
        dialog = new ProgressDialog(this);

        //Firebase Instance
        mfirebaseauth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();

        //Sign In Text
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp_Page.this, Login_Page.class));finish();
            }
        });

        //Register Button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterMethod();
            }
        });
    }

    private void RegisterMethod() {
        final String email = Emailregister.getText().toString().trim();
        String pwd = passwordregister.getText().toString().trim();
        String ph = phone.getText().toString().trim();
        final String name = Name.getText().toString().trim();

        if (email.isEmpty()) {
            Emailregister.setError("Please enter your Email Id");
            Emailregister.requestFocus();
        } else if (pwd.isEmpty()) {
            passwordregister.setError("Please enter yor password");
            passwordregister.requestFocus();
        } else if (pwd.length() < 6) {
            passwordregister.setError("Minimum 8 character requires");
            passwordregister.requestFocus();
        } else if (ph.isEmpty()) {
            phone.setError("Phone number can't be empty");
            phone.requestFocus();
        } else if (!(ph.length() == 10)) {
            phone.setError("Enter correct phone number");
            phone.requestFocus();
        } else if (name.isEmpty()) {
            Name.setError("Please enter your name");
            Name.requestFocus();
        } else {
            dialog.setMessage("Verifying credentials");
            dialog.show();
            mfirebaseauth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignUp_Page.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        dialog.hide();
                    } else {
                        final String email = Emailregister.getText().toString().trim();
                        String pwd = passwordregister.getText().toString().trim();
                        String ph = phone.getText().toString().trim();
                        String name = Name.getText().toString().trim();

                        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());


                        Map<String, Object> user = new HashMap<>();
                        user.put("Email", email);
                        user.put("Name", name);
                        user.put("Phone", ph);
                        user.put("Course", null);
                        user.put("year", null);
                        mfirestore.collection("Customer").document(email).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(SignUp_Page.this, "Added new contact", Toast.LENGTH_LONG);
                                Intent n = new Intent(SignUp_Page.this, Home_page.class);
                                startActivity(n);
                                Toast.makeText(SignUp_Page.this, "Logged in", Toast.LENGTH_SHORT).show();
                                dialog.hide();
                                finish();
                            }

                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SignUp_Page.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    ;
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignUp_Page.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}