package com.prabhat.collegefriend;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.prabhat.collegefriend.Adapter.Book_Class_Adapter;
import com.prabhat.collegefriend.Model.Book_Class_Model;

import java.util.ArrayList;

public class Books extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    AdView mAdView;
    Book_Class_Adapter adapter;
    ArrayList<Book_Class_Model> list;
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_page);
        recyclerView = findViewById(R.id.recyclerview);
        firestore = FirebaseFirestore.getInstance();

        //Google Ads setting
        MobileAds.initialize(this,
                "ca-app-pub-7727898151437452~1085840402");

        mAdView = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();

        // Recycler view setting
        list = new ArrayList<>();
        mAdView.loadAd(adRequest);
        adapter = new Book_Class_Adapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        refreshLayout = findViewById(R.id.refresh);
//
//        Query query = firestore.collection("book");
//
//        FirestoreRecyclerOptions<Relycler> options = new FirestoreRecyclerOptions.Builder<Relycler>()
//                .setQuery(query, Relycler.class).build();
//
//        firestoreRecyclerAdapter = new FirestoreRecyclerAdapter<Relycler, ProductViewHolder>(options) {
//            @NonNull
//            @Override
//            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
//                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem, parent, false);
//                return new ProductViewHolder(view);
//            }
//
//
//            @Override
//            protected void onBindViewHolder(@NonNull final ProductViewHolder holder, int position, @NonNull final Relycler model) {
//                holder.book.setText(model.getBookname());
//                holder.itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        final InterstitialAd interstitialAd = new InterstitialAd(getApplicationContext());
//                        interstitialAd.setAdUnitId("ca-app-pub-7727898151437452/8643128117");
//                        AdRequest adRequest = new AdRequest.Builder().build();
//                        interstitialAd.loadAd(adRequest);
//                        interstitialAd.setAdListener(new AdListener() {
//                            @Override
//                            public void onAdLoaded() {
//                                interstitialAd.show();
//                            }
//                        });
//
//                        Toast.makeText(books.this, "Download Started", Toast.LENGTH_SHORT).show();
//                        model.getBooklink();
//                        Log.i("link", model.booklink + "");
//                        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//                        Uri uri = Uri.parse(model.getBooklink());
//                        DownloadManager.Request request = new DownloadManager.Request(uri);
//                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                        Long reference = downloadManager.enqueue(request);
//                    }
//                });
//
//            }
//
//        };
        Books();
//
//        refresh();
    }
//
//    public void refresh() {
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(firestoreRecyclerAdapter);
//    }
    private class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView book;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            book = itemView.findViewById(R.id.book);
        }
    }
    public void Books() {
        firestore.collection("book").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                }
                for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()) {
                    Book_Class_Model model = documentChange.getDocument().toObject(Book_Class_Model.class);
                    Log.i("book", model.getBookname());
                    list.add(model);
                    recyclerView.setAdapter(adapter);
//                    list.add(model);
//
//                    recyclerView.setAdapter(adapter);
//                    lastSender=model.getSender();
//                    if(model.getId().equals(id)){
//
//                        list.add(model);
//
//                    }
                    //        adapter.notifyDataSetChanged();
                }
            }
        });
    }
    public void refresh(){
        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                        Toast.makeText(Books.this, "Refreshed", Toast.LENGTH_SHORT).show();
//                        refresh();
                    }
                }, 4000);
            }
        });
    }
}