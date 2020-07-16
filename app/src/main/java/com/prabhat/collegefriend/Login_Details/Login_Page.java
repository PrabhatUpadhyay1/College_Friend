package com.prabhat.collegefriend.Login_Details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.Login;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.facebook.FacebookSdk;
import com.prabhat.collegefriend.Home_page;
import com.prabhat.collegefriend.R;

import java.util.HashMap;
import java.util.Map;

public class Login_Page extends AppCompatActivity {

    EditText Emaillogin;
    EditText passwordlogin;
    Button Signin, google;
    TextView register;
    FirebaseFirestore mfirestore;
    TextView forgetpassword;
    FirebaseAuth mfirebaseauth;

    ProgressDialog dialog;
    private int RC_SIGN_IN = 1;

    //Google
    private GoogleSignInClient mGoogleSignInClient;

    //facebook
    private CallbackManager callbackManager;

    //If already logged in jump to home page
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mfirebaseauth.getCurrentUser();
        if (currentUser != null) {
            Toast.makeText(Login_Page.this, "You are logged in", Toast.LENGTH_SHORT).show();
            Intent m = new Intent(Login_Page.this, Home_page.class);
            startActivity(m);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Emaillogin = (EditText) findViewById(R.id.editText);
        passwordlogin = (EditText) findViewById(R.id.editText3);
        Signin = (Button) findViewById(R.id.button);
        register = (TextView) findViewById(R.id.textView3);
        forgetpassword = (TextView) findViewById(R.id.textView);
        mfirebaseauth = FirebaseAuth.getInstance();
        mfirestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);

        //facebook
        FacebookSdk.sdkInitialize(getApplicationContext());
        //AppEventsLogger.activateApp(this);

        callbackManager = CallbackManager.Factory.create();

        // Configure Google Sign In

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        google = findViewById(R.id.google);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                dialog.hide();
                startActivityForResult(signInIntent, RC_SIGN_IN);
                dialog.hide();
            }
        });

        //facebook
        LoginButton loginButton = findViewById(R.id.facebook);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(Login_Page.this, "Logged In", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login_Page.this, Home_page.class));
                finish();
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(Login_Page.this, "Signed In cancelled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(Login_Page.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //Sign in button
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Page.this,SignUp_Page.class));
            }
        });
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Page.this,Forget_Page.class));
            }
        });
    }

    //Sign In Method
    private void SignIn() {
        String email = Emaillogin.getText().toString().trim();
        String pwd = passwordlogin.getText().toString().trim();
        if (email.isEmpty()) {
            Emaillogin.setError("Email are empty");
            Emaillogin.requestFocus();
        } else if (pwd.isEmpty()) {
            passwordlogin.setError("Password is Empty");
            passwordlogin.requestFocus();
        } else if (!(email.isEmpty() && pwd.isEmpty())) {

            mfirebaseauth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(Login_Page.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                    } else {
                        dialog.setMessage("Signing in..");
                        dialog.show();

                        Intent n = new Intent(Login_Page.this, Home_page.class);
                        startActivity(n);
                        Toast.makeText(Login_Page.this, "Logged in", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Login_Page.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(Login_Page.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }

    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mfirebaseauth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.hide();
                        if (task.isSuccessful()) {
                            dialog.hide();
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mfirebaseauth.getCurrentUser();

                            updateUIf(user);
                        } else {
                            dialog.hide();
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Login_Page.this, "Authentication failed",
                                    Toast.LENGTH_SHORT).show();
                            updateUIf(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUIf(FirebaseUser user1) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Name", user1.getDisplayName());
        hashMap.put("Email", user1.getEmail());
        hashMap.put("Phone", user1.getPhoneNumber());
        mfirestore.collection("Customerfacebook").document(user1.getUid()).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login_Page.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN && resultCode == RESULT_OK) {
            dialog.show();
            dialog.setMessage("Verifying credentials..");
            Intent n = new Intent(Login_Page.this, Home_page.class);
            startActivity(n);
            dialog.hide();
            finish();
            Toast.makeText(Login_Page.this, "Logged in", Toast.LENGTH_SHORT).show();
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                dialog.hide();
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                dialog.hide();
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mfirebaseauth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.hide();
                        if (task.isSuccessful()) {
                            dialog.hide();
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mfirebaseauth.getCurrentUser();
                            updateUI(user);
                        } else {
                            dialog.hide();
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Login_Page.this, "Failed", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put("Email", googleSignInAccount.getEmail());
        hashMap.put("Name", googleSignInAccount.getDisplayName());

        mfirestore.collection("googleCustomer").document(googleSignInAccount.getId()).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                dialog.hide();
                finish();


            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login_Page.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}