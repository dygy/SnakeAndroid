package com.example.dygy.myapplication;

import android.annotation.SuppressLint;
import android.renderscript.Script;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class Main extends AppCompatActivity {
    protected WebView game;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = (WebView) findViewById(R.id.game);
        game.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                android.util.Log.d("WebView", consoleMessage.message());
                return true;
            }
        });
        game.setInitialScale(5);
        game.getSettings().setUseWideViewPort(true);
        game.getSettings().setLoadWithOverviewMode(true);
        game.getSettings().setAllowContentAccess(true);
        game.getSettings().setDomStorageEnabled(true);
        game.getSettings().setAllowFileAccessFromFileURLs(true);
        game.getSettings().setAllowUniversalAccessFromFileURLs(true);
        game.loadUrl("file:///android_asset/game/index.html");
        game.getSettings().setJavaScriptEnabled(true);

        class Android{
            @JavascriptInterface
            public String myName (){
                return "Dygytal";
            }
        }

        game.addJavascriptInterface(new Android(),"Android");
    }
}
