package com.example.android1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;

public class orderdetails extends AppCompatActivity  {
    TextView listView, priceView;
    String list_choice, meals_chosen, fried_rice_chosen, Briyani_chosen, Lemonrice_chosen,Vegnoodles_chosen,Chapathi_chosen,Dosa_chosen;
    Button orderbutton;

    Double price_bd, price_usd;
    int choice_length;
    String choice = "";
    DatabaseReference reff;
    static String final_order;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetails);

        listView = (TextView) findViewById(R.id.listView);
        priceView = (TextView) findViewById(R.id.priceView);
        orderbutton=(Button) findViewById(R.id.Orderbutton);



        Bundle bundle = getIntent().getExtras();
        reff= FirebaseDatabase.getInstance().getReference();
        list_choice = bundle.getString("choices");
        price_bd = bundle.getDouble("price");
        //choice_length=bundle.getInt("meal_count");
        meals_chosen = bundle.getString("meals_chosen");
        fried_rice_chosen = bundle.getString("fried_rice_chosen");
        Briyani_chosen = bundle.getString("Briyani_chosen");
        Lemonrice_chosen = bundle.getString("Lemonrice_chosen");
        Vegnoodles_chosen = bundle.getString("Vegnoodles_chosen");
        Chapathi_chosen = bundle.getString("Chapathi_chosen");
        Dosa_chosen = bundle.getString("Dosa_chosen");
        //String choice = Integer.toString(choice_length);
        //listView.setText(choice);
        if (list_choice.contains("meals")) {
            choice = choice + meals_chosen;
        }
        if (list_choice.contains("Friedrice")) {
            choice = choice + fried_rice_chosen;
        }
        if (list_choice.contains("Briyani")) {
            choice = choice + Briyani_chosen;
        }
        if (list_choice.contains("Vegnoodles")) {
            choice = choice + Vegnoodles_chosen;
        }
        if (list_choice.contains("Lemonrice")) {
            choice = choice + Lemonrice_chosen;
        }
        if (list_choice.contains("Chapathi")) {
            choice = choice + Chapathi_chosen;
        }
        if (list_choice.contains("Dosa")) {
            choice = choice + Dosa_chosen;
        }
        listView.setText(choice);
        priceView.setText("TOTAL: "+price_bd.toString());

    }

    public void orderbutton(View view) {
        String order = choice + "ordered_by: " + Student.studentID;
        final_order = order.replaceAll("[\\n ]", " ");
        final_order = final_order + "\n";
        studentlogin.ref.push().setValue(final_order);
        Toast.makeText(orderdetails.this, "your order placed", Toast.LENGTH_LONG).show();
    }

}
