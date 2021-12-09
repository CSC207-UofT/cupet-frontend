package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

public class UploadImageContext {
    private final DataTypeOrigin dataTypeOrigin;
    private final String prefillImgUrl;

    public UploadImageContext(DataTypeOrigin dataTypeOrigin, String prefillImgUrl) {
        this.dataTypeOrigin = dataTypeOrigin;
        this.prefillImgUrl = prefillImgUrl;
    }

    public DataTypeOrigin getDataTypeOrigin() {
        return dataTypeOrigin;
    }

    public String getPrefillImgUrl() {
        return prefillImgUrl;
    }
}
