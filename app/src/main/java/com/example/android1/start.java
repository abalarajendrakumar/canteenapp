package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class start extends AppCompatActivity {

    Button mealbutton,friedricebutton,briyanibutton,lemonricebutton,vegnoodlesbutton,chapathibutton,dosabutton;

    String choices="";
    Double price=0.00;
    static int meal_count;
    static int friedrice_count;
    static int briyani_count;
    static int lemonrice_count;
    static int vegnoodles_count;
    static int chapathi_count;
    static int dosa_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mealbutton=(Button)findViewById(R.id.Mealsbutton);
        friedricebutton=(Button)findViewById(R.id.Friedricebutton);
        briyanibutton=(Button)findViewById(R.id.Briyanibutton);
        lemonricebutton=(Button)findViewById(R.id.Lemonricebutton);
        vegnoodlesbutton=(Button)findViewById(R.id.Vegnoodlesbutton);
        chapathibutton=(Button)findViewById(R.id.Chapathibutton);
        dosabutton=(Button)findViewById(R.id.Dosabutton);
    }

    public void add_to_list(View view)
    {
        if(view==findViewById(R.id.Mealsbutton))
        {
            choices=choices+"meals"+"\n";
            price=price+50;
            meal_count = meal_count + 1;
            Toast.makeText(start.this,"You have selected " + meal_count + "  meals",Toast.LENGTH_LONG).show();

        }
        else if(view==findViewById(R.id.Friedricebutton))
        {
            choices=choices+"Friedrice"+"\n";
            price=price+40;
            friedrice_count=friedrice_count +1;
            Toast.makeText(start.this,"You have selected "+ friedrice_count + "  friedrice",Toast.LENGTH_LONG).show();
        }

        else if(view==findViewById(R.id.Briyanibutton))
        {
            choices=choices+"Briyani"+"\n";
            price=price+60;
            briyani_count=briyani_count +1;
            Toast.makeText(start.this,"You have selected "+ briyani_count + "  briyani",Toast.LENGTH_LONG).show();
        }

        else if(view==findViewById(R.id.Lemonricebutton))
        {
            choices=choices+"Lemonrice"+"\n";
            price=price+30;
            lemonrice_count=lemonrice_count +1;
            Toast.makeText(start.this,"You have selected "+ lemonrice_count + "  lemonrice",Toast.LENGTH_LONG).show();
        }
        else if(view==findViewById(R.id.Vegnoodlesbutton))
        {
            choices=choices+"Vegnoodles"+"\n";
            price=price+30;
            vegnoodles_count=vegnoodles_count +1;
            Toast.makeText(start.this,"You have selected "+ vegnoodles_count + "  vegnoodles",Toast.LENGTH_LONG).show();
        }
        else if(view==findViewById(R.id.Chapathibutton))
        {
            choices=choices+"Chapathi"+"\n";
            price=price+30;
            chapathi_count=chapathi_count +1;
            Toast.makeText(start.this,"You have selected "+ chapathi_count + "  chapathi",Toast.LENGTH_LONG).show();
        }
        else if(view==findViewById(R.id.Dosabutton))
        {
            choices=choices+"Dosa"+"\n";
            price=price+30;
            dosa_count=dosa_count +1;
            Toast.makeText(start.this,"You have selected "+ dosa_count + "  dosa",Toast.LENGTH_LONG).show();
        }

    }

    public void placeorder(View view) {

        Intent i=new Intent(start.this,orderdetails.class);
        Bundle bundle= new Bundle();
        bundle.putString("choices",choices);
        bundle.putDouble("price",price);
        //bundle.putInt("meal_count",meal_count);
        String meals_chosen = "Meals: " + Integer.toString(meal_count) + "\n";
        String fried_rice_chosen = "Friedrice: " + Integer.toString(friedrice_count) +  "\n";
        String Briyani_chosen = "Briyani: " + Integer.toString(briyani_count) + "\n";
        String Lemonrice_chosen = "Lemonrice: " + Integer.toString(lemonrice_count) + "\n";
        String Vegnoodles_chosen = "Vegnoodles: " + Integer.toString(vegnoodles_count) + "\n";
        String Chapathi_chosen = "Chapathi: " + Integer.toString(chapathi_count) + "\n";
        String Dosa_chosen = "Dosa: " + Integer.toString(dosa_count) + "\n";
        bundle.putString("meals_chosen",meals_chosen);
        bundle.putString("fried_rice_chosen",fried_rice_chosen);
        bundle.putString("Briyani_chosen",Briyani_chosen);
        bundle.putString("Lemonrice_chosen",Lemonrice_chosen);
        bundle.putString("Vegnoodles_chosen",Vegnoodles_chosen);
        bundle.putString("Chapathi_chosen",Chapathi_chosen);
        bundle.putString("Dosa_chosen",Dosa_chosen);
        i.putExtras(bundle);
        startActivity(i);
    }
}
