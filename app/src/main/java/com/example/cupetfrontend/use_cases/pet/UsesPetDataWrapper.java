package com.example.cupetfrontend.use_cases.pet;

import com.example.cupetfrontend.use_cases.DefaultFailResponseUseCase;
import com.example.cupetfrontend.use_cases.InvalidAPIResponseException;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPetDataListOutputBoundary;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A superclass for use cases which need to convert
 * pet ids to PetData
 */
public class UsesPetDataWrapper extends DefaultFailResponseUseCase {
    private final IPetAPIGateway petAPIGateway;

    public UsesPetDataWrapper(IPetAPIGateway petAPIGateway) {
        this.petAPIGateway = petAPIGateway;
    }

    /**
     * Convert a JSONObject response containing a list of pet data
     * to a list of pet data.
     *
     * @param token               The token used to make the original request
     * @param jsonResponse        A JSON representation of the response.
     * @param getPetDataListeners Listeners for the success/fail of the conversion
     */
    public void getPetDataList(String token, JSONObject jsonResponse,
                               GetPetDataListOutputBoundary getPetDataListeners) {
        try {
            List<String> petIds = getPetIds(jsonResponse);

            GetPetDataList getPetDataList = new GetPetDataList(token, petAPIGateway, getPetDataListeners);
            getPetDataList.getPetDataList(petIds);

        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful fetch pet data response.");
        }
    }

    /**
     * Given a successful jsonResponse, return the list of pet ids
     * contained inside the json object.
     *
     * @param jsonResponse the response as a JSONObject
     * @return A list of pet ids
     * @throws JSONException An exception if the JSON response is formatted incorrectly
     */
    private List<String> getPetIds(JSONObject jsonResponse) throws JSONException {
        JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));
        JSONArray petIdsJSON = dataObj.getJSONArray("petIds");
        List<String> petIds = new ArrayList<>();

        for (int i = 0; i < petIdsJSON.length(); i++) {
            petIds.add(petIdsJSON.getString(i));
        }
        return petIds;
    }
}
