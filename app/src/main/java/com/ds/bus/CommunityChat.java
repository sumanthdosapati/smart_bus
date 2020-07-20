package com.ds.bus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CommunityChat extends AppCompatActivity {

    WebView chatweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_chat);

        chatweb=(WebView) findViewById(R.id.wview);
        chatweb.setWebViewClient(new WebViewClient());
        chatweb.loadUrl("https://tlk.io/nowtravelcomm");

        WebSettings webSettings=chatweb.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    @Override
    public void onBackPressed() {

        if(chatweb.canGoBack())
        {
            chatweb.goBack();
        }
        else {
            super.onBackPressed();
        }


    }
}