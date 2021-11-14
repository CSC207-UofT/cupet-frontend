package com.example.cupetfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UserPetSlotsFragment3 extends Fragment{
    Button slot3_button;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.petslot3_layout, container, false);
        slot3_button = (Button) view.findViewById(R.id.slot3_matching_button);

        slot3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openPet3MatchingActivity();

            }
        });
        return view;
    }

    public void openPet3MatchingActivity(){
        Intent intent = new Intent(getActivity(), UserPetSlot2MatchingActivity.class);
        startActivity(intent);
    }
}

