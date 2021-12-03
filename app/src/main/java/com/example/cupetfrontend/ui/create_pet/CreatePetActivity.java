package com.example.cupetfrontend.ui.create_pet;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.ICreatePetPresenter;
import com.example.cupetfrontend.ui.login.LoginActivity;

/**
 * The activity for the Create Pet page.
 */
public class CreatePetActivity extends AppCompatActivity {
    private EditText petNameField;
    private EditText petAgeField;
    private EditText petBreedField;
    private EditText petBioField;
    private Button createPetButton;
    private CreatePetViewModel createPetViewModel;

    /**
     * Initialize the views of the form into the field instance variables.
     */
    private void initializeViews() {
        petNameField = findViewById(R.id.pet_petName);
        petAgeField = findViewById(R.id.pet_petAge);
        petBreedField = findViewById(R.id.pet_petBreed);
        petBioField = findViewById(R.id.pet_petBio);
        createPetButton = findViewById(R.id.confirm_add_pet_button);
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

    /**
     * Setup views and state on pet creation of the activity.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pet);

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();

        IPetController petController = dependencySelector.getControllers().getPetController();

        ICreatePetPresenter createPetPresenter = dependencySelector.getPetPresenters().getCreatePetPresenter();
        createPetViewModel = new CreatePetViewModel(petController);
        createPetPresenter.setCreatePetViewModel(createPetViewModel);

        initializeViews();
        setUpObserveCreatePetFormState();
        setUpObserveCreatePetResult();
        setUpFormEditedListener();
        setUpCreatePetButtonClickedListener();
    }

    /**
     * Set up a listener that alerts createPetViewModel when the text
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
                CreatePetFormData formData = getCreatePetFormData();
                createPetViewModel.updateFormState(formData);
            }
        };

        petNameField.addTextChangedListener(listener);
        petAgeField.addTextChangedListener(listener);
        petBreedField.addTextChangedListener(listener);
        petBioField.addTextChangedListener(listener);
    }

    /**
     * Set up a listener that sends a create pet request when createPetButton
     * is clicked.
     */
    private void setUpCreatePetButtonClickedListener() {
        createPetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CreatePetFormData formData = getCreatePetFormData();
                createPetViewModel.createPet(formData);
            }
        });
    }

    /**
     * Return the data entered into the pet creation form.
     *
     * @return The data entered into the pet creation form.
     */
    private CreatePetFormData getCreatePetFormData() {
        CreatePetFormData formData = new CreatePetFormData();

        formData.setPetName(petNameField.getText().toString());
        formData.setPetAge(petAgeField.getText().toString());
        formData.setPetBreed(petBreedField.getText().toString());
        formData.setPetBio(petBioField.getText().toString());

        return formData;
    }

    /**
     * Set up this activity as an observer that observes the result of pet creation.
     *
     * Update the displayed views when the pet creation result has changed.
     */
    private void setUpObserveCreatePetResult() {
        createPetViewModel.getCreatePetResult().observe(this, new Observer<CreatePetResult>() {
            @Override
            public void onChanged(@Nullable CreatePetResult createPetResult) {
                if (createPetResult == null) {
                    return;
                }

                if (createPetResult.isError()){
                    onCreatePetFailure(createPetResult.getErrorMessage());
                }else{
                    onCreatePetSuccess();
                }

                finish();
            }
        });
    }

    /**
     * Set up this activity as an observer that observes the error states of the
     * pet creation form.
     *
     * Update the fields accordingly to whether or not they have errors.
     */
    private void setUpObserveCreatePetFormState() {
        createPetViewModel.getCreatePetFormState().observe(this, new Observer<CreatePetFormState>() {
            @Override
            public void onChanged(@Nullable CreatePetFormState createPetFormState) {
                if (createPetFormState == null) {
                    return;
                }

                setFieldError(petNameField, createPetFormState.getPetNameError());
                setFieldError(petAgeField, createPetFormState.getPetAgeError());
                setFieldError(petBreedField, createPetFormState.getPetBreedError());
                setFieldError(petBioField, createPetFormState.getPetBioError());

                createPetButton.setEnabled(createPetFormState.isDataValid());
            }
        });
    }

    /**
     * Display a Pet Creation Success toast message and move to the login view.
     */
    private void onCreatePetSuccess() {
        Toast.makeText(getApplicationContext(), "Pet Creation Success", Toast.LENGTH_SHORT).show();

        Intent moveToLoginIntent = new Intent(CreatePetActivity.this, LoginActivity.class);
        startActivity(moveToLoginIntent);
    }

    /**
     * Display a Pet Creation failed toast message.
     * @param errorMessage The error message to display
     */
    private void onCreatePetFailure (String errorMessage) {
        System.out.println("Pet Creation failed");
        Toast.makeText(getApplicationContext(), "Pet Creation failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
