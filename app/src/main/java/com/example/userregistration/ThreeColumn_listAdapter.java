package com.example.userregistration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_listAdapter extends ArrayAdapter {
    private LayoutInflater minflater;
    private ArrayList<User> users;
    private int mViewResourcesId;

    public ThreeColumn_listAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId,users);
        this.users=users;
        minflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourcesId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parents){
        convertView = minflater.inflate(mViewResourcesId,null);

        User user = users.get(position);

        if(user!=null){
            TextView uName = (TextView) convertView.findViewById(R.id.textName);
            TextView uDOB = (TextView) convertView.findViewById(R.id.textDOB);
            TextView uEmailId= (TextView) convertView.findViewById(R.id.textEmail_id);
            if(uName!=null){
                uName.setText(user.getuName());
            }
            if(uDOB!=null){
                uDOB.setText(user.getuDOB());
            }
            if(uEmailId!=null){
                uEmailId.setText(user.getuName());
            }
        }
        return convertView;
    }
}
