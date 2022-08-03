package com.example.userregistration;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {
    DatabaseHelper myDB;
    ArrayList<User> usersArrayList;
    ListView listView;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.view_content_layout);

        myDB = new DatabaseHelper(this);
        usersArrayList = new ArrayList<User>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();
        if(numRows==0){
            Toast.makeText(ViewListContents.this,"There is no Entry in Database",
                    Toast.LENGTH_LONG).show();
        }
        else{
            while(data.moveToNext()){
                user = new User(data.getString(1),data.getString(2),data.getString(3));
                usersArrayList.add(user);
            }
            ThreeColumn_listAdapter adapter = new ThreeColumn_listAdapter(this,R.layout.list_adapter_view,usersArrayList);
           listView = (ListView)findViewById(R.id.listView);
        }
    }

    //
//
//    }
}
