package com.example.leejinah.bankapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ArrayList<Account> accountList = new ArrayList<>();
        Intent intent = getIntent();
        if(intent!= null){

            HashMap<String, Account> map = (HashMap<String, Account>) intent.getSerializableExtra("data");
            accountList = new ArrayList<>(map.values());
        }

        ListView listView = (ListView)findViewById(R.id.list_view);
        AccountAdapter adapter = new AccountAdapter(accountList);
        listView.setAdapter(adapter);
    }

    class AccountAdapter extends BaseAdapter{

        private List<Account> mData;

        public AccountAdapter(List<Account> data){
            mData = data;
        }
        @Override
        public int getCount() {
            //mData안에 들어있는 data 갯수
            return mData.size();
        }

        @Override
        public Object getItem(int i) {
            //어느 위치에 data 뿌려주는지
            return mData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        //뿌려줄 data 표시하는 부분
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_2, viewGroup, false);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                Account account = mData.get(i);//i번째 계좌 가져옴

                text1.setText(account.getId());
                text2.setText(account.getPw());
                return view;
            }
            return view;
        }
    }
}
