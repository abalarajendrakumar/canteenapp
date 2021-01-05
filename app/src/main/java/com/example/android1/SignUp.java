package com.example.android1;

import android.graphics.Color;
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

public class SignUp extends AppCompatActivity {

    EditText stdID,pin,courseName,name;
    private Student student;
    FirebaseDatabase database;
    DatabaseReference ref;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        stdID=(EditText)findViewById(R.id.studentID);
        pin=(EditText)findViewById(R.id.pin);
        courseName=(EditText)findViewById(R.id.courseName);
        name=(EditText)findViewById(R.id.LevelProgram);
        register=(Button)findViewById(R.id.Register);



        student=new Student();
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("Student");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                student.setStudentID(stdID.getText().toString());
                student.setCourse(courseName.getText().toString());
                student.setPin(pin.getText().toString());
                student.setLevel(name.getText().toString());


                ref.child(student.getStudentID()).setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this,"Student created successfully",Toast.LENGTH_LONG);
                        }
                        else{
                            Toast.makeText(SignUp.this,"Failed to Registered",Toast.LENGTH_LONG);
                        }
                    }
                });


            }
        });

    }
}
