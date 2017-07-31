package com.example.leejinah.bankapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private HashMap<String, Account> mAccountMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccountMap = new HashMap<>();

        Button createAccountBtn = (Button)findViewById(R.id.create_account_button);
        Button searchAccountBtn = (Button)findViewById(R.id.search_account_button);
        Button adminBtn = (Button)findViewById(R.id.admin_button);
        Button finishBtn = (Button)findViewById(R.id.finish_button);


        createAccountBtn.setOnClickListener(this);
        searchAccountBtn.setOnClickListener(this);
        adminBtn.setOnClickListener(this);
        finishBtn.setOnClickListener(this);


}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.create_account_button:
                Intent intent = new Intent(this,CreateAccountActivity.class);
                startActivityForResult(intent, 1000);
                break;
            case R.id.search_account_button:
                Intent intent1 = new Intent(this, SearchAccountActivity.class);
                intent1.putExtra("data",mAccountMap);//data 실어서 보냄
                startActivity(intent1);
                break;
            case R.id.admin_button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("관리자 모드");
                final View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_admin, null, false);

                builder.setView(dialogView);
                builder.setPositiveButton("로그인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String id = ((EditText)dialogView.findViewById(R.id.id_field)).getText().toString();
                        String pw = ((EditText)dialogView.findViewById(R.id.pw_field)).getText().toString();

                        if("admin".equals(id) && "admin".equals(pw)){
                            //관리자 화면으로 이동
                            Intent adminIntent = new Intent(MainActivity.this, AdminActivity.class);
                            adminIntent.putExtra("data", mAccountMap);
                            startActivity(adminIntent);

                        }else{
                            Toast.makeText(MainActivity.this, "관리자 계정을 바르게 입력하세요", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
                builder.setNegativeButton("닫기", null);
                builder.show();
                break;
            case R.id.finish_button:
                finish();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000){
            if(resultCode == RESULT_OK){
                if(data != null){
                    Account account = (Account)data.getSerializableExtra("account");
                    mAccountMap.put(account.getId(),account);
                    Toast.makeText(this, account.getId() + "의계좌가 생성되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
