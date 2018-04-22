package com.jsksolutions.features.detail;

import com.jsksolutions.data.model.response.Pokemon;
import com.jsksolutions.data.model.response.Statistic;
import com.jsksolutions.features.base.MvpView;

public interface DetailMvpView extends MvpView {

    void showPokemon(Pokemon pokemon);

    void showStat(Statistic statistic);

    void showProgress(boolean show);

    void showError(Throwable error);
}
