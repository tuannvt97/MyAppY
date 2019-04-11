package com.example.myappy;

import android.app.Activity;
import android.media.Image;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Custom_listview extends ArrayAdapter<Thietbi>{

    Activity context;
    int layoutID;
    ArrayList<Thietbi> arrayContact;

    public Custom_listview(Activity context, int resource, ArrayList<Thietbi> arrayContact) {
        super(context, resource, arrayContact);
        this.context = context;
        layoutID = resource;
        this.arrayContact = arrayContact;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);
        if(arrayContact.size() >0 && position >=0){
//            final ImageView image = convertView.findViewById(R.id.image_device);
            final TextView twdisplayMatb = (TextView) convertView.findViewById(R.id.twTenthietbi);
            final TextView twdpNametb = (TextView) convertView.findViewById(R.id.twMathietbi);
//            final ImageButton imageButton = convertView.findViewById(R.id.imgbtnDelete);

            final Thietbi thietbi = arrayContact.get(position);
            twdisplayMatb.setText(thietbi.getName());
            twdpNametb.setText(thietbi.getMa());
//            image.setImageResource(thietbi.getHinh());

        }
        return convertView;
    }
}
