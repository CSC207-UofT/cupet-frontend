package com.example.cupetfrontend.ui.pet_profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.ui.login.LoginActivity;


/**
 * The activity for viewing my Pet Profile page.
 */
public class PetProfileActivity extends AppCompatActivity {
    private ImageButton editPetButton;
    private PetProfileViewModel petProfileViewModel;

    /**
     * Initialize the views of the form into the field instance variables.
     */
    private void initializeViews() {
        editPetButton = findViewById(R.id.edit_pet_button);
    }

    /**
     * Setup views on pet profile view of the activity.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_profile);

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();

        IPetController petController = dependencySelector.getControllers().getPetController();

        IFetchPetProfilePresenter fetchPetProfilePresenter = dependencySelector.getPetPresenters().getFetchPetProfilePresenter();
        petProfileViewModel = new PetProfileViewModel(petController);
        fetchPetProfilePresenter.setPetProfileViewModel(petProfileViewModel);

        initializeViews();
        setUpEditPetButtonClickedListener();
    }

    /**
     * Set up a listener that sends a jump-to-edit request when editPetButton
     * is clicked.
     */
    private void setUpEditPetButtonClickedListener() {
        editPetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO: jump to edit pet page;
            }
        });
    }

    /**
     * Display a Pet Profile Fetching Success toast message and move to the login view.
     */
    private void onFetchPetProfileSuccess() {
        Toast.makeText(getApplicationContext(), "Fetch Pet Profile Success", Toast.LENGTH_SHORT).show();

        Intent moveToLoginIntent = new Intent(PetProfileActivity.this, LoginActivity.class);
        startActivity(moveToLoginIntent);
    }

    /**
     * Display a Pet Profile Fetching failed toast message.
     * @param errorMessage The error message to display
     */
    private void onFetchPetProfileFailure (String errorMessage) {
        System.out.println("Fetch Pet Profile failed");
        Toast.makeText(getApplicationContext(), "Fetch Pet Profile failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
