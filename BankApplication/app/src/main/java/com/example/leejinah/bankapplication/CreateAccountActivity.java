package com.example.leejinah.bankapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPwEditText;
    private EditText mPw2EditText;
    private EditText mMoneyEditText;

    private Button mResetBtn;
    private Button mCreateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mIdEditText = (EditText)findViewById(R.id.id_field);
        mPwEditText = (EditText)findViewById(R.id.password_field);
        mPw2EditText = (EditText)findViewById(R.id.password2_field);
        mMoneyEditText = (EditText)findViewById(R.id.money_field);

        mResetBtn  = (Button)findViewById(R.id.reset_btn);
        mCreateBtn = (Button)findViewById(R.id.create_btn);

        mResetBtn.setOnClickListener(this);
        mCreateBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reset_btn:
                mIdEditText.setText("");
                mPwEditText.setText("");
                mPw2EditText.setText("");
                mMoneyEditText.setText("");
                break;
            case R.id.create_btn:
                //개설
                String id = mIdEditText.getText().toString();
                String pw = mPwEditText.getText().toString();
                String pw2 = mPw2EditText.getText().toString();
                String money = mMoneyEditText.getText().toString();

                if(TextUtils.isEmpty(id) ||TextUtils.isEmpty(pw)
                        || TextUtils.isEmpty(pw2) || TextUtils.isEmpty(money)){
                    Toast.makeText(this, "값을 입력 해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (!pw.equals(pw2)) {
                        Toast.makeText(this, "비밀번호가 같지 않습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Account account = new Account(id, pw, money);
                        Intent intent = new Intent();
                        intent.putExtra("account", account);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }

                break;

        }

    }
}
