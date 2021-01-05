package com.example.android1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adminlogin extends AppCompatActivity {


    EditText stdID,pin,courseName,level;
    private admin admin;
    FirebaseDatabase database;
    DatabaseReference ref;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        stdID=(EditText)findViewById(R.id.studentID);
        pin=(EditText)findViewById(R.id.pin);
        courseName=(EditText)findViewById(R.id.courseName);
        level=(EditText)findViewById(R.id.LevelProgram);
        register=(Button)findViewById(R.id.Register);
        admin=new admin();
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("Student");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                admin.setStudentID(stdID.getText().toString());
                admin.setCourse(courseName.getText().toString());
                admin.setPin(pin.getText().toString());
                admin.setLevel(level.getText().toString());


                ref.child(admin.getStudentID()).setValue(admin).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(adminlogin.this,"Student created successfully",Toast.LENGTH_LONG);
                        }
                        else{
                            Toast.makeText(adminlogin.this,"Failed to Registered",Toast.LENGTH_LONG);
                        }
                    }
                });


            }
        });

    }

}
