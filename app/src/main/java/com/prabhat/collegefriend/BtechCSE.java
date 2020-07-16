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

public class BtechCSE extends AppCompatActivity implements View.OnClickListener {
    // first semester
//    TextView electrical, physics, ed, maths, itk;
    FirebaseFirestore firestore;
    String X;
    ProgressDialog dialog;
    //second year
//    TextView physics2, english, maths2, evs, manufacturing, mechanics, c;
//    //third year
//    TextView digital, chemistry, analog, dat, it, humanities;
//    //forth semster
//    TextView maths4, organizational, computer, design, operating;
//    //fith semseter
//    TextView signal, data, constitution, language, object, humanities5;
//    //sixth semester
//    TextView compiler, computer6;
//    //seventh sem
//    TextView biology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btechcse);
        //firebase
        firestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);

        //fisrt year
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        findViewById(R.id.e).setOnClickListener(this);
        //second year
        findViewById(R.id.i).setOnClickListener(this);
        findViewById(R.id.g).setOnClickListener(this);
        findViewById(R.id.h).setOnClickListener(this);
        findViewById(R.id.f).setOnClickListener(this);
        findViewById(R.id.k).setOnClickListener(this);
        findViewById(R.id.j).setOnClickListener(this);
        findViewById(R.id.l).setOnClickListener(this);
        //third semester
        findViewById(R.id.ah).setOnClickListener(this);
        findViewById(R.id.ai).setOnClickListener(this);
        findViewById(R.id.ak).setOnClickListener(this);
        findViewById(R.id.aj).setOnClickListener(this);
        findViewById(R.id.al).setOnClickListener(this);
        findViewById(R.id.am).setOnClickListener(this);

        //forth semester
        findViewById(R.id.an).setOnClickListener(this);
        findViewById(R.id.ap).setOnClickListener(this);
        findViewById(R.id.ar).setOnClickListener(this);
        findViewById(R.id.aq).setOnClickListener(this);
        findViewById(R.id.ao).setOnClickListener(this);

        //fifth semster
        findViewById(R.id.as).setOnClickListener(this);
        findViewById(R.id.at).setOnClickListener(this);
        findViewById(R.id.au).setOnClickListener(this);
        findViewById(R.id.av).setOnClickListener(this);
        findViewById(R.id.aw).setOnClickListener(this);
        findViewById(R.id.ax).setOnClickListener(this);

        //sixth semester
        findViewById(R.id.az).setOnClickListener(this);
        findViewById(R.id.ay).setOnClickListener(this);

        //seventh semester
        findViewById(R.id.bio).setOnClickListener(this);

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
//        digital.setOnClickListener(this);
//        chemistry.setOnClickListener(this);
//        dat.setOnClickListener(this);
//        analog.setOnClickListener(this);
//        it.setOnClickListener(this);
//        humanities.setOnClickListener(this);
//
//        //fourth semester
//        maths4.setOnClickListener(this);
//        organizational.setOnClickListener(this);
//        computer.setOnClickListener(this);
//        design.setOnClickListener(this);
//        operating.setOnClickListener(this);
//
//        //fifth semester
//        signal.setOnClickListener(this);
//        data.setOnClickListener(this);
//        constitution.setOnClickListener(this);
//        language.setOnClickListener(this);
//        object.setOnClickListener(this);
//        humanities5.setOnClickListener(this);
//
//        //sixth semester
//        compiler.setOnClickListener(this);
//        computer6.setOnClickListener(this);
//
//        //seventh semster
//        biology.setOnClickListener(this);

//        //first sem
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
////second year
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
////third year
//        digital.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="digital electronics";
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
//        analog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="analog electronics";
//                geturl();
//
//            }
//        });
//        it.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="it workshop";
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
//        dat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="data structure and algorithm";
//                geturl();
//
//            }
//        });
//        //forth semester
//        maths4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="discrete mathematics";
//                geturl();
//            }
//        });
//        organizational.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="organizational behaviour";
//                geturl();
//
//            }
//        });
//        computer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="computer organization and architecture";
//                geturl();
//
//            }
//        });
//        design.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="design and analysis of algorithms";
//                geturl();
//
//            }
//        });
//        operating.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="operating system";
//                geturl();
//
//            }
//        });
//
//        //fifth semester
//        signal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="signal and system cs";
//                geturl();
//            }
//        });
//        data.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="data management systems";
//                geturl();
//
//            }
//        });
//        constitution.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="constitution of india";
//                geturl();
//
//            }
//        });
//        language.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="formal language and automata theory";
//                geturl();
//
//            }
//        });
//        object.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="object oriented programming";
//                geturl();
//
//            }
//        });
//        humanities5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="humanities 2";
//                geturl();
//
//            }
//        });
//
//        //sixth semester
//        compiler.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="compiler design";
//                geturl();
//            }
//        });
//        computer6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="computer networks";
//                geturl();
//
//            }
//        });
////seventh sem
//        biology.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setMessage("Loading please wait");
//                dialog.show();
//                X="compiler design";
//                geturl();
//            }
//        });
    }

    private void geturl() {
        firestore.collection("btech").document("ece").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot documentSnapshot = task.getResult();
                    String x = documentSnapshot.getString(X);


                    Intent i = (new Intent(BtechCSE.this, PDF_Viewer.class));
                    i.putExtra("X", x);
                    startActivity(i);
                    dialog.hide();


                } else {
                    Log.i("Tag3", "Task error " + task.getException().getMessage());
                    Toast.makeText(BtechCSE.this, "Error", Toast.LENGTH_LONG);
                    dialog.hide();
                }
            }
        });
    }

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
            case R.id.ah:
                X = "digital electronics";
                geturl();
                break;
            case R.id.ai:
                X = "chemistry";
                geturl();
                break;
            case R.id.aj:
                X = "analog electronics";
                geturl();
                break;
            case R.id.ak:
                X = "data structure and algorithm";
                geturl();
                break;
            case R.id.al:
                X = "it workshop";
                geturl();
                break;
            case R.id.am:
                X = "humanities 1";
                geturl();
                break;
            //fifth semester
            case R.id.an:
                X = "discrete mathematics";
                geturl();
                break;
            case R.id.ao:
                X = "operating system";
                geturl();
                break;
            case R.id.ap:
                X = "organisational behaviour";
                geturl();
                break;
            case R.id.aq:
                X = "design and analysis of algorithms";
                geturl();
                break;
            case R.id.ar:
                X = "computer organisation ans architecture";
                geturl();
                break;
            case R.id.as:
                X = "signal and system";
                geturl();
                break;
            case R.id.at:
                X = "data management system";
                geturl();
                break;
            //seventh semster
            case R.id.au:
                X = "constitution of india";
                geturl();
                break;
            case R.id.av:
                X = "formal language and automata";
                geturl();
                break;
            //seventh semester
            case R.id.aw:
                X = "object oriented programming";
                geturl();
                break;
            case R.id.ax:
                X = "humanities 2";
                geturl();
                break;
            case R.id.ay:
                X = "compiler design";
                geturl();
                break;
            case R.id.az:
                X = "computer networks";
                geturl();
                break;
            //seven semster
            case R.id.bio:
                X = "biology";
                geturl();
                break;
        }
    }

}