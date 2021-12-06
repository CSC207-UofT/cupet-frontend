package com.example.cupetfrontend.ui.edit_user_profile;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IEditUserProfilePresenter;

public class EditUserProfileActivity extends AppCompatActivity {
    private EditUserProfileViewModel editUserProfileViewModel;
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
        biographyField = findViewById(R.id.editTextTextPersonName);
        facebookField = findViewById(R.id.editTextTextPersonName4);
        instagramField = findViewById(R.id.editTextTextPersonName2);
        phoneNumberField = findViewById(R.id.editTextTextPersonName3);
        confirmChangesButton = findViewById(R.id.Confirm_EditUserAccount_button);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityEditUserProfileBinding.inflate(getLayoutInflater());
//        View root = binding.getRoot();
        setContentView(R.layout.activity_edit_user_profile);

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IUserController userController = dependencySelector.getControllers().getUserController();

        IEditUserProfilePresenter editUserProfilePresenter = dependencySelector.getUserPresenters().getEditUserProfilePresenter();
        editUserProfileViewModel = new EditUserProfileViewModel(userController);
        editUserProfilePresenter.setEditUserProfileViewModel(editUserProfileViewModel);

        initializeView();
        setUpFormEditedListener();
        setUpConfirmButtonClickedListener();
        setUpObserveUserProfileResult();
        setUpObserveEditUserProfileFormState();
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
        confirmChangesButton = findViewById(R.id.Confirm_EditUserAccount_button);
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
                finish();
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
        editUserProfileViewModel.getEditUserProfileState().observe(this, new Observer<EditUserProfileState>() {
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