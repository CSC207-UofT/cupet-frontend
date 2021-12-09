package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.ICreatePetViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditPetViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserAccountViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IMatchedPetProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUploadImageViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IViewMyPetsViewModel;
import com.example.cupetfrontend.ui.contact_info_fragment.ContactInfoViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IContactInfoViewModel;
import com.example.cupetfrontend.ui.create_pet.CreatePetViewModel;
import com.example.cupetfrontend.ui.edit_account.EditUserAccountViewModel;
import com.example.cupetfrontend.ui.edit_pet.EditPetViewModel;
import com.example.cupetfrontend.ui.edit_user_profile.EditUserProfileViewModel;
import com.example.cupetfrontend.ui.matched_pet_profile.MatchedPetProfileViewModel;
import com.example.cupetfrontend.ui.upload_image_fragment.UploadImageViewModel;
import com.example.cupetfrontend.ui.view_my_pets.ViewMyPetsViewModel;

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

    @Singleton
    @Provides
    public IViewMyPetsViewModel provideViewMyPetsViewModel(IUserController userController){
        return new ViewMyPetsViewModel(userController);
    }

    @Singleton
    @Provides
    public ICreatePetViewModel provideCreatePetViewModel(IPetController petController){
        return new CreatePetViewModel(petController);
    }

    @Singleton
    @Provides
    public IEditUserAccountViewModel provideEditUserAccountViewModel(IUserController userController){
        return new EditUserAccountViewModel(userController);
    }

    @Singleton
    @Provides
    public IMatchedPetProfileViewModel provideMatchedPetProfileViewModel(IUserController userController){
        return new MatchedPetProfileViewModel(userController);
    }
}
