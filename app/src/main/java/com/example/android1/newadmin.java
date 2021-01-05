package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;
import java.util.Arrays;
import java.util.List;

public class newadmin extends AppCompatActivity {
    TextView orderdetail;
    private DatabaseReference mDatabase;
    String db_data, full_data, new_data="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newadmin);
        orderdetail = (TextView) findViewById(R.id.orderdetail);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Student").child("");
        // Attach a listener to read the data at our posts reference
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                db_data = dataSnapshot.getValue().toString();//.replaceAll("[, ] ", "\n");;
                full_data = db_data;
                //orderdetail.setText(db_data);
                List<String> list = Arrays.asList(full_data.split(","));
                for (int i = 0; i < list.size(); i++) {
                    String list_entry = list.get(i);
                    if (list_entry.contains("ordered_by"))
                    {
                        new_data = new_data + list_entry;
                        new_data = new_data.replaceAll("-M", "\n-M");
                        new_data = new_data.replaceAll("\\{", "");
                    }
                }
                if(new_data == "")
                {
                    new_data = "No Order So far :(";
                }
                orderdetail.setText(new_data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


}
}
