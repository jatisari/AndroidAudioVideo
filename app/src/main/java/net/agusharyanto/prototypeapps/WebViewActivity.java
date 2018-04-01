package net.agusharyanto.prototypeapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getSupportActionBar().hide();
        WebView myWebView = (WebView) findViewById(R.id.webView);

        myWebView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String surl="http://www.detik.com";
       /* Intent intent = getIntent();
        if (intent.hasExtra("url")) {
            surl= intent.getExtras().getString("url");

        }*/

        myWebView.loadUrl(surl);
    }

}
