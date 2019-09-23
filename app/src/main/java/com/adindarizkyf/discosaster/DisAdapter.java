package com.adindarizkyf.discosaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Disaster> disasters;

    public DisAdapter(Context context) {
        this.context = context;
        disasters = new ArrayList<>();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDisaster(ArrayList<Disaster> disasters) {
        this.disasters = disasters;
    }

    public DisAdapter(Context context, ArrayList<Disaster> disasters) {
        this.context = context;
        this.disasters = disasters;
    }


    @Override
    public int getCount() {
        return disasters.size();
    }

    @Override
    public Object getItem(int i) {
        return disasters.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Disaster disaster = (Disaster) getItem(i);
        viewHolder.bind(disaster);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder (View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription= view.findViewById(R.id.txt_descript);
            imgPhoto = view.findViewById(R.id.img_photo);

        }

        void bind (Disaster disaster) {
            txtName.setText(disaster.getName());
            txtDescription.setText(disaster.getDescription());
            imgPhoto.setImageResource(disaster.getPhoto());
        }
    }
}
