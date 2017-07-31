package com.example.leejinah.bankapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class SearchAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPwEditText;
    private Button mLoginBtn;
    private Button mFinishBtn;
    private TextView mResultTextView;

    private HashMap<String, Account> mAccountHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_account);

        mIdEditText = (EditText)findViewById(R.id.id_field);
        mPwEditText = (EditText)findViewById(R.id.pw_field);

        mLoginBtn = (Button)findViewById(R.id.login_button);
        mFinishBtn = (Button)findViewById(R.id.finish_button);

        mResultTextView = (TextView)findViewById(R.id.result_text);

        mLoginBtn.setOnClickListener(this);
        mFinishBtn.setOnClickListener(this);

        Intent intent = getIntent();
        if(intent != null){
            mAccountHashMap = (HashMap<String, Account>) intent.getSerializableExtra("data");

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:
                String id = mIdEditText.getText().toString();
                String pw = mPwEditText.getText().toString();

                if(TextUtils.isEmpty(id) || TextUtils.isEmpty(pw)){
                    Toast.makeText(this, "아이디 또는 비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(mAccountHashMap.containsKey(id)){
                        Account account = mAccountHashMap.get(id);
                        if(account.getPw().equals(pw)){
                            mResultTextView.setText(account.getId() + "님의 계좌 정보"+"\n"+"금액 : " + account.getBalance());
                        }else{
                            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(this, "해당 계좌번호가 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.finish_button:
                finish();
                break;
        }

    }
}
