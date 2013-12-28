package com.usesoft.gwt.multiactivities.client.infrastructure.injection;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.NorthActivityMapper;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.WestActivityMapper;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;

@GinModules(MyModule.class)
public interface MyGinjector extends Ginjector
{
    RootView.Presenter getRootPresenter();

    PlaceControllerHolder getPlaceControllerHolder();

    AppPlaceHistoryMapper getAppPlaceHistoryMapper();

    NorthActivityMapper getNorthActivityMapper();

    WestActivityMapper getWestActivityMapper();
}
