package com.example.cupetfrontend;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IEditUserAccountPresenter;
import com.example.cupetfrontend.presenters.user.EditUserAccountPresenter;

public class EditUserAccountActivity extends AppCompatActivity {
    private EditUserAccountViewModel editUserAccountViewModel;
    private ISessionManager sessionManager;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailField;
    private EditText addressField;
    private EditText passwordField;
    private EditText passwordConfirmField;
    private EditText cityField;
    private Button saveChangesButton;

    private void initializeViews(){
        firstNameField = findViewById(R.id.editAccountUserFirstName_Input_textview);
        lastNameField = findViewById(R.id.editAccountUserLastname_Input_textview);
        emailField = findViewById(R.id.editAccountUserEmail_Input);
        addressField = findViewById(R.id.editAccountUserAddress_Input);
        passwordField = findViewById(R.id.AccountUserPassword_Input);
        cityField = findViewById(R.id.editAccountUserCity_Input);
        saveChangesButton = findViewById(R.id.Confirm_EditUserAccount_button);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_account);

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();

        IUserController userController = dependencySelector.getControllers().getUserController();

        EditUserAccountPresenter editUserAccountPresenter = dependencySelector.getUserPresenters().getEditUserAccountPresenter();
        editUserAccountViewModel = new EditUserAccountViewModel(userController);
        editUserAccountPresenter.setEditUserAccountViewModel(editUserAccountViewModel);

        initializeViews();
        setUpObserveEditUserAccountFormState();
        setUpObserveUserAccountResult();
        setUpFormEditedListener();
        setUpConfirmButtonClickedListener();
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
                editUserAccountViewModel.editUserAccount(formData, "TOKEN CODE NEEDED");
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
        editUserAccountViewModel.getEditUserAccountResult().observe(this, new Observer<EditUserAccountResult>() {
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
                finish();

            }

        });
    }

    private void setUpObserveEditUserAccountFormState(){
        editUserAccountViewModel.getEditUserAccountState().observe(this, new Observer<EditUserAccountState>() {
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


    }

    private void onEditUserAccountFailure(String errorMessage){
        System.out.println("Edit failed");
        Toast.makeText(getApplicationContext(), "Edit failed:" + errorMessage, Toast.LENGTH_SHORT).show();
    }

}