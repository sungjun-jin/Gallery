package com.example.jinsungjun.gallery.adapter;


import android.content.Context;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.jinsungjun.gallery.Callback;


import com.example.jinsungjun.gallery.GalleryActivity;
import com.example.jinsungjun.gallery.R;
import com.example.jinsungjun.gallery.domain.Item;


import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.Holder> {

    List<Item> data;
    GalleryActivity activity;

    public GalleryAdapter(List<Item> data, GalleryActivity activity) {
        //생성자를 통해 데이터를 로드
        this.data = data;
        this.activity = activity;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        //해당 data를 가져와 Item클래스에 담아준다
        Item item = data.get(position);
        holder.setImage(item.ImagePath);
        //즉각즉각 클래스에 담아준다
        holder.item = item;

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        //private으로 선언하고 setter를 이용해 구현해 주는 것이 좋다
        private ImageView image;
        Item item;
        Context context;

        public Holder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            context = itemView.getContext();
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String path = item.ImagePath;
                    //Activity에서 setResult 함수를 호출해줘야 한다.
                    activity.returnValue(path);
                }
            });

        }

        public void setImage(String ImagePath) {
            Uri uri = Uri.parse(ImagePath);
            image.setImageURI(uri);
        }

    }




}
