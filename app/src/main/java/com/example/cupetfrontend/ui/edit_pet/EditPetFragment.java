package com.example.cupetfrontend.ui.edit_pet;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.databinding.FragmentEditPetBinding;
import com.example.cupetfrontend.databinding.FragmentMyPetProfileBinding;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IEditPetPresenter;
import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;
import com.example.cupetfrontend.ui.login.LoginActivity;
import com.example.cupetfrontend.ui.my_pet_profile.PetProfileViewModel;

/**
 * The fragment for the Edit Pet page.
 */
public class EditPetFragment extends MainActivityFragment {
    private EditText petNameField;
    private EditText petAgeField;
    private EditText petBreedField;
    private EditText petBioField;
    private Button editPetButton;
    private EditPetViewModel editPetViewModel;
    private FragmentEditPetBinding binding;

    /**
     * Initialize the views of the form into the field instance variables.
     */
    private void initializeViews() {
        petNameField = binding.petPetName;
        petAgeField = binding.petPetAge;
        petBreedField = binding.petPetBreed;
        petBioField = binding.petPetBio;
        editPetButton = binding.confirmEditPetButton;
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
        binding = FragmentEditPetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initializeDependencySelector();

        IPetController petController = dependencySelector.getControllers().getPetController();

        IEditPetPresenter editPetPresenter = dependencySelector.getPetPresenters().getEditPetPresenter();
        editPetViewModel = new EditPetViewModel(petController);
        editPetPresenter.setEditPetViewModel(editPetViewModel);

        initializeViews();
        setUpObserveEditPetFormState();
        setUpObserveEditPetResult();
        setUpFormEditedListener();
        setUpEditPetButtonClickedListener();

        return root;
    }

    /**
     * Set up a listener that alerts editPetViewModel when the text
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
                EditPetFormData formData = getEditPetFormData();
                editPetViewModel.updateFormState(formData);
            }
        };

        petNameField.addTextChangedListener(listener);
        petAgeField.addTextChangedListener(listener);
        petBreedField.addTextChangedListener(listener);
        petBioField.addTextChangedListener(listener);
    }

    /**
     * Set up a listener that sends an edit pet request when editPetButton
     * is clicked.
     */
    private void setUpEditPetButtonClickedListener() {
        editPetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditPetFormData formData = getEditPetFormData();
                editPetViewModel.editPet(formData);
            }
        });
    }

    /**
     * Return the data entered into the pet edition form.
     *
     * @return The data entered into the pet edition form.
     */
    private EditPetFormData getEditPetFormData() {
        EditPetFormData formData = new EditPetFormData();

        formData.setPetName(petNameField.getText().toString());
        formData.setPetAge(petAgeField.getText().toString());
        formData.setPetBreed(petBreedField.getText().toString());
        formData.setPetBio(petBioField.getText().toString());

        return formData;
    }

    /**
     * Set up this activity as an observer that observes the result of pet edition.
     *
     * Update the displayed views when the pet edition result has changed.
     */
    private void setUpObserveEditPetResult() {
        editPetViewModel.getEditPetResult().observe(this, new Observer<EditPetResult>() {
            @Override
            public void onChanged(@Nullable EditPetResult editPetResult) {
                if (editPetResult == null) {
                    return;
                }

                if (editPetResult.isError()){
                    onEditPetFailure(editPetResult.getErrorMessage());
                }else{
                    onEditPetSuccess();
                }
            }
        });
    }

    /**
     * Set up this activity as an observer that observes the error states of the
     * pet edition form.
     *
     * Update the fields accordingly to whether or not they have errors.
     */
    private void setUpObserveEditPetFormState() {
        editPetViewModel.getEditPetFormState().observe(this, new Observer<EditPetFormState>() {
            @Override
            public void onChanged(@Nullable EditPetFormState editPetFormState) {
                if (editPetFormState == null) {
                    return;
                }

                setFieldError(petNameField, editPetFormState.getPetNameError());
                setFieldError(petAgeField, editPetFormState.getPetAgeError());
                setFieldError(petBreedField, editPetFormState.getPetBreedError());
                setFieldError(petBioField, editPetFormState.getPetBioError());

                editPetButton.setEnabled(editPetFormState.isDataValid());
            }
        });
    }

    /**
     * Display a Pet Edition Success toast message and move to the pet profile page.
     */
    private void onEditPetSuccess() {
        Toast.makeText(getApplicationContext(), "Pet Edition Success", Toast.LENGTH_SHORT).show();

        getMainActivity().navigate(R.id.nav_my_pet_profile);
    }

    /**
     * Display a Pet Edition failed toast message.
     * @param errorMessage The error message to display
     */
    private void onEditPetFailure (String errorMessage) {
        System.out.println("Pet Edition failed");
        Toast.makeText(getApplicationContext(), "Pet Edition failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
