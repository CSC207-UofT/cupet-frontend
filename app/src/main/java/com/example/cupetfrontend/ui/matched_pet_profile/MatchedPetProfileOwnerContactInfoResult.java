package com.example.cupetfrontend.ui.matched_pet_profile;

import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;

public class MatchedPetProfileOwnerContactInfoResult {
    private final boolean isError;
    private final String errorMessage;
    private UserProfileData ownerContactInfoData;

    public MatchedPetProfileOwnerContactInfoResult(boolean isError, String errorMessage){
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    /**
     * Initialize a successful matched pet profile owner contact info result
     */
    public MatchedPetProfileOwnerContactInfoResult(UserProfileData ownerContactInfoData){
        this.isError = false;
        this.errorMessage = null;
        this.ownerContactInfoData = ownerContactInfoData;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public UserProfileData getOwnerContactInfoData() {
        return this.ownerContactInfoData;
    }
}
