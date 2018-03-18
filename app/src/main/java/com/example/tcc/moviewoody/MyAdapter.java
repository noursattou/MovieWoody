package com.example.tcc.moviewoody;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends ArrayAdapter<Cinema> {

    Activity activity;
    List<Cinema> list;

    public MyAdapter(Activity activity ,List<Cinema> list) {
        super(activity,R.layout.data_items ,list);
        this.activity = activity;
        this.list= list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.data_items, null , true);
        TextView cityName = (TextView) listViewItem.findViewById(R.id.textViewCity);
Cinema cinema = list.get(position);
       cityName.setText(cinema.getCityName());
        return listViewItem ;
    }
}
