package com.student.admin.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    Button b,b1;
    Spinner s;
    String p1,p2,p3,p4,p5,p6,p7,p8,p9;
    Moviehelper moviehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.mname);
        ed2 = (EditText) findViewById(R.id.mactor);
        ed3 = (EditText) findViewById(R.id.mactress);
        ed4 = (EditText) findViewById(R.id.ryear);
        ed5 = (EditText) findViewById(R.id.director);
        ed6 = (EditText) findViewById(R.id.producer);
        ed7 = (EditText) findViewById(R.id.cameraman);
        ed8 = (EditText) findViewById(R.id.tcollection);
        s=(Spinner)findViewById(R.id.mlanguage);
        moviehelper=new Moviehelper(this);
        moviehelper.getWritableDatabase();
        b = (Button) findViewById(R.id.register);
        b1 = (Button) findViewById(R.id.search);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1 = ed1.getText().toString();
                p2 = ed2.getText().toString();
                p3 = ed3.getText().toString();
                p4 = ed4.getText().toString();
                p5 = ed5.getText().toString();
                p6 = ed6.getText().toString();
                p7 = ed7.getText().toString();
                p8=ed8.getText().toString();
                p9=s.getSelectedItem().toString();
                Log.d("mname", p1);
                Log.d("mactor", p2);
                Log.d("mactress", p3);
                Log.d("ryear", p4);
                Log.d("director", p5);
                Log.d("producer", p6);
                Log.d("cameraman", p7);
                Log.d("tcollection", p8);
                Log.d("mlanguage", p9);

                boolean status = moviehelper.insertData(p1,p2,p3,p4,p5,p6,p7,p8,p9);
                if (status == true) {
                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(i);
            }
        });



    }
}
