package com.example.cupetfrontend.ui.upload_image_fragment;

import com.example.cupetfrontend.presenters.view_model_abstracts.IUploadImageViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UploadImageContext;

public class UploadImageViewModel implements IUploadImageViewModel {
    private String imgB64;
    private UploadImageContext context;

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
        this.context = context;
    }

    @Override
    public UploadImageContext getContext() {
        return context;
    }
}
