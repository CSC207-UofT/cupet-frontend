package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.ContactInfoContext;
import com.example.cupetfrontend.presenters.view_model_abstracts.data_models.ContactInfoData;

import androidx.lifecycle.LiveData;

public interface IContactInfoViewModel {
    LiveData<ContactInfoData> getContactInfoData();

    void setContactInfoData(String email, String phoneNumber,
                            String facebook, String instagram, String profileImgUrl);

    void setContext(ContactInfoContext context);

    ContactInfoContext getContext();
}
