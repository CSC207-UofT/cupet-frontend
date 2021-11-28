package com.example.cupetfrontend.use_cases.response_models.pet;

public class AddToPetImageGallerySuccessResponseModel {
    private final String imgUrl;
    private final String assetId;

    public AddToPetImageGallerySuccessResponseModel(String imgUrl, String assetId) {
        this.imgUrl = imgUrl;
        this.assetId = assetId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getAssetId() {
        return assetId;
    }
}
