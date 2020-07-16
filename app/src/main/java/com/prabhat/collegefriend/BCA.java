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

public class BCA extends AppCompatActivity implements View.OnClickListener {
    TextView a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p;
    FirebaseFirestore firestore;
    ProgressDialog dialog;
    String X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca);

        firestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);
        o = findViewById(R.id.o);
        p = findViewById(R.id.p);

        // setting setOnclick listener
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
    }

    private void geturl() {
        firestore.collection("bca").document("bca").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot documentSnapshot = task.getResult();
                    String x = documentSnapshot.getString(X);

                    Intent i = (new Intent(BCA.this, PDF_Viewer.class));
                    i.putExtra("X", x);
                    startActivity(i);
                    dialog.hide();

                } else {
                    Log.i("Tag3", "Task error " + task.getException().getMessage());
                    Toast.makeText(BCA.this, "Error", Toast.LENGTH_LONG);
                    dialog.hide();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a:
                X = "a";geturl();break;
            case R.id.b:
                X = "b";geturl();break;
            case R.id.c:
                X = "c";geturl();break;
            case R.id.d:
                X = "d";geturl();break;
            case R.id.e:
                X = "e";geturl();break;
            case R.id.f:
                X = "f";geturl();break;
            case R.id.g:
                X = "g";geturl();break;
            case R.id.h:
                X = "h";geturl();break;
            case R.id.i:
                X = "i";geturl();break;
            case R.id.j:
                X = "j";geturl();break;
            case R.id.k:
                X = "k";geturl();break;
            case R.id.l:
                X = "l";geturl();break;
            case R.id.m:
                X="m";geturl();break;
            case R.id.n:
                X = "n";geturl();break;
            case R.id.o:
                X = "o";geturl();break;
            case R.id.p:
                X = "p";geturl();break;
        }
    }
}
