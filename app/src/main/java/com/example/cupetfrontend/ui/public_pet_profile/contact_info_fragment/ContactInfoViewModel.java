package com.example.cupetfrontend.ui.public_pet_profile.contact_info_fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ContactInfoViewModel {
    private MutableLiveData<ContactInfoData> contactInfoData;

    public LiveData<ContactInfoData> getContactInfoData() {
        return contactInfoData;
    }

    public void setContactInfoData(String email, String phoneNumber,
                                   String facebook, String instagram, String profileImgUrl) {
        contactInfoData.setValue(new ContactInfoData(
                email, phoneNumber, facebook, instagram, profileImgUrl));
    }
}
