package com.example.cupetfrontend.ui.create_pet;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.databinding.FragmentCreatePetBinding;
import com.example.cupetfrontend.presenters.abstracts.ICreatePetPresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

/**
 * The fragment for the Create Pet page.
 */
public class CreatePetFragment extends MainActivityFragment {
    private EditText petNameField;
    private EditText petAgeField;
    private EditText petBreedField;
    private EditText petBioField;
    private ImageView petImage;
    private Button createPetButton;
    private ImageButton editPetImageButton;
    private CreatePetViewModel createPetViewModel;
    private FragmentCreatePetBinding binding;

    @Inject
    public IPetController petController;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public ICreatePetPresenter createPetPresenter;

    /**
     * Initialize the views of the form into the field instance variables.
     */
    private void initializeViews() {
        petNameField = binding.petPetName;
        petAgeField = binding.petPetAge;
        petBreedField = binding.petPetBreed;
        petBioField = binding.petPetBio;
        petImage = binding.petImage;
        createPetButton = binding.confirmAddPetButton;
        editPetImageButton = binding.editPetImageButton;
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
        binding = FragmentCreatePetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ((App) getApplicationContext()).getAppComponent().inject(this);
        createPetViewModel = new CreatePetViewModel(petController);
        createPetPresenter.setCreatePetViewModel(createPetViewModel);

        initializeViews();
        setUpObserveCreatePetFormState();
        setUpObserveCreatePetResult();
        setUpFormEditedListener();
        setUpCreatePetButtonClickedListener();
        setUpEditPetImageButtonClickedListener();

        return root;
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
     * Set up a listener that sends a upload pet image request when editPetImageButton (pen)
     * is clicked.
     */
    private void setUpEditPetImageButtonClickedListener() {
        editPetImageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO: take-in image
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
        createPetViewModel.getCreatePetResult().observe(getViewLifecycleOwner(), new Observer<CreatePetResult>() {
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
        createPetViewModel.getCreatePetFormState().observe(getViewLifecycleOwner(), new Observer<CreatePetFormState>() {
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

        // TODO: Eventually navigate to all pets page and sign in as the newly created pet.
        getMainActivity().navigate(R.id.nav_my_pet_profile);
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
