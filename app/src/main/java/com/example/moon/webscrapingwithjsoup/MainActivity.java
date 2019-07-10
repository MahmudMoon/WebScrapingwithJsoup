package com.example.moon.webscrapingwithjsoup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_loadedDATA);
        (findViewById(R.id.btn_load)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadUrlData(){
                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        textView.setText(s);
                    }
                }.execute("https://www.ssaurel.com/blog");
            }
        });

    }
}
