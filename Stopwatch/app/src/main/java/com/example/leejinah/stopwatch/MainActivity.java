package com.example.leejinah.stopwatch;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Chronometer mChronometer;
    private long stop_time;
    private long start_time;
    private boolean start_state = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChronometer = (Chronometer)findViewById(R.id.chronometer);

        Button startBtn = (Button)findViewById(R.id.start_button);
        Button stopBtn = (Button)findViewById(R.id.stop_button);
        Button resetBtn = (Button)findViewById(R.id.reset_button);


        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_button:
                start_time = SystemClock.elapsedRealtime();
                if(start_state==false){
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                    mChronometer.start();
                }
                else{
                    mChronometer.setBase(mChronometer.getBase()-(stop_time-start_time));
                    mChronometer.start();
                }
                break;
            case R.id.stop_button:
                stop_time = SystemClock.elapsedRealtime();
                mChronometer.stop();
                start_state = true;
                break;
            case R.id.reset_button:
                //mChronometer.stop();
                start_state = false;
                mChronometer.setBase(SystemClock.elapsedRealtime());
                break;
        }

    }
}
