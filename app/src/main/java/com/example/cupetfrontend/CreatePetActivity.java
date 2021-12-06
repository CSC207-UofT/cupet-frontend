package com.example.cupetfrontend;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.ICreatePetPresenter;
import com.example.cupetfrontend.presenters.abstracts.ICreateUserPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.ICreatePetViewModel;
import com.example.cupetfrontend.ui.login.LoginActivity;
import com.example.cupetfrontend.ui.register.*;

public class CreatePetActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button confirm_button;
    private String name;
    private String biography;
    private int age;
    private String breed;
    private CreatePetViewModel createPetViewModel;
    private ISessionManager sessionManager;

    EditText nameInput;
    EditText ageInput;
    EditText biographyInput;

    private void setFieldError(EditText field, Integer errorState){
        if (errorState != null){
            field.setError(getString(errorState));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pet);


        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IPetController petController = dependencySelector.getControllers().getPetController();

        ICreatePetPresenter createPetPresenter = dependencySelector.getPetPresenters().getCreatePetPresenter();
        createPetViewModel = new CreatePetViewModel(petController);
        createPetPresenter.setCreatePetViewModel(createPetViewModel);

        sessionManager = dependencySelector.getSessionManager();
        createPetViewModel.createPetProfile(getCreatePetData(), sessionManager.getToken());

        nameInput = (EditText) findViewById(R.id.Create_Pet_Name_Input);
        ageInput = (EditText) findViewById(R.id.Create_Pet_Age_Input);
        biographyInput = (EditText) findViewById(R.id.Create_Pet_Biography_Input);



        Spinner breed_spinner = (Spinner) findViewById(R.id.Create_Pet_Breed_Spinner_Input);
        ArrayAdapter<String> breedAdapter = new ArrayAdapter<String>(CreatePetActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Breeds));
        breedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        breed_spinner.setAdapter(breedAdapter);
        breed_spinner.setOnItemSelectedListener(this);

        setUpObserveCreatePetState();
        setUpObserveCreatePetResult();
        setUpPetCreatedListener();
        setUpCreatePetProfileButtonClickedListener();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        breed = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), breed, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void setUpObserveCreatePetState() {
        createPetViewModel.getCreatePetState().observe(this, new Observer<CreatePetState>() {
            @Override
            public void onChanged(@Nullable CreatePetState createPetState) {
                if (createPetState == null) {
                    return;
                }

                setFieldError(nameInput, createPetState.getNameError());
                setFieldError(ageInput, createPetState.getAgeError());
                setFieldError(biographyInput, createPetState.getBiographyError());
            }
        });
    }

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

    private void onCreatePetSuccess() {
        Toast.makeText(getApplicationContext(), "Pet Profile Creation Success", Toast.LENGTH_SHORT).show();

        Intent moveToLoginIntent = new Intent(CreatePetActivity.this, UserPetSlot1MatchingActivity.class);
        startActivity(moveToLoginIntent);
    }

    private void onCreatePetFailure (String errorMessage) {
        System.out.println("Pet Profile Creation failed");
        Toast.makeText(getApplicationContext(), "Pet Profile Creation failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void setUpPetCreatedListener() {
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
                CreatePetProfileData createPetProfileData = getCreatePetData();
                createPetViewModel.updateFormState(createPetProfileData);
            }
        };

        nameInput.addTextChangedListener(listener);
        ageInput.addTextChangedListener(listener);
        biographyInput.addTextChangedListener(listener);
    }

    private CreatePetProfileData getCreatePetData() {
        CreatePetProfileData createPetProfileData = new CreatePetProfileData();
        createPetProfileData.setName(nameInput.getText().toString());
        createPetProfileData.setAge(Integer.parseInt(ageInput.getText().toString()));
        createPetProfileData.setBiography(biographyInput.getText().toString());
        createPetProfileData.setBreed(breed);

        return createPetProfileData;
    }

    private void setUpCreatePetProfileButtonClickedListener() {
        confirm_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CreatePetProfileData createPetProfileData = getCreatePetData();
                createPetViewModel.createPetProfile(createPetProfileData, sessionManager.getToken());
            }
        });
    }
}