package com.usesoft.gwt.multiactivities.client.infrastructure.injection;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;
import com.usesoft.gwt.multiactivities.client.presenter.RootPresenter;
import com.usesoft.gwt.multiactivities.client.view.region.RegionContainter;
import com.usesoft.gwt.multiactivities.client.view.region.SimpleLayoutPanelRegionContainer;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootViewImpl;

public class MyModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        // Views
        bind(RootView.class).to(RootViewImpl.class).in(Singleton.class);
        bind(RegionContainter.class).to(SimpleLayoutPanelRegionContainer.class);

        // Presenters
        bind(RootView.Presenter.class).to(RootPresenter.class).in(Singleton.class);
    }

}
