package com.example.cupetfrontend.ui.edit_account;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.databinding.FragmentEditUserAccountBinding;
import com.example.cupetfrontend.presenters.abstracts.IEditUserAccountPresenter;
import com.example.cupetfrontend.presenters.data_models.UserAccountData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserAccountViewModel;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

public class EditUserAccountFragment extends MainActivityFragment {
    @Inject
    public IEditUserAccountViewModel editUserAccountViewModel;
    private FragmentEditUserAccountBinding binding;

    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IEditUserAccountPresenter editUserAccountPresenter;


    /**
     * If error message is non-null, display the error message on the field.
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
        binding = FragmentEditUserAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((App) getApplicationContext()).getAppComponent().inject(this);


        initializeDependencySelector();
        editUserAccountPresenter.setEditUserAccountViewModel(editUserAccountViewModel);

        setUpObserveEditUserAccountFormState();
        setUpObserveUserAccountResult();
        setUpFormEditedListener();
        setUpConfirmButtonClickedListener();

        getMainActivity().hideEditButton();

        if (editUserAccountViewModel.getContext() != null){
            preFillData(editUserAccountViewModel.getContext().getUserAccountData());
        }

        return root;
    }

    /**
     * Set up a listener that alerts editUserAccountProfileViewModel when the text
     * in the form has changed.
     */
    private void setUpFormEditedListener() {
        TextWatcher listener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Override with empty method
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Override with empty method
            }

            @Override
            public void afterTextChanged(Editable s) {
                EditUserAccountFormData editUserAccountFormData = getFormData();
                editUserAccountViewModel.updateFormState(editUserAccountFormData);
            }
        };

        binding.editUserAccountFirstName.addTextChangedListener(listener);
        binding.editUserAccountLastName.addTextChangedListener(listener);
        binding.editUserAccountEmail.addTextChangedListener(listener);
        binding.editUserAccountPassword.addTextChangedListener(listener);
        binding.editUserAccountConfirmPassword.addTextChangedListener(listener);
        binding.editUserAccountHomeAddress.addTextChangedListener(listener);
        binding.editUserAccountCity.addTextChangedListener(listener);
    }

    private void setUpConfirmButtonClickedListener(){
        binding.confirmEditUserAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditUserAccountFormData formData = getFormData();
                editUserAccountViewModel.editUserAccount(formData, sessionManager.getToken());
            }
        });
    }

    private EditUserAccountFormData getFormData(){
        EditUserAccountFormData formData = new EditUserAccountFormData();

        formData.setFirstname(binding.editUserAccountFirstName.getText().toString());
        formData.setLastname(binding.editUserAccountLastName.getText().toString());
        formData.setEmail(binding.editUserAccountEmail.getText().toString());
        formData.setPassword(binding.editUserAccountPassword.getText().toString());
        formData.setConfirmPassword(binding.editUserAccountConfirmPassword.getText().toString());
        formData.setAddress(binding.editUserAccountHomeAddress.getText().toString());
        formData.setCity(binding.editUserAccountCity.getText().toString());

        return formData;
    }

    private void setUpObserveUserAccountResult(){
        editUserAccountViewModel.getEditUserAccountResult().observe(getViewLifecycleOwner(), new Observer<EditUserAccountResult>() {
            @Override
            public void onChanged(EditUserAccountResult editUserAccountResult) {
                if (editUserAccountResult == null){
                    return;
                }

                if (editUserAccountResult.isError()){
                    onEditUserAccountFailure(editUserAccountResult.getErrorMessage());
                }
                else{
                    onEditUserAccountSuccess();
                }
            }
        });
    }

    private void setUpObserveEditUserAccountFormState(){
        editUserAccountViewModel.getFormState().observe(getViewLifecycleOwner(), new Observer<EditUserAccountFormState>() {
            @Override
            public void onChanged(EditUserAccountFormState editUserAccountFormState) {
                if (editUserAccountFormState == null){
                    return;
                }

                setFieldError(binding.editUserAccountFirstName,
                        editUserAccountFormState.getFirstNameState().getErrorMessage());
                setFieldError(binding.editUserAccountLastName,
                        editUserAccountFormState.getLastNameState().getErrorMessage());
                setFieldError(binding.editUserAccountEmail,
                        editUserAccountFormState.getEmailState().getErrorMessage());
                setFieldError(binding.editUserAccountPassword,
                        editUserAccountFormState.getPasswordState().getErrorMessage());
                setFieldError(binding.editUserAccountConfirmPassword,
                        editUserAccountFormState.getConfirmPasswordState().getErrorMessage());
                setFieldError(binding.editUserAccountHomeAddress,
                        editUserAccountFormState.getHomeAddressState().getErrorMessage());
                setFieldError(binding.editUserAccountCity,
                        editUserAccountFormState.getCityState().getErrorMessage());

                binding.confirmEditUserAccount.
                        setEnabled(editUserAccountFormState.isDataValid());
            }
        });
    }

    private void onEditUserAccountSuccess(){
        Toast.makeText(getApplicationContext(), "Edit Success", Toast.LENGTH_SHORT).show();
        getMainActivity().navigate(R.id.nav_account_settings);
    }

    private void onEditUserAccountFailure(String errorMessage){
        Toast.makeText(getApplicationContext(), "Edit Failed:" + errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void preFillData(UserAccountData userAccountData) {
        binding.editUserAccountFirstName.setText(userAccountData.getFirstName());
        binding.editUserAccountLastName.setText(userAccountData.getLastName());
        binding.editUserAccountEmail.setText(userAccountData.getEmail());
        binding.editUserAccountHomeAddress.setText(userAccountData.getHomeAddress());
        binding.editUserAccountCity.setText(userAccountData.getCity());

    }
}