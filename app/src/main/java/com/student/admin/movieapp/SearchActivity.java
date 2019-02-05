package com.student.admin.movieapp;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9;
    Button b,b1,b2;
    String getmname,getactor,getactress,getryear,getdirector,getproducer,getcameraman,gettcollection,getmlanguage,getid,getnactor,getnactress,getnryear,getndirect,getnproduce,getncam,getntc,getmlang;
    Moviehelper moviehelper;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        builder=new AlertDialog.Builder(this);
        builder.setTitle("conform");
        builder.setMessage("are you sure you want to delete");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean status=moviehelper.DeleteData(getid);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"not deleted",Toast.LENGTH_LONG).show();
                }
           Toast.makeText(getApplicationContext(),"yes clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"no clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });


        ed1 = (EditText) findViewById(R.id.mname);
        ed2 = (EditText) findViewById(R.id.mactor);
        ed3 = (EditText) findViewById(R.id.mactress);
        ed4 = (EditText) findViewById(R.id.ryear);
        ed5 = (EditText) findViewById(R.id.director);
        ed6 = (EditText) findViewById(R.id.producer);
        ed7 = (EditText) findViewById(R.id.cameraman);
        ed8 = (EditText) findViewById(R.id.tcollection);
        ed9 = (EditText) findViewById(R.id.mlanguage);
        b1=(Button)findViewById(R.id.update);
        b2=(Button)findViewById(R.id.delete);
        moviehelper=new Moviehelper(this);
        moviehelper.getWritableDatabase();
        b = (Button) findViewById(R.id.search);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getmname = ed1.getText().toString();
                getactor= ed2.getText().toString();
                getactress= ed3.getText().toString();
                getryear= ed4.getText().toString();
                getdirector= ed5.getText().toString();
                getproducer= ed6.getText().toString();
                getcameraman= ed7.getText().toString();
                gettcollection=ed8.getText().toString();
                getmlanguage=ed9.getText().toString();
                Log.d("mname",getmname);
                Cursor cursor=moviehelper.SearchData(getmname);
                if (cursor.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"No Name Found",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cursor.moveToNext())
                    {
                        getactor=cursor.getString(2);
                        getactress=cursor.getString(3);
                        getryear=cursor.getString(4);
                        getdirector=cursor.getString(5);
                        getproducer=cursor.getString(6);
                        getcameraman=cursor.getString(7);
                        gettcollection=cursor.getString(8);
                        getmlanguage=cursor.getString(9);
                        Toast.makeText(getApplicationContext(),getactor,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),getactress,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),getryear,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),getdirector,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),getproducer,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),getcameraman,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),gettcollection,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),getmlanguage,Toast.LENGTH_LONG).show();
                        ed2.setText(getactor);
                        ed3.setText(getactress);
                        ed4.setText(getryear);
                        ed5.setText(getdirector);
                        ed6.setText(getproducer);
                        ed7.setText(getcameraman);
                        ed8.setText(gettcollection);
                        ed9.setText(getmlanguage);
                        getid=cursor.getString(0);
                        Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getnactor = ed2.getText().toString();
                getnactress = ed3.getText().toString();
                getryear = ed4.getText().toString();
                getndirect = ed5.getText().toString();
                getnproduce = ed6.getText().toString();
                getncam = ed7.getText().toString();
                getntc = ed8.getText().toString();
                getmlang = ed9.getText().toString();
                boolean status = moviehelper.UpdateData(getid, getnactor, getnactress, getryear, getndirect, getnproduce, getncam, getntc, getmlang);
                if (status == true) {

                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });
    }
}
