package com.example.android1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminlog extends AppCompatActivity {

    EditText studentID,pin;
    private DatabaseReference ref;
    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlog);

        studentID = (EditText) findViewById(R.id.studentID);
        pin = (EditText) findViewById(R.id.pin);
        register = (Button) findViewById(R.id.Register);
        login = (Button) findViewById(R.id.Login);

        ref= FirebaseDatabase.getInstance().getReference().child("Student");



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signUp = new Intent(adminlog.this, adminlogin.class);
                startActivity(signUp);
            }
        });
    }

    public void btnLogin_Click(View view) {

        String stdID=studentID.getText().toString();
        final String PIN;
        PIN = pin.getText().toString();
        ref.child(stdID);
        ref.child(stdID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                admin admin = dataSnapshot.getValue(admin.class);
                if (PIN.equals(admin.getPin())) {
                    Toast.makeText(adminlog.this, "Login Successfull", Toast.LENGTH_LONG).show();
                    Intent start = new Intent(adminlog.this, newadmin.class);
                    startActivity(start);

                } else {
                    Toast.makeText(adminlog.this, "Incorrect pin entered..!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
