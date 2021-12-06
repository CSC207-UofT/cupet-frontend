package com.example.cupetfrontend.ui.contact_info_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.databinding.FragmentPublicContactinfoBinding;
import com.example.cupetfrontend.presenters.view_model_abstracts.IContactInfoViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.data_models.ContactInfoData;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

public class ContactInfoFragment extends MainActivityFragment {
    private FragmentPublicContactinfoBinding binding;

    @Inject
    public IContactInfoViewModel contactInfoViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentPublicContactinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getApplicationContext().getAppComponent().inject(this);

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

    private void showOwnerSpecificInfo(){
        binding.pubContactinfoProfileImg.setVisibility(View.VISIBLE);
        binding.pubContactinfoTitle.setText(R.string.public_contactinfo_title);
    }

    private void hideOwnerSpecificInfo() {
        binding.pubContactinfoProfileImg.setVisibility(View.GONE);
        binding.pubContactinfoTitle.setText(R.string.contactinfo_title_non_pet);
    }


    private void loadContactInfo (ContactInfoData contactInfoData) {
        hideAllInfo();

        binding.pubContactinfoEmail.setText(contactInfoData.getEmail());
        showEmailInfo();

        if (contactInfoViewModel.getContext() != null &&
                contactInfoViewModel.getContext().isFromPetProfile()){
            showOwnerSpecificInfo();
        }else{
            hideOwnerSpecificInfo();
        }

        if (!contactInfoData.getPhoneNumber().equals("")){
            String phoneNumber = contactInfoData.getPhoneNumber();

            binding.pubContactinfoPhone.setText(phoneNumber);
            showPhoneInfo();
        }

        if (!contactInfoData.getFacebook().equals("")){
            String phoneNumber = contactInfoData.getFacebook();

            binding.pubContactinfoFacebook.setText(phoneNumber);
            showFacebookInfo();
        }

        if (!contactInfoData.getInstagram().equals("")){
            String phoneNumber = contactInfoData.getInstagram();

            binding.pubContactinfoInstagram.setText(phoneNumber);
            showInstagramInfo();
        }

        String profileImgUrl = contactInfoData.getProfileImgUrl();

        if (profileImgUrl != null && !profileImgUrl.equals("")) {
            Glide.with(this).load(
                    profileImgUrl).into(binding.pubContactinfoProfileImg);
        }
    }
}
