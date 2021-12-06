package com.example.cupetfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class UserPetSlotsFragment2 extends Fragment{
    View view;
    Button slot2_button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.petslot2_layout, container, false);
        slot2_button = (Button) view.findViewById(R.id.slot2_matching_button);
        slot2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openPet2MatchingActivity();}
        });
        return view;
    }

    public void openPet2MatchingActivity(){
        Intent intent = new Intent(getActivity(), UserPetSlot2MatchingActivity.class);
        startActivity(intent);
    }
}
