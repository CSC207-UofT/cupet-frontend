package com.example.cupetfrontend.drivers.api;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.volley.*;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * A JsonObjectRequest class with the ability to attach headers
 * to the request.
 */
class JSONRequestWithHeaders extends JsonObjectRequest {
    Map<String, String> headers;


    public JSONRequestWithHeaders(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public Map<String, String> getHeaders() {
        // Overwrite the headers used in the request
        return headers;
    }
}


/**
 * A class responsible for making HTTP requests.
 */
public class HTTPRequestManager implements IServerRequestManager {
    private final RequestQueue requestQueue;

    /**
     * Construct a new instance of HTTPRequestManager
     * 
     * @param context An Android context (activity, application, etc.)
     */
    public HTTPRequestManager(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    /**
     * Construct a new instance of HTTPRequestManager
     *
     * @param requestQueue A volley request queue
     */
    public HTTPRequestManager(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    /**
     * Make an HTTP request with a JSON body that expects a JSON
     * response.
     *
     * @param method An integer representing the method of request (GET, POST, etc.)
     *               See volley.Request.method
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param listener An object that listens to the server response
     */
    private void makeJSONRequest(int method, String url, JSONObject requestBody,
                                 IServerResponseListener listener) {
        JSONRequestWithHeaders request = makeJSONRequestNoHeaders(method, url, requestBody, listener);
        request.setHeaders(new HashMap<>());

        requestQueue.add(request);
    }

    /**
     * Make an HTTP request with a JSON body that expects a JSON
     * response.
     *
     * @param method An integer representing the method of request (GET, POST, etc.)
     *               See volley.Request.method
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param headers The headers for the HTTP request
     * @param listener An object that listens to the server response
     */
    private void makeJSONRequest(int method, String url, JSONObject requestBody,
                                 Map<String, String> headers, IServerResponseListener listener) {
        JSONRequestWithHeaders request = makeJSONRequestNoHeaders(method, url, requestBody, listener);
        request.setHeaders(headers);

        requestQueue.add(request);
    }

    /**
     * Make an HTTP request with a JSON body that expects a JSON
     * response. The HTTP request has an empty header.
     *
     * @param method An integer representing the method of request (GET, POST, etc.)
     *               See volley.Request.method
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param listener An object that listens to the server response
     */
    private JSONRequestWithHeaders makeJSONRequestNoHeaders(int method, String url, JSONObject requestBody,
                                                            IServerResponseListener listener) {
        return new JSONRequestWithHeaders(method, url, requestBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        listener.onRequestSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                JSONObject response = getErrorJsonResponse(error);

                listener.onRequestError(response);
            }
        });
    }

    /**
     * Return a JSONObject representation of an error response.
     *
     * @param error The error response.
     * @return A JSONObject representation of the error response
     */
    private JSONObject getErrorJsonResponse(VolleyError error) {
        JSONObject response;

        if (error.networkResponse == null){
            response = new JSONObject(new HashMap<String, String>() {{
                put("message", error.getMessage());
            }});

        }else{
            try {
                String responseJSON = new String(error.networkResponse.data,
                        HttpHeaderParser.parseCharset(error.networkResponse.headers));

                response = new JSONObject(responseJSON);
            } catch (UnsupportedEncodingException | JSONException e) {
                // In this case, we are unable to decode the body of the response
                // We instead send a default response JSON instead.

                String defaultMessage = "Unable to decode response body";
                Map<String, String> responseMap = new HashMap<>();
                responseMap.put("message", defaultMessage);

                response = new JSONObject(responseMap);
            }
        }
        return response;
    }

    /**
     * Make an HTTP GET request with a JSON body that expects a JSON
     * response.
     *
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param listener An object that listens to the server response
     */
    @Override
    public void makeGetRequest(String url, JSONObject requestBody, IServerResponseListener listener) {
        makeJSONRequest(Request.Method.GET, url, requestBody, listener);
    }

    /**
     * Make an HTTP GET request with a JSON body that expects a JSON
     * response.
     *
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param headers The headers of the HTTP request
     * @param listener An object that listens to the server response
     */
    @Override
    public void makeGetRequest(String url, JSONObject requestBody,
                               Map<String, String> headers, IServerResponseListener listener) {
        makeJSONRequest(Request.Method.GET, url, requestBody, headers, listener);
    }

    /**
     * Make an HTTP POST request with a JSON body that expects a JSON
     * response.
     *
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param listener An object that listens to the server response
     */
    @Override
    public void makePostRequest(String url, JSONObject requestBody, IServerResponseListener listener) {
        makeJSONRequest(Request.Method.POST, url, requestBody, listener);
    }

    /**
     * Make an HTTP POST request with a JSON body that expects a JSON
     * response.
     *
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param headers The headers of the HTTP request
     * @param listener An object that listens to the server response
     */
    @Override
    public void makePostRequest(String url, JSONObject requestBody,
                               Map<String, String> headers, IServerResponseListener listener) {
        makeJSONRequest(Request.Method.POST, url, requestBody, headers, listener);
    }
}
