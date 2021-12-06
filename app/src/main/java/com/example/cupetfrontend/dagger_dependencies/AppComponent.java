package com.example.cupetfrontend.dagger_dependencies;

import com.example.cupetfrontend.dagger_dependencies.modules.ControllersModule;
import com.example.cupetfrontend.dagger_dependencies.modules.ViewModelsModule;
import com.example.cupetfrontend.ui.edit_pet.EditPetFragment;
import com.example.cupetfrontend.ui.login.LoginActivity;
import com.example.cupetfrontend.ui.login.LoginViewModel;
import com.example.cupetfrontend.ui.my_pet_profile.PetProfileFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The main Dagger component for the application.
 */
@Singleton
@Component(modules = {ControllersModule.class, ViewModelsModule.class})
public interface AppComponent {
    void inject(LoginViewModel loginViewModel);
    void inject(LoginActivity loginActivity);
    void inject(EditPetFragment editPetFragment);
    void inject(PetProfileFragment petProfileFragment);
}
