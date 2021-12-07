package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

public class UploadImageContext {
    private final DataTypeOrigin dataTypeOrigin;

    public UploadImageContext(DataTypeOrigin dataTypeOrigin) {
        this.dataTypeOrigin = dataTypeOrigin;
    }

    public DataTypeOrigin getDataTypeOrigin() {
        return dataTypeOrigin;
    }
}
