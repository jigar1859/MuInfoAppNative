package com.jsksolutions;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jsksolutions.common.TestDataFactory;
import com.jsksolutions.data.DataManager;
import com.jsksolutions.data.model.response.Pokemon;
import com.jsksolutions.features.detail.DetailMvpView;
import com.jsksolutions.features.detail.DetailPresenter;
import com.jsksolutions.util.RxSchedulersOverrideRule;
import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ravindra on 24/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class DetailPresenterTest {

    @Rule
    public final RxSchedulersOverrideRule overrideSchedulersRule = new RxSchedulersOverrideRule();

    @Mock
    DetailMvpView mockDetailMvpView;
    @Mock
    DataManager mockDataManager;
    private DetailPresenter detailPresenter;

    @Before
    public void setUp() {
        detailPresenter = new DetailPresenter(mockDataManager);
        detailPresenter.attachView(mockDetailMvpView);
    }

    @After
    public void tearDown() {
        detailPresenter.detachView();
    }

    @Test
    public void getPokemonDetailReturnsPokemon() {
        Pokemon pokemon = TestDataFactory.makePokemon("id");
        when(mockDataManager.getPokemon(anyString())).thenReturn(Single.just(pokemon));

        detailPresenter.getPokemon(anyString());

        verify(mockDetailMvpView, times(2)).showProgress(anyBoolean());
        verify(mockDetailMvpView).showPokemon(pokemon);
        verify(mockDetailMvpView, never()).showError(any(Throwable.class));
    }

    @Test
    public void getPokemonDetailReturnsError() {
        when(mockDataManager.getPokemon("id")).thenReturn(Single.error(new RuntimeException()));

        detailPresenter.getPokemon("id");

        verify(mockDetailMvpView, times(2)).showProgress(anyBoolean());
        verify(mockDetailMvpView).showError(any(Throwable.class));
        verify(mockDetailMvpView, never()).showPokemon(any(Pokemon.class));
    }
}
