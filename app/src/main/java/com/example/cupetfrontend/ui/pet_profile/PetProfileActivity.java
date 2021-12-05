package com.example.cupetfrontend.ui.pet_profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.ui.edit_pet.EditPetActivity;


/**
 * The activity for viewing my Pet Profile page.
 */
public class PetProfileActivity extends AppCompatActivity {
    private ImageButton editPetButton;
    private ImageButton menuButton;
    private ImageView petImage;
    private TextView petName;
    private TextView petAge;
    private TextView petBreed;
    private TextView petBio;
    private PetProfileViewModel petProfileViewModel;

    /**
     * Initialize the views of the form into the field instance variables.
     */
    private void initializeViews() {
        editPetButton = findViewById(R.id.edit_pet_button);
        menuButton = findViewById(R.id.menu_button);
        petImage = findViewById(R.id.pet_image);
        petName = findViewById(R.id.pet_petName);
        petAge = findViewById(R.id.pet_petAge);
        petBreed = findViewById(R.id.pet_petBreed);
        petBio = findViewById(R.id.pet_petBio);
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
        setUpMenuButtonClickedListener();
    }

    // TODO: set up pet info to expected field
    private void setUpPetInfo() {}

    /**
     * Set up a listener that opens menu fragment when menuButton (3-lines)
     * is clicked.
     */
    private void setUpMenuButtonClickedListener() {
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: open menu fragment
            }
        });
    }

    /**
     * Set up a listener that jumps to edit pet page when editPetButton
     * is clicked.
     */
    private void setUpEditPetButtonClickedListener() {
        editPetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToEditPet = new Intent(PetProfileActivity.this, EditPetActivity.class);
                startActivity(moveToEditPet);
            }
        });
    }
}
