package com.usesoft.gwt.multiactivities.client.infrastructure.injection;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.usesoft.gwt.multiactivities.client.logic.activity.NorthActivityForPlace1;
import com.usesoft.gwt.multiactivities.client.logic.activity.WestSingletonActivity;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.NorthPlaceToActivityVisitor;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.WestPlaceToActivityVisitor;
import com.usesoft.gwt.multiactivities.client.logic.presenter.RootPresenter;
import com.usesoft.gwt.multiactivities.client.view.north.NorthView1;
import com.usesoft.gwt.multiactivities.client.view.north.NothView1Impl;
import com.usesoft.gwt.multiactivities.client.view.region.RegionContainer;
import com.usesoft.gwt.multiactivities.client.view.region.SimpleLayoutPanelRegionContainer;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootViewImpl;
import com.usesoft.gwt.multiactivities.client.view.west.WestView;
import com.usesoft.gwt.multiactivities.client.view.west.WestViewImpl;

public class MyModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        // Views
        bind(RootView.class).to(RootViewImpl.class).in(Singleton.class);
        bind(RegionContainer.class).to(SimpleLayoutPanelRegionContainer.class);

        bind(NorthView1.class).to(NothView1Impl.class);
        bind(WestView.class).to(WestViewImpl.class);

        // Presenters
        bind(RootView.Presenter.class).to(RootPresenter.class).in(Singleton.class);

        bind(AppPlaceHistoryMapper.class);
        bind(PlaceControllerHolder.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class);

        bind(NorthPlaceToActivityVisitor.class);
        bind(NorthActivityForPlace1.class);

        bind(WestPlaceToActivityVisitor.class);
        // Make this activity a singleton to always use the same activity in west region
        bind(WestSingletonActivity.class).in(Singleton.class);
    }

}
