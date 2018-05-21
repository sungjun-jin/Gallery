package com.example.jinsungjun.gallery;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {

    private ImageView imageView;

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

    }

    public void getImage(View view) {
        //Get Image 버튼 클릭 시 동작

        Intent intent = new Intent(this, GalleryActivity.class);
        startActivityForResult(intent, Const.REQ_GAL);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {

            switch (requestCode) {
                case Const.REQ_GAL:
                    String path = data.getStringExtra(Const.PATH_IMG);
                    Uri uri = Uri.parse(path);
                    imageView.setImageURI(uri);
                    break;
            }
        }
    }
}



