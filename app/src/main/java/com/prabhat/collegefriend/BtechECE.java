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

public class BtechECE extends AppCompatActivity implements View.OnClickListener {
//    //First semester
//    TextView electrical, physics, ed, maths, itk;
    FirebaseFirestore firestore;

    String X;
    ProgressDialog dialog;
//    //second semester
//    TextView physics2, english, maths2, evs, manufacturing, mechanics, c;
//    //third semester
//    TextView electronic, chemistry, signal, network, digital, humanities;
//    //forth semester
//    TextView anlog, microcontrollers, antennas, organizational, electronic4, communication;
//    //fifth semsster
//    TextView electromagnetic, computer, probability, digital5, constitution;
//    //sixth semster
//    TextView humanities6, computer6, controller;
//    //seventh semster
//    TextView biology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btechece);

        //firebase
        firestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);

        //first semester
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        findViewById(R.id.e).setOnClickListener(this);

        //second semster
        findViewById(R.id.i).setOnClickListener(this);
        findViewById(R.id.g).setOnClickListener(this);
        findViewById(R.id.h).setOnClickListener(this);
        findViewById(R.id.f).setOnClickListener(this);
        findViewById(R.id.k).setOnClickListener(this);
        findViewById(R.id.j).setOnClickListener(this);
        findViewById(R.id.l).setOnClickListener(this);

        //thhird semster
        findViewById(R.id.m).setOnClickListener(this);
        findViewById(R.id.n).setOnClickListener(this);
        findViewById(R.id.o).setOnClickListener(this);
        findViewById(R.id.p).setOnClickListener(this);
        findViewById(R.id.r).setOnClickListener(this);
        findViewById(R.id.q).setOnClickListener(this);

        //forth semster
        findViewById(R.id.s).setOnClickListener(this);
        findViewById(R.id.t).setOnClickListener(this);
        findViewById(R.id.u).setOnClickListener(this);
        findViewById(R.id.v).setOnClickListener(this);
        findViewById(R.id.x).setOnClickListener(this);
        findViewById(R.id.w).setOnClickListener(this);

        //fifth semster
        findViewById(R.id.aa).setOnClickListener(this);
        findViewById(R.id.z).setOnClickListener(this);
        findViewById(R.id.y).setOnClickListener(this);
        findViewById(R.id.ab).setOnClickListener(this);
        findViewById(R.id.ac).setOnClickListener(this);

        //sixth semster
        findViewById(R.id.ae).setOnClickListener(this);
        findViewById(R.id.ad).setOnClickListener(this);
        findViewById(R.id.af).setOnClickListener(this);

        //seventh semester
        findViewById(R.id.ag).setOnClickListener(this);

        //first semster
//        electrical.setOnClickListener(this);
//        physics.setOnClickListener(this);
//        ed.setOnClickListener(this);
//        maths.setOnClickListener(this);
//        itk.setOnClickListener(this);
//
//        //second semester
//        physics2.setOnClickListener(this);
//        english.setOnClickListener(this);
//        maths2.setOnClickListener(this);
//        evs.setOnClickListener(this);
//        manufacturing.setOnClickListener(this);
//        mechanics.setOnClickListener(this);
//        c.setOnClickListener(this);
//
//        //third semester
//        electronic.setOnClickListener(this);
//        chemistry.setOnClickListener(this);
//        signal.setOnClickListener(this);
//        network.setOnClickListener(this);
//        digital.setOnClickListener(this);
//        humanities.setOnClickListener(this);
//
//        //fourth semester
//        anlog.setOnClickListener(this);
//        microcontrollers.setOnClickListener(this);
//        antennas.setOnClickListener(this);
//        organizational.setOnClickListener(this);
//        electronic4.setOnClickListener(this);
//        communication.setOnClickListener(this);
//
//        //fifth semester
//        electromagnetic.setOnClickListener(this);
//        computer.setOnClickListener(this);
//        probability.setOnClickListener(this);
//        digital5.setOnClickListener(this);
//        constitution.setOnClickListener(this);
//        //sixth semester
//        humanities6.setOnClickListener(this);
//        computer6.setOnClickListener(this);
//        controller.setOnClickListener(this);
//
//        //seventh semster
//        biology.setOnClickListener(this);
        //
//        electrical.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="electrical";
//                geturl();
//            }
//        });
//        physics.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="physics";
//                geturl();
//
//            }
//        });
//        maths.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="mathematics";
//                geturl();
//
//            }
//        });
//        ed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="engineering drawing";
//                geturl();
//
//            }
//        });
//        itk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="indian tradition";
//                geturl();
//
//            }
//        });
//
//        //second semster
//        physics2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="physics2";
//                geturl();
//            }
//        });
//        english.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="english";
//                geturl();
//
//            }
//        });
//        maths2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="mathematics2";
//                geturl();
//
//            }
//        });
//        evs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="evs";
//                geturl();
//
//            }
//        });
//        manufacturing.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="manufacturing";
//                geturl();
//
//            }
//        });
//        mechanics.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="mechanics";
//                geturl();
//
//            }
//        });
//        c.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="c";
//                geturl();
//
//            }
//        });
//
////third semester
//        electronic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="electronic devices";
//                geturl();
//            }
//        });
//        chemistry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="chemistry";
//                geturl();
//
//            }
//        });
//        signal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="signal and system";
//                geturl();
//
//            }
//        });
//        network.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="network theory";
//                geturl();
//
//            }
//        });
//        digital.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="digital system design";
//                geturl();
//
//            }
//        });
//        humanities.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="humanities 1";
//                geturl();
//
//            }
//        });
//        electronic4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="electronic instrumentation";
//                geturl();
//            }
//        });
//        anlog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="analog";
//                geturl();
//
//            }
//        });
//        microcontrollers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="microcontrollers";
//                geturl();
//
//            }
//        });
//        communication.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="communication";
//                geturl();
//
//            }
//        });
//        organizational.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="organizational";
//                geturl();
//
//            }
//        });
//        antennas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="antennas";
//                geturl();
//
//            }
//        });
//
//        //fifth semster
//        constitution.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="constitution";
//                geturl();
//            }
//        });
//        computer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="computer";
//                geturl();
//
//            }
//        });
//        electromagnetic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="electromagnetic";
//                geturl();
//
//            }
//        });
//        digital5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="digital signal processsing";
//                geturl();
//
//            }
//        });
//        probability.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="probability";
//                geturl();
//
//            }
//        });
//        //sixth semster
//
//        computer6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="computer networks";
//                geturl();
//            }
//        });
//        controller.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="control system2";
//                geturl();
//
//            }
//        });
//        humanities6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="humanities2";
//                geturl();
//
//            }
//        });
//        //seventh semster
//        biology.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                X="Biology";
//                geturl();
//            }
//        });
    }

    private void geturl() {
        firestore.collection("btech").document("ece").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    dialog.setMessage("Loading please wait");
                    dialog.show();
                    DocumentSnapshot documentSnapshot = task.getResult();
                    String x = documentSnapshot.getString(X);

                    Intent i = (new Intent(BtechECE.this, PDF_Viewer.class));
                    i.putExtra("X", x);
                    startActivity(i);
                    dialog.hide();


                } else {
                    Log.i("Tag3", "Task error " + task.getException().getMessage());
                    Toast.makeText(BtechECE.this, "Error", Toast.LENGTH_LONG);
                    dialog.hide();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //first semster
            case R.id.a:
                X = "mathematics";
                geturl();
                break;
            case R.id.b:
                X = "physics";
                geturl();
                break;
            case R.id.c:
                X = "electrical";
                geturl();
                break;
            case R.id.d:
                X = "engineering drawing";
                geturl();
                break;
            case R.id.e:
                X = "indian tradition";
                geturl();
                break;
            //second semester
            case R.id.f:
                X = "evs";
                geturl();
                break;
            case R.id.g:
                X = "english";
                geturl();
                break;
            case R.id.h:
                X = "mathematics2";
                geturl();
                break;
            case R.id.i:
                X = "physics2";
                geturl();
                break;
            case R.id.j:
                X = "mechanics";
                geturl();
                break;
            case R.id.k:
                X = "manufacturing";
                geturl();
                break;
            case R.id.l:
                X = "c";
                geturl();
                break;
            //third semester
            case R.id.m:
                X = "electronic devices";
                geturl();
                break;
            case R.id.n:
                X = "chemistry";
                geturl();
                break;
            case R.id.o:
                X = "signal and system";
                geturl();
                break;
            case R.id.p:
                X = "network theory";
                geturl();
                break;
            case R.id.q:
                X = "digital system design";
                geturl();
                break;
            case R.id.r:
                X = "humanities";
                geturl();
                break;
            //fifth semester
            case R.id.s:
                X = "analog";
                geturl();
                break;
            case R.id.t:
                X = "microcontrollers";
                geturl();
                break;
            case R.id.u:
                X = "antennas";
                geturl();
                break;
            case R.id.v:
                X = "organisational";
                geturl();
                break;
            case R.id.w:
                X = "electronic instrumentation";
                geturl();
                break;
            case R.id.y:
                X = "electromagnetic";
                geturl();
                break;
            case R.id.z:
                X = "computer";
                geturl();
                break;
            //seventh semster
            case R.id.aa:
                X = "constitution";
                geturl();
                break;
            case R.id.ab:
                X = "digital signal processsing";
                geturl();
                break;
            //seventh semester
            case R.id.ac:
                X = "probability";
                geturl();
                break;
            case R.id.ad:
                X = "control system2";
                geturl();
                break;
            case R.id.ae:
                X = "computer networks";
                geturl();
                break;
            case R.id.af:
                X = "humanities2";
                geturl();
                break;
            //seven semster
            case R.id.ag:
                X = "biology";
                geturl();
                break;
        }
    }
}
