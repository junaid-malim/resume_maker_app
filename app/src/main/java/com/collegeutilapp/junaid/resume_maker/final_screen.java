package com.collegeutilapp.junaid.resume_maker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class final_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);
        Button startprocess;
        startprocess=findViewById(R.id.startprocess);

        startprocess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Genrate_pdf_mtds(getApplicationContext());
            }
        });

    }
}
