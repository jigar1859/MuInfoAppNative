package com.jsksolutions.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import com.jsksolutions.common.injection.module.ApplicationTestModule;
import com.jsksolutions.injection.component.AppComponent;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends AppComponent {
}
