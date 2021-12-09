package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.EditUserAccountContext;
import com.example.cupetfrontend.ui.edit_account.EditUserAccountFormData;
import com.example.cupetfrontend.ui.edit_account.EditUserAccountResult;
import com.example.cupetfrontend.ui.edit_account.EditUserAccountFormState;

import androidx.lifecycle.LiveData;

public interface IEditUserAccountViewModel {
    LiveData<EditUserAccountFormState> getFormState();

    LiveData<EditUserAccountResult> getEditUserAccountResult();

    void editUserAccount(EditUserAccountFormData formData, String token);

    void updateFormState(EditUserAccountFormData formData);

    /**
     * This method is called when the edit user account request was successful.
     */
    void onEditUserAccountSuccess();

    /**
     * This method is called when the edit user account request failed.
     *
     * @param message The error message from the response
     */
    void onEditUserAccountFailure(String message);

    EditUserAccountContext getContext();

    void setContext(EditUserAccountContext context);

    void clearState();
}
