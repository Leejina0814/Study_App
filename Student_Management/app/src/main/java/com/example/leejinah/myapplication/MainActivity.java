package com.example.leejinah.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private StudentManager mStudentManager;
    private TextView mTotalCount;
    private TextView mMessageText;
    private EditText mNameField;
    private EditText mIdField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //화면에 activity_main을 붙인다.
        setContentView(R.layout.activity_main);
        mStudentManager = new StudentManager();

        mTotalCount = (TextView)findViewById(R.id.total_student_count);
        mMessageText = (TextView)findViewById(R.id.message_text);
        mNameField = (EditText)findViewById(R.id.name_field);
        mIdField = (EditText)findViewById(R.id.id_field);
    }

    //전체출력과 연결
    public void printAllStudent(View view) {
        mTotalCount.setText(""+mStudentManager.getCount());
        mMessageText.setText(mStudentManager.printAllStudent());
    }

    public void addStudent(View view) {
        Student student = new Student(mNameField.getText().toString(), mIdField.getText().toString());
        mStudentManager.addStudent(student);
        mTotalCount.setText(""+mStudentManager.getCount());
        mMessageText.setText("이름 : " + mNameField.getText().toString() +" 학번 : "+mIdField.getText().toString()+"가 추가되었습니다.");
    }

    public void searhStudent(View view) {
        Student student = mStudentManager.findStudent(mIdField.getText().toString());
        if(student == null){
            mMessageText.setText("찾을 수 없습니다.");
        }
        else {
            mMessageText.setText("학번이 " + mIdField.getText().toString() + "인 학생의 이름은 " + student.getName() + "입니다.");
        }
    }

    public void deleteStudent(View view) {
        mStudentManager.removeStudent(mIdField.getText().toString());
        mTotalCount.setText(""+mStudentManager.getCount());
        mMessageText.setText("학번이 "+ mIdField.getText().toString() +"인 학생을 삭제하였습니다.");
    }
}
