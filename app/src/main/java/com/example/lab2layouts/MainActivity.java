package com.example.lab2layouts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //views
    EditText e1,e2;
    Button btn;
    Spinner s;
    //data for spinner array
    String[] dept_array = {"SE","CS","IT","CIVIL","ELEC","BIO"};
    String name, reg, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= (EditText) findViewById(R.id.editText);
        e2= (EditText) findViewById(R.id.editText2);
        btn= (Button) findViewById(R.id.button);
        s= (Spinner) findViewById(R.id.spinner);
        //create Adapter
        ArrayAdapter<String> adapter= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item,dept_array);
        s.setAdapter(adapter);
        //create listener
        btn.setOnClickListener(view -> {
            //get the values
            name= e1.getText().toString();
            reg= e2.getText().toString();
            dept= s.getSelectedItem().toString();
            // intent link to Second Activity
            Intent i= new Intent(MainActivity.this,SecondActivity.class);
            //pass values to SecondActivity
            i.putExtra("name_key", name);
            i.putExtra("reg_key", reg);
            i.putExtra("dept_key",dept);
            Toast.makeText(this,"SuccessFully Submitted...",Toast.LENGTH_SHORT).show();
            startActivity(i);
        });
    }
}