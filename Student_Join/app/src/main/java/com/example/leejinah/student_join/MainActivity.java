package com.example.leejinah.student_join;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText studnet_name;
    private TextView view_join;
    private Button mSingUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studnet_name = (EditText)findViewById(R.id.s_name);
        mSingUpButton = (Button)findViewById(R.id.button);
        view_join= (TextView)findViewById(R.id.view_join_student);

        mSingUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_join.setText(studnet_name.getText().toString() + "님의 회원가입이 되었습니다");
            }
        });
    }

}