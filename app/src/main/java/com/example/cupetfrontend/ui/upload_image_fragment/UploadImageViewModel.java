package com.example.cupetfrontend.ui.upload_image_fragment;

import com.example.cupetfrontend.presenters.view_model_abstracts.IUploadImageViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UploadImageContext;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UploadImageViewModel implements IUploadImageViewModel {
    private String imgB64;
    private final MutableLiveData<UploadImageContext> context = new MutableLiveData<>();

    @Override
    public void setImgB64(String b64) {
        this.imgB64 = b64;
    }

    @Override
    public String getImgB64() {
        return imgB64;
    }

    @Override
    public void setContext(UploadImageContext context) {
        this.context.setValue(context);
    }

    @Override
    public LiveData<UploadImageContext> getContext() {
        return context;
    }
}
