package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private WebView mwebView;
    private WebSettings mwebSettings;
    private Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mwebView = (WebView) findViewById(R.id.webview);        // 웹뷰 초기화
        btnRefresh = (Button) findViewById(R.id.btnRefresh);    // 새로고침 버튼 초기화
        mwebView.setWebViewClient(new WebViewClient());         // 웹뷰 설정
        mwebSettings = mwebView.getSettings();                  // 설정된 웹뷰 받기
    }

    @Override
    protected void onStart() {
        super.onStart();
        mwebSettings.setJavaScriptEnabled(true);
        mwebSettings.setSupportMultipleWindows(false);
        mwebSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        mwebSettings.setLoadWithOverviewMode(true);
        mwebSettings.setUseWideViewPort(true);
        mwebSettings.setSupportZoom(false);
        mwebSettings.setBuiltInZoomControls(false);
        mwebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mwebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        mwebSettings.setDomStorageEnabled(true);

        mwebView.loadUrl("http://goodmin.dothome.co.kr/index.html");    // 차트를 표시한 HTML 파일을 웹뷰로 불러오기
        btnRefresh.setOnClickListener(new View.OnClickListener() {      // 웹뷰 새로고침 버튼 클릭 시 새로고침 실행
            @Override
            public void onClick(View view) {
                mwebView.reload();
            }
        });
    }
}