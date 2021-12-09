package com.example.cupetfrontend.ui.form_validators;

/**
 * A class representing the state of a field in a form.
 */
public class FormFieldState {
    private final String errorMessage;
    private boolean hasFieldBeenTouched;

    public FormFieldState(FormFieldState oldFormFieldState, String errorMessage) {
        this.errorMessage = errorMessage;
        hasFieldBeenTouched = oldFormFieldState.hasFieldBeenTouched;
    }

    public FormFieldState() {
        errorMessage = null;
        hasFieldBeenTouched = false;
    }

    /**
     * Return the error message of the form field,
     * provided it is in an error state. Otherwise, return null
     */
    public String getErrorMessage() {
        if (isError()){
            return errorMessage;
        }else{
            return null;
        }
    }

    /**
     * Return whether the field is in an error state.
     */
    public boolean isError () {
        if (hasFieldBeenTouched){
            return errorMessage != null;
        }else{
            return false;
        }
    }

    /**
     * A method that should be called when the field changes.
     */
    public void onFieldInteracted() {
        hasFieldBeenTouched = true;
    }
}
