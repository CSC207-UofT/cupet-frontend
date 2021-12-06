package com.example.cupetfrontend.ui.edit_user_profile;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.databinding.FragmentCreatePetBinding;
import com.example.cupetfrontend.databinding.FragmentEditUserAccountBinding;
import com.example.cupetfrontend.databinding.FragmentEditUserProfileBinding;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IEditUserProfilePresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;

public class EditUserProfileFragment extends MainActivityFragment {
    private EditUserProfileViewModel editUserProfileViewModel;
    private FragmentEditUserProfileBinding binding;

    private EditText biographyField;
    private EditText facebookField;
    private EditText instagramField;
    private EditText phoneNumberField;
    private Button confirmChangesButton;

    private void setFieldError(EditText field, Integer errorState){
        if (errorState != null){
            field.setError(getString(errorState));
        }
    };

    private void initializeView(){
        biographyField = binding.editUserProfileBiography;
        facebookField = binding.editUserProfileFacebook;
        instagramField = binding.editUserProfileInstagram;
        phoneNumberField = binding.editUserProfilePhoneNum;
        confirmChangesButton = binding.ConfirmEditUserProfileButton;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentEditUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initializeDependencySelector();
        IUserController userController = dependencySelector.getControllers().getUserController();

        IEditUserProfilePresenter editUserProfilePresenter = dependencySelector.getUserPresenters().getEditUserProfilePresenter();
        editUserProfileViewModel = new EditUserProfileViewModel(userController);
        editUserProfilePresenter.setEditUserProfileViewModel(editUserProfileViewModel);

        initializeView();
        setUpFormEditedListener();
        setUpConfirmButtonClickedListener();
        setUpObserveUserProfileResult();
        setUpObserveEditUserProfileFormState();

        return root;
    }

    private void setUpFormEditedListener(){
        TextWatcher listener = new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Override with empty method
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                EditUserProfileData editUserProfileData = getEditUserProfileData();
                editUserProfileViewModel.updateFormState(editUserProfileData);
            }
        };
        biographyField.addTextChangedListener(listener);
        instagramField.addTextChangedListener(listener);
        facebookField.addTextChangedListener(listener);
        phoneNumberField.addTextChangedListener(listener);
    }

    private EditUserProfileData getEditUserProfileData(){
        EditUserProfileData formData = new EditUserProfileData();
        formData.setBiography(biographyField.getText().toString());
        formData.setFacebook(facebookField.getText().toString());
        formData.setInstagram(instagramField.getText().toString());
        formData.setPhoneNumber(phoneNumberField.getText().toString());

        return formData;
    }

    private void setUpConfirmButtonClickedListener(){
        confirmChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditUserProfileData formData = getEditUserProfileData();
                editUserProfileViewModel.editUserProfile(formData, "TOKEN");
            }
        });
    }

    private void setUpObserveUserProfileResult(){
        editUserProfileViewModel.getEditUserProfileResult().observe(this, new Observer<EditUserProfileResult>() {
            @Override
            public void onChanged(EditUserProfileResult editUserProfileResult) {
                if (editUserProfileResult == null)
                    return;

                if (editUserProfileResult.isError()){
                    onEditUserProfileFailure(editUserProfileResult.getErrorMessage());
                }
                else{
                    onEditUserProfileSuccess();
                }
            }
        });
    }

    private void onEditUserProfileSuccess(){
        Toast.makeText(getApplicationContext(), "Edit Success", Toast.LENGTH_SHORT).show();
    }

    private void onEditUserProfileFailure(String errorMessage){
        System.out.println("Edit failed");
        Toast.makeText(getApplicationContext(), "Edit Failed:" + errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void setUpObserveEditUserProfileFormState(){
        editUserProfileViewModel.getEditUserProfileState().observe(getViewLifecycleOwner(), new Observer<EditUserProfileState>() {
            @Override
            public void onChanged(EditUserProfileState editUserProfileState) {
                if (editUserProfileState == null){

                }
                setFieldError(biographyField, editUserProfileState.getBiographyError());
                setFieldError(instagramField, editUserProfileState.getInstagramError());
                setFieldError(facebookField, editUserProfileState.getFacebookError());
                setFieldError(phoneNumberField, editUserProfileState.getPhoneNumberError());
            }
        });
    }
}