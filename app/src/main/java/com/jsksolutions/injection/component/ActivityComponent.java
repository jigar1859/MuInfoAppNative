package com.jsksolutions.injection.component;

import com.jsksolutions.features.detail.DetailActivity;
import com.jsksolutions.features.main.SampleMainActivity;
import com.jsksolutions.injection.PerActivity;
import com.jsksolutions.injection.module.ActivityModule;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SampleMainActivity mainActivity);

    void inject(DetailActivity detailActivity);
}
