package com.example.details;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,email,phone;
    RadioButton male,female,others;
    DatePicker dob;
    Spinner college;
    Button submit;
    String strname,stremail,strphone,strgender,strdate,strcollege;
    String names[]={"VNIT","JIT","ACET"};

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= findViewById(R.id.name);
        email= findViewById(R.id.email);
        phone= findViewById(R.id.phone);
        male= findViewById(R.id.male);
        female= findViewById(R.id.female);
        others= findViewById(R.id.others);
        dob= findViewById(R.id.dob);
        college = findViewById(R.id.college);
        submit = findViewById(R.id.submit);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);

        college.setAdapter(adapter);

        dob.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                strdate =dayOfMonth+"/"+monthOfYear+"/"+year;
            }
        });

        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                strname=name.getText().toString();
                stremail=email.getText().toString();
                strphone=phone.getText().toString();
                if(male.isChecked()) {
                    strgender = "Male";
                }else if (female.isChecked()) {
                    strgender = "Female";
                }else if (others.isChecked()) {
                    strgender = "Others";
                }

                strcollege=college.getSelectedItem().toString();
                String data= "Name:"+strname+"\n Email:"+stremail+"\n Phone: "+strphone+"\n College: "+strcollege+"\n Gender: "+strgender+"\n DOB: "+strdate;
                Toast.makeText(MainActivity.this,data, Toast.LENGTH_SHORT).show();

                System.out.println(data);

                Intent intent =new Intent(MainActivity.this,Second.class);

                intent.putExtra("data",data);
                startActivity(intent);

            }
        });


    }
}
