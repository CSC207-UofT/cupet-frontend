package com.example.cupetfrontend.ui.edit_user_profile;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import com.example.cupetfrontend.R;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.databinding.FragmentEditUserProfileBinding;
import com.example.cupetfrontend.presenters.abstracts.IEditUserProfilePresenter;
import com.example.cupetfrontend.presenters.abstracts.ISetUserProfileImagePresenter;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUploadImageViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.DataTypeOrigin;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UploadImageContext;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

public class EditUserProfileFragment extends MainActivityFragment {
    @Inject
    public IEditUserProfileViewModel viewModel;
    @Inject
    public IUploadImageViewModel uploadImageViewModel;
    @Inject
    public ISessionManager sessionManager;
    private FragmentEditUserProfileBinding binding;

    @Inject
    public IEditUserProfilePresenter editUserProfilePresenter;
    @Inject
    public ISetUserProfileImagePresenter setUserProfileImagePresenter;

    /**
     * If errorState is non-null, display the error state on the field.
     *
     * @param field The field to display the error state in
     * @param errorMessage the error message to display
     */
    private void setFieldError(EditText field, String errorMessage) {
        if (errorMessage != null) {
            field.setError(errorMessage);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentEditUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getApplicationContext().getAppComponent().inject(this);
        editUserProfilePresenter.setEditUserProfileViewModel(viewModel);
        setUserProfileImagePresenter.setViewModel(viewModel);

        setUpFormEditedListener();
        setUpConfirmButtonClickedListener();
        setUpObserveUserProfileResult();
        setUpObserveEditUserProfileFormState();

        if (viewModel.getContext() != null){
            preFillExistingData(viewModel.getContext().getPreFilledData());
        }

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
                viewModel.updateFormState(editUserProfileData);
            }
        };
        binding.editUserProfileBiography.addTextChangedListener(listener);
        binding.editUserProfileInstagram.addTextChangedListener(listener);
        binding.editUserProfileFacebook.addTextChangedListener(listener);
        binding.editUserProfilePhoneNum.addTextChangedListener(listener);
    }

    private EditUserProfileData getEditUserProfileData(){
        return new EditUserProfileData(
                binding.editUserProfileBiography.getText().toString(),
                binding.editUserProfilePhoneNum.getText().toString(),
                binding.editUserProfileFacebook.getText().toString(),
                binding.editUserProfileInstagram.getText().toString()
        );
    }

    private void setUpConfirmButtonClickedListener(){
        binding.ConfirmEditUserProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditUserProfileData formData = getEditUserProfileData();

                viewModel.editUserProfile(formData, sessionManager.getToken());

                if (uploadImageViewModel.getImgB64() != null){
                    viewModel.setUserProfileImage(sessionManager.getToken(),
                            uploadImageViewModel.getImgB64());
                }
            }
        });
    }

    private void setUpObserveUserProfileResult(){
        viewModel.getEditUserProfileResult().observe(getViewLifecycleOwner(), new Observer<EditUserProfileResult>() {
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
        getMainActivity().navigate(R.id.nav_my_user_profile);
    }


    private void onEditUserProfileFailure(String errorMessage){
        Toast.makeText(getApplicationContext(), "Edit Failed:" + errorMessage, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "User Profile Edit Failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void setUpObserveEditUserProfileFormState(){
        viewModel.getEditUserProfileState().observe(getViewLifecycleOwner(), new Observer<EditUserProfileState>() {
            @Override
            public void onChanged(EditUserProfileState editUserProfileState) {
                if (editUserProfileState == null){
                    return;
                }

                setFieldError(binding.editUserProfileBiography,
                        editUserProfileState.getBiographyState().getErrorMessage());
                setFieldError(binding.editUserProfileInstagram,
                        editUserProfileState.getInstagramState().getErrorMessage());
                setFieldError(binding.editUserProfileFacebook,
                        editUserProfileState.getFacebookState().getErrorMessage());
                setFieldError(binding.editUserProfilePhoneNum,
                        editUserProfileState.getPhoneNumberState().getErrorMessage());
            }
        });
    }

    private void preFillExistingData(UserProfileData userProfileData) {
        binding.editUserProfileBiography.setText(userProfileData.getBiography());
        binding.editUserProfilePhoneNum.setText(userProfileData.getPhoneNumber());
        binding.editUserProfileFacebook.setText(userProfileData.getFacebook());
        binding.editUserProfileInstagram.setText(userProfileData.getInstagram());

        uploadImageViewModel.setContext(new UploadImageContext(
                DataTypeOrigin.USER,
                userProfileData.getProfileImgUrl()
        ));
    }
}