package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditPetViewModel;
import com.example.cupetfrontend.ui.edit_pet.EditPetViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ControllersModule.class})
public class ViewModelsModule {
    @Singleton
    @Provides
    public IEditPetViewModel provideEditPetViewModel(IPetController petController) {
        return new EditPetViewModel(petController);
    }
}
