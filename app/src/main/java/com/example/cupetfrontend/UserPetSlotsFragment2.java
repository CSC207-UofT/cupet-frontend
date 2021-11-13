package com.example.cupetfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UserPetSlotsFragment2 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.petslot2_layout,container, false);
    }

    public void openPet2MatchingActivity(){
        Intent intent = new Intent(getActivity(), UserPetSlot1MatchingActivity.class);
        startActivity(intent);
    }
}
