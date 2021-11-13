package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APICreatePetRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIEditPetRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.EditPetInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.EditPetOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.EditPetRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.PetCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.EditPetFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.EditPetSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class EditPet implements EditPetInputBoundary {
    IPetAPIGateway petAPIGateway;
    EditPetOutputBoundary outputBoundary;

    public EditPet(IPetAPIGateway petAPIGateway, EditPetOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void editPet(EditPetRequestModel request) {
        APIEditPetRequestModel apiRequest = new APIEditPetRequestModel(
                request.getToken(), request.getNewName(), request.getNewAge(),
                request.getNewBreed(), request.getNewBiography()
        );

        petAPIGateway.editPet(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onEditPetSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onEditPetFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * EditPetSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a EditPetSuccessResponseModel
     */
    private EditPetSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
//        try {
            return new EditPetSuccessResponseModel();
//        } catch (JSONException e) {
//            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
//        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * EditPetFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a EditPetFailResponseModel
     */
    private EditPetFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new EditPetFailResponseModel("Sample Error Message");
    }
}