package com.prabhat.collegefriend;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.firestore.FirebaseFirestore;

public class PDF_Viewer extends AppCompatActivity {

    FirebaseFirestore firestore;
    PDFView pdfView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfviewer);

        MobileAds.initialize(this,
                "ca-app-pub-7727898151437452~1085840402");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        final WebView webView;
        webView = (WebView) findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        String url = getIntent().getStringExtra("X");
        String finalURL = "https://drive.google.com/viewerng/viewer?embedded=true&url=" + url;

        webView.loadUrl(finalURL);


    }
}