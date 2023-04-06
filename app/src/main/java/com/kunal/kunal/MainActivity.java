package com.kunal.kunal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(ImageButton) findViewById(R.id.ghrce_college);
//        button2 =(ImageButton) findViewById(R.id.rtmnu);
//        button3=(ImageButton) findViewById(R.id.dbatu);
//        button4=(ImageButton) findViewById(R.id.bca);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EbookActivity.class));
            }
        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}