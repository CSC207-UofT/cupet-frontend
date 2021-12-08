package com.example.cupetfrontend.ui.edit_account;

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
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.databinding.FragmentEditUserAccountBinding;
import com.example.cupetfrontend.presenters.abstracts.IEditUserAccountPresenter;
import com.example.cupetfrontend.presenters.user.EditUserAccountPresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

public class EditUserAccountFragment extends MainActivityFragment {
    private EditUserAccountViewModel editUserAccountViewModel;
    private FragmentEditUserAccountBinding binding;

    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IUserController userController;
    @Inject
    public IEditUserAccountPresenter editUserAccountPresenter;

    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailField;
    private EditText addressField;
    private EditText passwordField;
    private EditText cityField;
    private Button saveChangesButton;
    private String userToken;

    private void initializeViews(){
        firstNameField = binding.editAccountUserFirstNameInputTextview;
        lastNameField = binding.editAccountUserLastnameInputTextview;
        emailField = binding.editAccountUserEmailInput;
        addressField = binding.editAccountUserAddressInput;
        passwordField = binding.AccountUserPasswordInput;
        cityField = binding.editAccountUserCityInput;
        saveChangesButton = binding.ConfirmEditUserAccountButton;
    }


    /**
     * If errorState is non-null, display the error state on the field.
     *
     * @param field The field to display the error state in
     * @param errorState The error state represented by an integer
     */
    private void setFieldError(EditText field, Integer errorState) {
        if (errorState != null) {
            field.setError(getString(errorState));
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


        editUserAccountViewModel = new EditUserAccountViewModel(userController);
        editUserAccountPresenter.setEditUserAccountViewModel(editUserAccountViewModel);
        userToken = sessionManager.getToken();

        initializeViews();
        setUpObserveEditUserAccountFormState();
        setUpObserveUserAccountResult();
        setUpFormEditedListener();
        setUpConfirmButtonClickedListener();

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
                EditUserAccountData editUserAccountData = getEditUserAccountData();
                editUserAccountViewModel.updateFormState(editUserAccountData);
            }
        };

        firstNameField.addTextChangedListener(listener);
        lastNameField.addTextChangedListener(listener);
        emailField.addTextChangedListener(listener);
        passwordField.addTextChangedListener(listener);
        addressField.addTextChangedListener(listener);
        cityField.addTextChangedListener(listener);
    }

    /**
     * Return the data entered into the edit account form.
     *
     * @return The data entered into the edit account form.
     */
    private void setUpConfirmButtonClickedListener(){
        saveChangesButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditUserAccountData formData = getEditUserAccountData();
                editUserAccountViewModel.editUserAccount(formData, userToken);
            }
        });
    }

    private EditUserAccountData getEditUserAccountData(){
        EditUserAccountData formData = new EditUserAccountData();
        formData.setfirstName(firstNameField.getText().toString());
        formData.setlastName(lastNameField.getText().toString());
        formData.setEmail(emailField.getText().toString());
        formData.setPassword(passwordField.getText().toString());
        formData.setAddress(addressField.getText().toString());
        formData.setCity(cityField.getText().toString());

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
        editUserAccountViewModel.getEditUserAccountState().observe(getViewLifecycleOwner(), new Observer<EditUserAccountState>() {
            @Override
            public void onChanged(EditUserAccountState editUserAccountState) {
                if (editUserAccountState == null){
                    return;
                }

                setFieldError(firstNameField, editUserAccountState.getFirstNameError());
                setFieldError(lastNameField, editUserAccountState.getLastNameError());
                setFieldError(emailField, editUserAccountState.getEmailError());
                setFieldError(passwordField, editUserAccountState.getPasswordError());
                setFieldError(addressField, editUserAccountState.getAddressNameError());
                setFieldError(cityField, editUserAccountState.getCityNameError());

                saveChangesButton.setEnabled(editUserAccountState.isDataValid());

            }
        });
    }

    private void onEditUserAccountSuccess(){
        Toast.makeText(getApplicationContext(), "Edit Success", Toast.LENGTH_SHORT).show();
        getMainActivity().navigate(R.id.nav_account_settings);


    }

    private void onEditUserAccountFailure(String errorMessage){
        System.out.println("Edit failed");
        Toast.makeText(getApplicationContext(), "Edit failed:" + errorMessage, Toast.LENGTH_SHORT).show();
    }

}