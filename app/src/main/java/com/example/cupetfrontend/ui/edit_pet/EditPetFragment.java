package com.example.cupetfrontend.ui.edit_pet;

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
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.databinding.FragmentEditPetBinding;
import com.example.cupetfrontend.presenters.abstracts.IEditPetPresenter;
import com.example.cupetfrontend.presenters.data_models.PetProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditPetViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUploadImageViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.DataTypeOrigin;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UploadImageContext;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

/**
 * The fragment for the Edit Pet page.
 */
public class EditPetFragment extends MainActivityFragment {
    private EditText petNameField;
    private EditText petAgeField;
    private EditText petBreedField;
    private EditText petBioField;
    private Button editPetButton;
    private FragmentEditPetBinding binding;

    @Inject
    public IEditPetViewModel editPetViewModel;
    @Inject
    public IUploadImageViewModel uploadImageViewModel;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IEditPetPresenter editPetPresenter;
    @Inject
    public IPetController petController;

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

        ((App) getApplicationContext()).getAppComponent().inject(this);
        editPetPresenter.setEditPetViewModel(editPetViewModel);

        initializeViews();
        setUpObserveEditPetFormState();
        setUpObserveEditPetResult();
        setUpFormEditedListener();
        setUpEditPetButtonClickedListener();

        if (editPetViewModel.getContext() != null){
            prefillData(editPetViewModel.getContext().getPetProfileData());
        }

        getMainActivity().hideEditButton();

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

                if (uploadImageViewModel.getImgB64() != null){
                    editPetViewModel.setPetProfileImage(
                            uploadImageViewModel.getImgB64());
                }
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
        editPetViewModel.getEditPetResult().observe(getViewLifecycleOwner(), new Observer<EditPetResult>() {
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
        editPetViewModel.getEditPetFormState().observe(getViewLifecycleOwner(), new Observer<EditPetFormState>() {
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
        Toast.makeText(getApplicationContext(), "Pet Edit Success", Toast.LENGTH_SHORT).show();

        getMainActivity().navigate(R.id.nav_my_pet_profile);
    }

    /**
     * Display a Pet Edition failed toast message.
     * @param errorMessage The error message to display
     */
    private void onEditPetFailure (String errorMessage) {
        System.out.println("Pet Edit failed");
        Toast.makeText(getApplicationContext(), "Pet Edit failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void prefillData(PetProfileData petProfileData) {
        petNameField.setText(petProfileData.getName());
        petAgeField.setText(petProfileData.getAge());
        petBioField.setText(petProfileData.getBiography());
        petBreedField.setText(petProfileData.getBreed());

        uploadImageViewModel.setContext(new UploadImageContext(
                DataTypeOrigin.PET,
                petProfileData.getImgUrl()
        ));
    }
}
