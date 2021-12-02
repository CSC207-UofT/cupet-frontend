package com.example.cupetfrontend.use_cases.response_models;

/**
 * A response model superclass for response models of
 * requests which fetch/set images.
 */
public class ImageActionSuccessResponseModel {
    private final String imgUrl;

    public ImageActionSuccessResponseModel(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
