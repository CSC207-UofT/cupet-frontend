package com.example.cupetfrontend;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

public class UserPetSlotsFragment extends Fragment{
    View view;
    Button slot1_button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.petslot1_layout,container, false);
        slot1_button = (Button) view.findViewById(R.id.slot1_matching_button);
        slot1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPet1MatchingActivity();
            }
        });
        return view;
    }

    public void openPet1MatchingActivity(){
    Intent intent = new Intent(getActivity(), UserPetSlot1MatchingActivity.class);
    startActivity(intent);

    }
}


