package com.example.android_with_kotlin.views

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R

class WebViewActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)
        val webViewVariable = findViewById<WebView>(R.id.webView)
        webViewSetUp(webViewVariable);
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetUp(webViewVariable: WebView) {
            webViewVariable.webViewClient = WebViewClient();
             webViewVariable.apply {
                 settings.javaScriptEnabled = true
                 settings.safeBrowsingEnabled = true
                 loadUrl("https://sandeep-mehra-imm4k0c.gamma.site/")
             }
    }
}