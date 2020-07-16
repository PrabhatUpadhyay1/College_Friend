package com.prabhat.collegefriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

public class CBSE extends AppCompatActivity implements View.OnClickListener {
//    CardView twelve;
//    //class tenth
//    TextView maths, science, english, hindi, sst;
    FirebaseFirestore firestore;
    String X;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbse);

        findViewById(R.id.card12).setOnClickListener(this);

        //class 10th
        findViewById(R.id.textView14).setOnClickListener(this);
        findViewById(R.id.textView11).setOnClickListener(this);
        findViewById(R.id.textView80).setOnClickListener(this);
        findViewById(R.id.textView10).setOnClickListener(this);
        findViewById(R.id.textView70).setOnClickListener(this);

        //firebase
        firestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);


//        twelve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(CBSE.this, Twelve.class));
//            }
//        });
//
//        maths.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X = "mathematics";
//                geturl();
//            }
//        });
//
//        science.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X = "science";
//                geturl();
//
//            }
//        });
//
//        english.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X = "english";
//                geturl();
//
//            }
//        });
//
//        hindi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.show();
//                dialog.setMessage("Loading please wait");
//                X = "hindi";
//                geturl();
//
//            }
//        });
//
//        sst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X = "sst";
//                geturl();
//
//            }
//        });

    }

    private void geturl() {
        firestore.collection("cbse").document("class10").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot documentSnapshot = task.getResult();
                    String x = documentSnapshot.getString(X);

                    Intent i = (new Intent(CBSE.this, PDF_Viewer.class));
                    i.putExtra("X", x);
                    startActivity(i);
                    dialog.hide();

                } else {
                    Log.i("Tag3", "Task error " + task.getException().getMessage());
                    Toast.makeText(CBSE.this, "Error", Toast.LENGTH_LONG);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView14:
                X = "mathematics";
                geturl();
                break;
            case R.id.textView11:
                X = "science";
                geturl();
                break;
            case R.id.textView80:
                X = "english";
                geturl();
                break;
            case R.id.textView10:
                X = "hindi";
                geturl();
                break;
            case R.id.textView70:
                X = "sst";
                geturl();
                break;
            case R.id.card12:
                startActivity(new Intent(CBSE.this, Twelve.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
