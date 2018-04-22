package com.jsksolutions.injection.component;

import dagger.Subcomponent;
import com.jsksolutions.injection.PerFragment;
import com.jsksolutions.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}
