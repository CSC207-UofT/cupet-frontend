package com.example.cupetfrontend.ui.public_pet_profile.contact_info_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.cupetfrontend.databinding.FragmentPublicContactinfoBinding;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

public class ContactInfoFragment extends Fragment {
    private FragmentPublicContactinfoBinding binding;
    private ContactInfoViewModel contactInfoViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentPublicContactinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initializeViewModel();

        hideAllInfo();
        initializeContactInfoObserver();

        return root;
    }

    private void initializeContactInfoObserver() {
        contactInfoViewModel.getContactInfoData().observe(getViewLifecycleOwner(), new Observer<ContactInfoData>() {
            @Override
            public void onChanged(ContactInfoData contactInfoData) {
                loadContactInfo(contactInfoData);
            }
        });
    }

    private void hideAllInfo(){
        binding.pubContactinfoPhoneLayout.setVisibility(View.GONE);
        binding.pubContactinfoEmailLayout.setVisibility(View.GONE);
        binding.pubContactinfoFacebookLayout.setVisibility(View.GONE);
        binding.pubContactinfoInstagramLayout.setVisibility(View.GONE);
    }

    private void showEmailInfo() {
        binding.pubContactinfoEmailLayout.setVisibility(View.VISIBLE);
    }

    private void showPhoneInfo(){
        binding.pubContactinfoPhoneLayout.setVisibility(View.VISIBLE);
    }

    private void showFacebookInfo(){
        binding.pubContactinfoFacebookLayout.setVisibility(View.VISIBLE);
    }

    private void showInstagramInfo(){
        binding.pubContactinfoInstagramLayout.setVisibility(View.VISIBLE);
    }


    private void loadContactInfo (ContactInfoData contactInfoData) {
        hideAllInfo();

        binding.pubContactinfoEmail.setText(contactInfoData.getEmail());
        showEmailInfo();

        if (!contactInfoData.getPhoneNumber().equals("")){
            String phoneNumber = contactInfoData.getPhoneNumber();

            binding.pubContactinfoPhone.setText(phoneNumber);
        }else{
            showPhoneInfo();
        }

        if (!contactInfoData.getFacebook().equals("")){
            String phoneNumber = contactInfoData.getFacebook();

            binding.pubContactinfoFacebook.setText(phoneNumber);
        }else{
            showFacebookInfo();
        }

        if (!contactInfoData.getInstagram().equals("")){
            String phoneNumber = contactInfoData.getInstagram();

            binding.pubContactinfoInstagram.setText(phoneNumber);
        }else{
            showInstagramInfo();
        }

        Glide.with(this).load(
                contactInfoData.getProfileImgUrl()).into(binding.pubContactinfoProfileImg);
    }

    private void initializeViewModel() {
        contactInfoViewModel = new ContactInfoViewModel();
    }
}
