package com.example.cupetfrontend.drivers.api.routes;

public class PetRoutesStore extends RoutesStore {
    public static final String CREATE_PET = "/pets/create";
    public static final String FETCH_PET_PROFILE = "/pets/profile";
    public static final String EDIT_PET_PROFILE = "/pets/editprofile";
    public static final String FETCH_PET_SWIPES = "/pets/generatepotentialmatches";
    public static final String FETCH_MATCHES = "/pets/fetchmatches";
    public static final String REJECT_PETS = "/pets/reject";
    public static final String SWIPE_PETS = "/pets/swipe";
    public static final String UN_SWIPE_PETS = "/pets/unswipe";
    public static final String UN_MATCH_PETS = "/pets/unmatch";
    public static final String SET_PET_PROFILE_IMAGE = "/pets/setprofileimage";
    public static final String ADD_TO_PET_IMAGE_GALLERY = "/pets/addimage";
    public static final String REMOVE_FROM_PET_IMAGE_GALLERY = "/pets/removeimage";
    public static final String FETCH_PET_PROFILE_IMAGE = "/pets/fetchprofileimage";
}
