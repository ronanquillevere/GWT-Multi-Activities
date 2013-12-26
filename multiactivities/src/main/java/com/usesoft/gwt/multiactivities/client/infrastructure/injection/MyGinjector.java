package com.usesoft.gwt.multiactivities.client.infrastructure.injection;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.NorthActivityMapper;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;

@GinModules(MyModule.class)
public interface MyGinjector extends Ginjector
{
    RootView.Presenter getRootPresenter();

    EventBus getEventBus();

    AppPlaceHistoryMapper getAppPlaceHistoryMapper();

    NorthActivityMapper getNorthActivityMapper();
}
