package com.wzt.draggerstudy.view;

import com.wzt.draggerstudy.MainActivity;

import dagger.Component;

@Component(modules = ViewModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
