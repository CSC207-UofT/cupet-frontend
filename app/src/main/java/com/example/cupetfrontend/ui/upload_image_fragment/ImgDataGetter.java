package com.example.cupetfrontend.ui.upload_image_fragment;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * A class responsible for getting raw image data from android uris.
 */
public class ImgDataGetter {
    public static Bitmap bitMapFromUri(ContentResolver contentResolver, Uri uri) throws IOException {
        return MediaStore.Images.Media.getBitmap(
                contentResolver, uri);
    }

    public static String b64FromBitmap(Bitmap bitmap){
        // Convert bitmap to byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();

        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }
}
