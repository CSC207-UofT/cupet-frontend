package com.example.cupetfrontend.ui.login;

import androidx.annotation.Nullable;

/**
 * Registration result : success (user details) or error message.
 */

public class RegisterResult {

    @Nullable
    private LoggedInUserView success; // do I need to create a registered user view or is it the same as logged in?
    @Nullable
    private Integer error;

    RegisterResult(@Nullable Integer error) {
        this.error = error;
    }

    RegisterResult(@Nullable LoggedInUserView success) {
        this.success = success;
    }

    @Nullable
    LoggedInUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}
