package com.prabhat.collegefriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class Twelve extends AppCompatActivity {
    //Arts
    TextView history, geography, english, physicaleducation, information,
            hindi;
    FirebaseFirestore firestore;
    String X;
    ProgressDialog dialog;
    //commerce
    TextView bussiness, economics, maths, english1, physicaleducation1, accountancy;
    //science
    TextView chemistry, physics, maths2, english2, physicaleducation2, information2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve);
//Arts
        history = findViewById(R.id.history);
        geography = findViewById(R.id.data);
        english = findViewById(R.id.digital);
        hindi = findViewById(R.id.analog);
        physicaleducation = findViewById(R.id.textView18);
        information = findViewById(R.id.probability);
        firestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
//commerce
        bussiness = findViewById(R.id.bussiness);
        economics = findViewById(R.id.a);
        maths = findViewById(R.id.b);
        english1 = findViewById(R.id.c);
        physicaleducation1 = findViewById(R.id.d);
        accountancy = findViewById(R.id.e);

//Science
        chemistry = findViewById(R.id.chem);
        physics = findViewById(R.id.f);
        maths2 = findViewById(R.id.g);
        english2 = findViewById(R.id.h);
        physicaleducation2 = findViewById(R.id.j);
        information2 = findViewById(R.id.i);

        //commerce
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "history";
                geturl();

            }
        });
        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "geography";
                geturl();

            }
        });
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "hindi";
                geturl();

            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "english";
                geturl();

            }
        });

        physicaleducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "physicaleducation";
                geturl();

            }
        });
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "informationpractices";
                geturl();

            }
        });
//commercce
        bussiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "bussiness";
                geturl();
            }
        });
        economics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "economics";
                geturl();

            }
        });
        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "maths";
                geturl();

            }
        });
        english1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "english";
                geturl();
            }
        });
        physicaleducation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "physicaleducation";
                geturl();
            }
        });
        accountancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "accountancy";
                geturl();
            }
        });

//science
        chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "chemistry";
                geturl();
            }
        });


        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "physics";
                geturl();
            }
        });

        maths2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "maths";
                geturl();
            }
        });


        english2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "english";
                geturl();
            }
        });


        physicaleducation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "physicaleducation";
                geturl();
            }
        });


        information2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setMessage("Loading please wait");
                dialog.show();
                X = "informationpractices";
                geturl();
            }
        });
    }

    private void geturl() {
        firestore.collection("cbse").document("class12").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot documentSnapshot = task.getResult();
                    String x = documentSnapshot.getString(X);

                    Intent i = (new Intent(Twelve.this, PDF_Viewer.class));
                    i.putExtra("X", x);
                    startActivity(i);
                    dialog.hide();
                } else {
                    Log.i("Tag3", "Task error " + task.getException().getMessage());
                    Toast.makeText(Twelve.this, "Error", Toast.LENGTH_LONG);
                }
            }
        });
    }
}
