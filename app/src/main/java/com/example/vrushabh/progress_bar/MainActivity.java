package com.example.vrushabh.progress_bar;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    private ProgressDialog progressAlex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button2);
    }
    public void download(View view){
        progressAlex=new ProgressDialog(this);

        // You can change  STYLE_HORIZONTAL Into STYLE_SPINNER
        progressAlex.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressAlex.setIndeterminate(true);
        progressAlex.setProgress(0);
        progressAlex.setMessage("Downloading PUBG MOBILE");
        progressAlex.show();
        final int totalProgressTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while(jumpTime < totalProgressTime) {
                    try {
                        sleep(250);
                        jumpTime += 6;
                        progressAlex.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}