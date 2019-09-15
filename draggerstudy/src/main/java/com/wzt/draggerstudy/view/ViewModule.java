package com.wzt.draggerstudy.view;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {
    private final ILoginView loginView;

    public ViewModule(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    public ILoginView provideLoginView() {
        return loginView;
    }
}
