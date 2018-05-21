package com.example.jinsungjun.gallery;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jinsungjun.gallery.adapter.GalleryAdapter;
import com.example.jinsungjun.gallery.domain.Item;
import com.example.jinsungjun.gallery.domain.Loader;

import java.util.List;

public class GalleryActivity extends AppCompatActivity implements Callback{

    RecyclerView recyclerView;
    GalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        recyclerView = findViewById(R.id.recyclerView);

        List<Item> data = Loader.getGalleryItem(this);
        adapter = new GalleryAdapter(data,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

    }


    @Override
    public void returnValue(String path) {

        Intent intent = new Intent();
        intent.putExtra(Const.PATH_IMG,path);
        setResult(RESULT_OK,intent);
        finish();
    }
}
