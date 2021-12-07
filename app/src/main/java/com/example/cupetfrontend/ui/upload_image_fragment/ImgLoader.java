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
public class ImgLoader {
    public static Bitmap bitMapFromUri(ContentResolver contentResolver, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();

        return image;
    }

    /**
     * Attach a PNG B64 prefix to a b64 image raw-data string.
     */
    private static String attachB64ImagePrefix(String b64){
        return "data:image/png;base64," + b64;
    }

    public static String b64FromBitmap(Bitmap bitmap){
        // Convert bitmap to byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        String b64 = Base64.encodeToString(byteArray, Base64.NO_WRAP);

        return attachB64ImagePrefix(b64);
    }
}
