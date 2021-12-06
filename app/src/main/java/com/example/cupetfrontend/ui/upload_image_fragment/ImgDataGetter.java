package com.example.cupetfrontend.ui.upload_image_fragment;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;

/**
 * A class responsible for getting raw image data from android uris.
 */
public class ImgDataGetter {
    public static Bitmap bitMapFromUri(ContentResolver contentResolver, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();

        return image;
    }

    public static String b64FromBitmap(Bitmap bitmap){
        // Convert bitmap to byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        System.out.println(Base64.encodeToString(byteArray, Base64.NO_WRAP));

        String b64 =  Base64.encodeToString(byteArray, Base64.NO_WRAP);
        b64 = b64.replace("\n", "");

        return b64;
    }
}
