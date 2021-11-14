package com.example.cupetfrontend;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CreatePetActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button confirm_button;
    private String name;
    private String biography;
    private int age;
    private String breed;

    EditText nameInput;
    EditText ageInput;
    EditText biographyInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pet);

        nameInput = (EditText) findViewById(R.id.Create_Pet_Name_Input);
        ageInput = (EditText) findViewById(R.id.Create_Pet_Age_Input);
        biographyInput = (EditText) findViewById(R.id.Create_Pet_Biography_Input);


        Spinner breed_spinner = (Spinner) findViewById(R.id.Create_Pet_Breed_Spinner_Input);
        ArrayAdapter<String> breedAdapter = new ArrayAdapter<String>(CreatePetActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Breeds));
        breedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        breed_spinner.setAdapter(breedAdapter);
        breed_spinner.setOnItemSelectedListener(this);

        Button confirm_button = (Button) findViewById(R.id.Confirm_pet_creation_button);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean is_valid = true;
                String error = "The following errors occured: ";
                name = nameInput.getText().toString();
                age = Integer.parseInt(ageInput.getText().toString());
                biography = biographyInput.getText().toString();


                if (age < 0) {
                    is_valid = false;
                    error += "The age must be greater than 0. ";
                }
                ;

                if (name.length() <= 1) {
                    is_valid = false;
                    error += "The name of the pet must be longer than one character. ";

                }
                ;

                if (!is_valid) {
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                } else {
                    CreatePetProfileData createPetProfileData= new CreatePetProfileData(name, age, biography, breed);
                    String jsonData = createPetProfileData.toJSON();
                    Toast.makeText(getApplicationContext(), jsonData, Toast.LENGTH_LONG).show();

                };
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        breed = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), breed, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}