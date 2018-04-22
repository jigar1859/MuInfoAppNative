package com.jsksolutions.features.main;

import java.util.List;

import com.jsksolutions.features.base.MvpView;

public interface MainMvpView extends MvpView {

    void showPokemon(List<String> pokemon);

    void showProgress(boolean show);

    void showError(Throwable error);
}
