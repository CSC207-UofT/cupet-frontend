package com.example.cupetfrontend.ui.edit_user_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;

public class EditUserProfileViewModel extends ViewModel implements IEditUserProfileViewModel {
    private final MutableLiveData<EditUserProfileResult> editUserProfileresult = new MutableLiveData<>();
    private final MutableLiveData<EditUserProfileState> editUserProfileState = new MutableLiveData<>();
    private final IUserController userController;

    public EditUserProfileViewModel(IUserController userController){
        this.userController = userController;
    }

    LiveData<EditUserProfileState> getEditUserProfileState(){
        return this.editUserProfileState;
    }

    LiveData<EditUserProfileResult> getEditUserProfileResult(){
        return this.editUserProfileresult;
    }

    public void editUserProfile(EditUserProfileData formData, String token){
        userController.editUserProfile(token, formData.getBiography(),
                formData.getInstagram(),formData.getFacebook(), formData.getPhoneNumber());
    }

    public void updateFormState(EditUserProfileData formData){
        EditUserProfileState newFormState = new EditUserProfileState();
        newFormState.setDataValid(true);
        editUserProfileState.setValue(newFormState);
    }

    @Override
    public void onEditUserProfileSuccess() {
        EditUserProfileResult newEditUseProfileResult = new EditUserProfileResult(false);

        editUserProfileresult.setValue(newEditUseProfileResult);
    }

    @Override
    public void onEditUserProfileFailure(String message) {
        EditUserProfileResult newEditUserProfileResult = new EditUserProfileResult(true, message);
        editUserProfileresult.setValue(newEditUserProfileResult);
    }

}
