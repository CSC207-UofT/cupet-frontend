package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.abstracts.IEditUserProfilePresenter;
import com.example.cupetfrontend.presenters.user.EditUserProfilePresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditPetViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUploadImageViewModel;
import com.example.cupetfrontend.ui.contact_info_fragment.ContactInfoViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IContactInfoViewModel;
import com.example.cupetfrontend.ui.edit_pet.EditPetViewModel;
import com.example.cupetfrontend.ui.edit_user_profile.EditUserProfileViewModel;
import com.example.cupetfrontend.ui.upload_image_fragment.UploadImageViewModel;
import com.example.cupetfrontend.use_cases.pet.EditPet;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ControllersModule.class})
public class ViewModelsModule {
    @Singleton
    @Provides
    public IContactInfoViewModel provideContactInfoViewModel(){
        return new ContactInfoViewModel();
    }

    @Singleton
    @Provides
    public IEditUserProfileViewModel provideEditUserProfileViewModel(
            IUserController userController){
        return new EditUserProfileViewModel(userController);
    }

    @Singleton
    @Provides
    public IUploadImageViewModel provideUploadImageViewModel(){
        return new UploadImageViewModel();
    }

    @Singleton
    @Provides
    public IEditPetViewModel provideEditPetViewModel(IPetController petController,
                                                     ISessionManager sessionManager,
                                                     IPetSessionManager petSessionManager){
        return new EditPetViewModel(petController, sessionManager, petSessionManager);
    }
}
