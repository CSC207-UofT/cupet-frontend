package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UploadImageContext;

import androidx.lifecycle.LiveData;

public interface IUploadImageViewModel {
    void setImgB64(String b64);

    String getImgB64();

    void setContext(UploadImageContext context);

    LiveData<UploadImageContext> getContext();
}
