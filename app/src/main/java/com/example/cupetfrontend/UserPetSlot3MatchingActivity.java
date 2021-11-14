package com.example.cupetfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class UserPetSlot3MatchingActivity extends AppCompatActivity {
    private Button button;
    private Button preference_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pet_slot1_matching);
        button = (Button) findViewById(R.id.edit_pet1_profile_button);
        preference_button = (Button) findViewById(R.id.edit_pet1_preferences_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditProfileEditor();
            }
        });

        preference_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditPrefrenceEditor();
            }
        });
    }
    public void openEditProfileEditor(){
        Intent int1 = new Intent(this, EditPetProfile.class);
        startActivity(int1);
    }

    public void openEditPrefrenceEditor(){
        Intent int1 = new Intent(this, EditPetPreferences.class);
        startActivity(int1);
    }
}