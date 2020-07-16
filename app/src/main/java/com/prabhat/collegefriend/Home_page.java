package com.prabhat.collegefriend;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.prabhat.collegefriend.Adapter.Home_Class_Adapter;
import com.prabhat.collegefriend.Login_Details.Login_Page;
import com.prabhat.collegefriend.Model.Book_Class_Model;

import java.util.ArrayList;
import java.util.List;

public class Home_page extends AppCompatActivity implements View.OnClickListener {

    Button logout;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth auth;
    FirebaseFirestore firebaseFirestore;
    ImageSlider imageList;
    Home_Class_Adapter adapter;
    RecyclerView recyclerView;
    ArrayList<Book_Class_Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        imageList = findViewById(R.id.image_slider);
        firebaseFirestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        CardView cardView = findViewById(R.id.cardView);
        CardView cardView2 = findViewById(R.id.cardView2);
        CardView cardView3 = findViewById(R.id.cardView3);
        CardView cardView4 = findViewById(R.id.cardView4);
        CardView cardView5 = findViewById(R.id.cardView5);
        LinearLayout ece = findViewById(R.id.ece);
        LinearLayout cse = findViewById(R.id.cse);
        LinearLayout class12 = findViewById(R.id.class12);
        LinearLayout cbse = findViewById(R.id.cbse);
        LinearLayout bca = findViewById(R.id.bca);
        LinearLayout book = findViewById(R.id.book);
        LinearLayout share = findViewById(R.id.share);
        LinearLayout logout = findViewById(R.id.logout);

        //setting click listener
        cardView.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);
        ece.setOnClickListener(this);
        cse.setOnClickListener(this);
        class12.setOnClickListener(this);
        cbse.setOnClickListener(this);
        bca.setOnClickListener(this);
        book.setOnClickListener(this);
        share.setOnClickListener(this);
        logout.setOnClickListener(this);

        //recyler view for books
        recyclerView = findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        adapter = new Home_Class_Adapter(this, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        Books();
        Photo_slider();

        //Google Sign in
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.signout) {
            auth.getInstance().signOut();
            googleSignInClient.signOut();
            startActivity(new Intent(Home_page.this, Login_Page.class));
            Toast.makeText(Home_page.this, "Signed Out", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (item.getItemId() == R.id.share) {
            share();
        }
        return super.onOptionsItemSelected(item);
    }

    public void Books() {
        firebaseFirestore.collection("book").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                }
                for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()) {
                    Book_Class_Model model = documentChange.getDocument().toObject(Book_Class_Model.class);
                    list.add(model);
                    recyclerView.setAdapter(adapter);
//                    list.add(model);
//                    recyclerView.setAdapter(adapter);
//                    lastSender=model.getSender();
//                    if(model.getId().equals(id)){
//                        list.add(model);
//                    }
                    //        adapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void Photo_slider() {
        firebaseFirestore.collection("imageslider").document("jcz4Jib0EsKhp96z8Ph9").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot documentSnapshot = task.getResult();

                List<SlideModel> slideModels = new ArrayList<SlideModel>();
                if (documentSnapshot.getString("image1") != null) {
                    slideModels.add(new SlideModel(documentSnapshot.getString("image1"), true));
                }
                if (documentSnapshot.getString("image2") != null) {
                    slideModels.add(new SlideModel(documentSnapshot.getString("image2"), true));

                }
                if (documentSnapshot.getString("image3") != null) {
                    slideModels.add(new SlideModel(documentSnapshot.getString("image3"), true));
                }
                if (documentSnapshot.getString("image4") != null) {
                    slideModels.add(new SlideModel(documentSnapshot.getString("image4"), true));
                }
                if (documentSnapshot.getString("image5") != null) {
                    slideModels.add(new SlideModel(documentSnapshot.getString("image5"), true));
                }
                if (documentSnapshot.getString("image6") != null) {
                    slideModels.add(new SlideModel(documentSnapshot.getString("image6"), true));
                }
                if (documentSnapshot.getString("image7") != null) {
                    slideModels.add(new SlideModel(documentSnapshot.getString("image7"), true));
                }
                if (documentSnapshot.getString("image8") != null) {
                    slideModels.add(new SlideModel(documentSnapshot.getString("image8"), true));
                }
                imageList.setImageList(slideModels, true);

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cardView:
                startActivity(new Intent(Home_page.this, BtechCSE.class));
                break;
            case R.id.cardView2:
                startActivity(new Intent(Home_page.this, CBSE.class));
                break;
            case R.id.cardView3:
                startActivity(new Intent(Home_page.this, Books.class));
                break;
            case R.id.cardView4:
                startActivity(new Intent(Home_page.this, BCA.class));
                break;
            case R.id.cardView5:
                startActivity(new Intent(Home_page.this, BtechECE.class));
                break;

            case R.id.ece:
                startActivity(new Intent(Home_page.this, BtechECE.class));
                break;
            case R.id.cse:
                startActivity(new Intent(Home_page.this, BtechCSE.class));
                break;
            case R.id.class12:
                startActivity(new Intent(Home_page.this, Twelve.class));
                break;
            case R.id.cbse:
                startActivity(new Intent(Home_page.this, CBSE.class));
                break;
            case R.id.bca:
                startActivity(new Intent(Home_page.this, BCA.class));
                break;
            case R.id.book:
                startActivity(new Intent(Home_page.this, Books.class));
                break;
            case R.id.share:
                share();
                break;
            case R.id.logout:
                auth.signOut();
                googleSignInClient.signOut();
                startActivity(new Intent(Home_page.this, Login_Page.class));
                Toast.makeText(Home_page.this, "Signed Out", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
    public void share() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/detail?id=com.prabhat.collegefriend");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Share Using"));
    }
}
