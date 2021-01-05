package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {


    public static DatabaseReference ref;
    Button studentbutton,adminbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentbutton=(Button) findViewById(R.id.studentbutton);
        adminbutton=(Button) findViewById(R.id.adminbutton);

     studentbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent in=new Intent(MainActivity.this,studentlogin.class);
             startActivity(in);
         }
     });
        adminbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,adminlog.class);
                startActivity(in);
            }
        });
    }
}
