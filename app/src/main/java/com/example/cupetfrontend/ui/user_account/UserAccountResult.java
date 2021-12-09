package com.example.cupetfrontend.ui.user_account;

import com.example.cupetfrontend.presenters.data_models.UserAccountData;

public class UserAccountResult {
    private final boolean isError;
    private final String errorMessage;
    private UserAccountData accountData;

    public UserAccountResult(boolean isError, String errorMessage){
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    /**
     * Construct a successful UserAccountResult
     * @param accountData The user's account data
     */
    public UserAccountResult(UserAccountData accountData){
        this.isError = false;
        this.errorMessage = null;
        this.accountData = accountData;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public UserAccountData getAccountData() {
        return accountData;
    }
}
