package com.example.edgar.appevento;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by edgar on 01/10/16.
 */

public class ItemVideoAdapter extends ArrayAdapter<ItemVideo> {


    public ItemVideoAdapter(Context context, List<ItemVideo> lista) {
        super(context, 0, lista);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if(itemView==null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_video, parent, false);

        }
        ItemVideo itemVideo = getItem(position);

        TextView titulo = (TextView) itemView.findViewById(R.id.titulo);
        titulo.setText(itemVideo.getTitulo());

        TextView data = (TextView) itemView.findViewById(R.id.data);
        data.setText(itemVideo.getData());


        return itemView;
    }
}

