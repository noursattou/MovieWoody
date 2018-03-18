package com.example.tcc.moviewoody;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TCC on 3/16/2018.
 */

public class myAdapter2 extends ArrayAdapter<String> {

    Activity activity;
    List<String> list;

    public myAdapter2(Activity activity ,List<String> list) {
        super(activity,R.layout.data_items2 ,list);
        this.activity = activity;
        this.list= list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();

        View listViewItem2 = inflater.inflate(R.layout.data_items2, null , true);
        TextView textViewcinemas = (TextView) listViewItem2.findViewById(R.id.textViewcinemas);
        Cinema cinema = new Cinema();
       // Cinema cinema=list.get(position);
        String str = list.get(position);
        textViewcinemas.setText(str);
        return listViewItem2 ;
    }
}