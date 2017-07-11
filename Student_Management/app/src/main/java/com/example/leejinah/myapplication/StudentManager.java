package com.example.leejinah.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee JinAh on 2017-07-10.
 */

public class StudentManager {
    private List<Student> mStudentList;

    public StudentManager() {
        mStudentList = new ArrayList<>();
        initDataSet();
    }
    public void addStudent(Student student){
        mStudentList.add(student);
    }
    public void removeStudent(String id){
        Student deleteStudent = null;
        //반복도중 추가/삭제 하면 효능 떨어짐
        for(Student s : mStudentList){
            if(s.getId().equals(id)){
               deleteStudent = s;
                break;
            }
        }
        mStudentList.remove(deleteStudent);
    }
    public Student findStudent(String id){
        //반복도중 추가/삭제 하면 효능 떨어짐
        for(Student s : mStudentList){
            if(s.getId().equals(id)){
                return s;
            }
        }

        return null;
    }

    public String printAllStudent(){
        String result = "";
        for(Student s : mStudentList){
            result += s;
            result += "-----------------------\n";
        }
        return result;
    }

    private void initDataSet(){
        mStudentList.add(new Student("홍길동", "1"));
        mStudentList.add(new Student("이순신", "2"));
        mStudentList.add(new Student("강감찬", "3"));
    }

    public int getCount(){
        return mStudentList.size();
    }
}
