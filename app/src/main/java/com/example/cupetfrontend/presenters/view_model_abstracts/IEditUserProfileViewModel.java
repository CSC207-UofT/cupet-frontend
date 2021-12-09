package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.EditUserProfileContext;
import com.example.cupetfrontend.ui.edit_user_profile.EditUserProfileData;
import com.example.cupetfrontend.ui.edit_user_profile.EditUserProfileResult;
import com.example.cupetfrontend.ui.edit_user_profile.EditUserProfileState;

import androidx.lifecycle.LiveData;

public interface IEditUserProfileViewModel {
    LiveData<EditUserProfileState> getEditUserProfileState();

    LiveData<EditUserProfileResult> getEditUserProfileResult();

    void setUserProfileImage(String token, String imgB64);

    void editUserProfile(EditUserProfileData formData, String token);

    void updateFormState(EditUserProfileData formData);

    void onEditUserProfileSuccess();

    void onEditUserProfileFailure(String message);

    void onSetUserProfileImageSuccess();

    void onSetUserProfileImageFailure(String message);

    void setContext(EditUserProfileContext context);

    EditUserProfileContext getContext();
}
