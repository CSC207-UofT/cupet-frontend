package com.example.cupetfrontend.ui.contact_info_fragment;

import com.example.cupetfrontend.presenters.view_model_abstracts.IContactInfoViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.data_models.ContactInfoData;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.ContactInfoContext;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ContactInfoViewModel implements IContactInfoViewModel {
    private final MutableLiveData<ContactInfoData> contactInfoData = new MutableLiveData<>();
    private ContactInfoContext context;

    @Override
    public LiveData<ContactInfoData> getContactInfoData() {
        return contactInfoData;
    }

    @Override
    public void setContactInfoData(String email, String phoneNumber,
                                   String facebook, String instagram, String profileImgUrl) {
        contactInfoData.setValue(new ContactInfoData(
                email, phoneNumber, facebook, instagram, profileImgUrl));
    }

    @Override
    public void setContext(ContactInfoContext context) {
        this.context = context;
    }

    @Override
    public ContactInfoContext getContext() {
        return context;
    }
}
