package com.example.cupetfrontend.dagger_dependencies;

import com.example.cupetfrontend.dagger_dependencies.modules.ControllersModule;
import com.example.cupetfrontend.dagger_dependencies.modules.PetPresentersModule;
import com.example.cupetfrontend.dagger_dependencies.modules.UserPresentersModule;
import com.example.cupetfrontend.dagger_dependencies.modules.ViewModelsModule;
import com.example.cupetfrontend.ui.MainActivity;
import com.example.cupetfrontend.ui.contact_info_fragment.ContactInfoFragment;
import com.example.cupetfrontend.ui.create_pet.CreatePetFragment;
import com.example.cupetfrontend.ui.edit_account.EditUserAccountFragment;
import com.example.cupetfrontend.ui.edit_pet.EditPetFragment;
import com.example.cupetfrontend.ui.edit_user_profile.EditUserProfileFragment;
import com.example.cupetfrontend.ui.get_matches.GetMatchesFragment;
import com.example.cupetfrontend.ui.login.LoginActivity;
import com.example.cupetfrontend.ui.my_pet_profile.PetProfileFragment;
import com.example.cupetfrontend.ui.potential_matches.PotentialMatchesFragment;
import com.example.cupetfrontend.ui.register.RegisterActivity;
import com.example.cupetfrontend.ui.upload_image_fragment.UploadImageFragment;
import com.example.cupetfrontend.ui.user_profile.UserProfileFragment;
import com.example.cupetfrontend.ui.view_my_pets.ViewMyPetsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The main Dagger component for the application.
 */
@Singleton
@Component(modules = {ControllersModule.class, ViewModelsModule.class,
        UserPresentersModule.class, PetPresentersModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
    void inject(EditPetFragment editPetFragment);
    void inject(PetProfileFragment petProfileFragment);
    void inject(PotentialMatchesFragment potentialMatchesFragment);
    void inject(ViewMyPetsFragment viewMyPetsFragment);
    void inject(GetMatchesFragment getMatchesFragment);
    void inject(CreatePetFragment createPetFragment);
    void inject(EditUserProfileFragment editUserProfileFragment);
    void inject(UserProfileFragment userProfileFragment);
    void inject(EditUserAccountFragment editUserAccountFragment);
    void inject(ContactInfoFragment contactInfoFragment);
    void inject(UploadImageFragment uploadImageFragment);
}
