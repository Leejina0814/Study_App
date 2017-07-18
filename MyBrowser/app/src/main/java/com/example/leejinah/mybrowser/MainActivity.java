package com.example.leejinah.mybrowser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {

    private WebView myWebView;
    private Button move_btn;
    private EditText mAddressEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView)findViewById(R.id.web_view);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

        mAddressEdit = (EditText)findViewById(R.id.address_edit);
        move_btn = (Button)findViewById(R.id.move_button);

        move_btn.setOnClickListener(this);

        mAddressEdit.setOnEditorActionListener(this);

    }

    @Override
    public void onClick(View v) {
       // Toast.makeText(this,"잘됩니당",Toast.LENGTH_SHORT).show();
        String address = mAddressEdit.getText().toString();
        if(address.startsWith("http://") == false){
            address = "http://"+address;
        }
        myWebView.loadUrl(address);
    }
    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    /*enter키 누르면 해당 url로 넘어가도록
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if((event != null) && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)){
            String address = mAddressEdit.getText().toString();
            if(address.startsWith("http://") == false){
                address = "http://"+address;
            }
            myWebView.loadUrl(address);
        }
        return true;
    }
    */
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_SEARCH){
            move_btn.callOnClick();
            return true;
        }
        return false;
    }
}
