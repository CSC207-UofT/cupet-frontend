package com.example.cupetfrontend.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.RegisterData;

public class RegisterActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    EditText address;
    EditText password;
    EditText password_confirm;
    Button confirm_registerButton;
    boolean is_valid = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = findViewById(R.id.reg_firstName);
        lastName = findViewById(R.id.reg_lastName);
        email = findViewById(R.id.reg_email);
        address = findViewById(R.id.reg_homeAddress);
        password = findViewById(R.id.reg_password);
        password_confirm = findViewById(R.id.reg_password_confirm);
        confirm_registerButton = findViewById(R.id.confirm_register_button);


        confirm_registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // get text from the inputs
                String fName_input = String.valueOf(firstName.getText());
                String lName_input = String.valueOf(lastName.getText());
                String email_input = String.valueOf(email.getText());
                String address_input = String.valueOf(address.getText());
                String password_input = String.valueOf(password.getText());
                String passwordConfirm_input = String.valueOf(password_confirm.getText());



                String errorString = "error:";

                // note: Temporary input validation for Registration form

                is_valid = true;
                // Validate first name

                if (fName_input.isEmpty()){
                    is_valid = false;
                    errorString += " \n First Name should not be empty.";}
                if (fName_input.length() < 2){
                    is_valid = false;
                    errorString += "\n First Name is invalid.";}


                // Validate last name
                if (lName_input.isEmpty()){
                    is_valid = false;
                    errorString +=" \n Last Name should not be empty.";}
                if (lName_input.length() < 2){
                    is_valid = false;
                    errorString += "\n Last Name is invalid.";}


                // Validate email
                if (email_input.isEmpty()){
                    is_valid = false;
                    errorString +=" \n email should not be empty.";}
                if (!email_input.contains("@")){
                    is_valid = false;
                    errorString +=" \n Invalid Email input. - no @";}
                String[] email_address_parts = email_input.split("@");
                if (email_address_parts.length != 2) {
                    is_valid = false;
                    errorString +=" \n Invalid Email input. - not enough parts";}
                if (!email_address_parts[1].contains(".")){
                    is_valid = false;
                    errorString +=" \n Invalid Email input. - no . ";}
                String[] email_domain = email_address_parts[1].split("\\.");
                if (email_domain.length < 2){
                    is_valid = false;
                    errorString +=" \n Invalid Email input. - . ";}


                //Validate Password:
                if (password_input.length() < 5){
                    is_valid = false;
                    errorString += " \n Password must be greater than 5 characters.";
                }
                if (!password_input.equals(passwordConfirm_input)){
                    is_valid = false;
                    errorString += " \n Passwords do not match.";
                }


                // Validate Home Address
                if (address_input.isEmpty()){
                    is_valid = false;
                    errorString += " \n Invalid Home Address";}

                //TODO: Improve Input Validation
                //Split into helper methods, minimize repeated code




                // If at least one field is not valid
                if (!is_valid){
                    Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_LONG).show();
                }

                // If all fields are valid
                else{
//                    RegisterData rd = new RegisterData(fName_input,
//                            lName_input,
//                            email_input,
//                            password_input,
//                            address_input);
//                    String jsonData = rd.toJSON();
//                    Toast.makeText(getApplicationContext(), jsonData, Toast.LENGTH_LONG).show(); //remove
//

                    APICreateUserRequestModel rd = new APICreateUserRequestModel( fName_input, lName_input, address_input, password_input,  email_input);
                    IServerResponseListener rl = new IServerResponseListener();
                    UserAPIGateway ug = new UserAPIGateway();
                    ug.createUser(rd, rl);



                }

            }
        });

    }
}


    // Potentially Create ViewModel for Register

