package com.example.userregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    EditText etName, etDOB, etEmail_id;
    Button saveBtn, viewBtn;
DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etDOB = findViewById(R.id.etDOB);
        etEmail_id = findViewById(R.id.etEmail_id);
        saveBtn = findViewById(R.id.add_btn);
        viewBtn = findViewById(R.id.view_btn);
        myDB = new DatabaseHelper(this);


        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);

            startActivity(intent);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dName =etName.getText().toString();
                String dDOB = etDOB.getText().toString();
                String demail_ID = etName.getText().toString();
                if(dName.length()!=0&&dDOB.length()!=0&&demail_ID.length()!=0){
                    AddData(dName,dDOB,demail_ID);
                    etName.setText("");
                    etDOB.setText("");
                    etEmail_id.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "Please fill your complete details", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public void AddData(String dName, String dDOB, String demail_Id){
       boolean insertData= myDB.addData(dName,dDOB,demail_Id);
       if(insertData==true){
           Toast.makeText(this, "Data Saved Successfully !", Toast.LENGTH_SHORT).show();
       }
       else{
           Toast.makeText(this, "Something went wrong...", Toast.LENGTH_SHORT).show();
       }
    }






}


