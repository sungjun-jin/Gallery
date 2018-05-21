package com.example.jinsungjun.gallery.domain;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    // 폰에 있는 이미지 목록을 리턴
    public static List<Item> getGalleryItem(Context context) {

        List<Item> result = new ArrayList<>();

        //ContentResolver를 가져오려면 context가 필요
        ContentResolver resolver = context.getContentResolver();


        //썸네일 가져오기
        Uri uri_thumb = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        //데이터 컬럼 세팅
        String projections_thumb[] = {
                MediaStore.Images.Media.DATA
        };
        //쿼리를 통해 데이터 가져오기
        Cursor cursor = resolver.query(uri_thumb,projections_thumb,null,null,null);

        if(cursor != null) {

            while(cursor.moveToNext()) {

                Item item = new Item();
                item.ImagePath = cursor.getString(0);
                result.add(item);
            }
            cursor.close();
        }
//
//        //실제 이미지 가져오기
//        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//        String projections[] = {
//                MediaStore.Images.Media.DATA
//        };

        return result;

    }
}
