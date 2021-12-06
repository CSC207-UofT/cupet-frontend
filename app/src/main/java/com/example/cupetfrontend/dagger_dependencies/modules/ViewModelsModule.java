package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.ui.contact_info_fragment.ContactInfoViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IContactInfoViewModel;

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
}
