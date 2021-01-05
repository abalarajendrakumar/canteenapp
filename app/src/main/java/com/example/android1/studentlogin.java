package com.example.android1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class studentlogin extends AppCompatActivity {

    EditText studentID,pin;
    TextView textv;

    public static DatabaseReference ref;
    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);

        studentID = (EditText) findViewById(R.id.studentID);
        pin = (EditText) findViewById(R.id.pin);
        register = (Button) findViewById(R.id.Register);
        login = (Button) findViewById(R.id.Login);


        ref= FirebaseDatabase.getInstance().getReference().child("Student");



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signUp = new Intent(studentlogin.this, SignUp.class);
                startActivity(signUp);
            }
        });
    }

    public void btnLogin_Click(View view) {

        String stdID=studentID.getText().toString();
        final String PIN=pin.getText().toString();
        if(ref.child(stdID)!=null) {
            ref.child(stdID).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Student student = dataSnapshot.getValue(Student.class);
                    if (PIN.equals(student.getPin())) {
                        Toast.makeText(studentlogin.this, "Login Successfull", Toast.LENGTH_LONG).show();
                        Intent start = new Intent(studentlogin.this, start.class);
                        startActivity(start);

                    } else {
                        Toast.makeText(studentlogin.this, "Incorrect pin entered..!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else{
            Toast.makeText(studentlogin.this, "Student doesn't Exist", Toast.LENGTH_LONG).show();
        }

    }
}
