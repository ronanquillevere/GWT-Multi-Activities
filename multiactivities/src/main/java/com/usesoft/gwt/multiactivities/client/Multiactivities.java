package com.usesoft.gwt.multiactivities.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.usesoft.gwt.multiactivities.client.infrastructure.injection.MyGinjector;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.gwt.multiactivities.client.logic.place.Place1;
import com.usesoft.gwt.multiactivities.client.view.region.Region;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;

public class Multiactivities implements EntryPoint {

    private final MyGinjector injector = GWT.create(MyGinjector.class);

    @Override
    public void onModuleLoad() {

        RootView.Presenter rootPresenter = injector.getRootPresenter();

        PlaceControllerHolder placeControllerHolder = injector.getPlaceControllerHolder();

        // Initialize a manager per region
        ActivityManager northActivityManager = new ActivityManager(injector.getNorthActivityMapper(), placeControllerHolder.getEventBus());
        northActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.North));

        ActivityManager westActivityManager = new ActivityManager(injector.getWestActivityMapper(), placeControllerHolder.getEventBus());
        westActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.West));

        // Do the same for center, south ...


        AppPlaceHistoryMapper historyMapper= injector.getAppPlaceHistoryMapper();
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeControllerHolder.getPlaceController(), placeControllerHolder.getEventBus(), new Place1("test"));

        RootLayoutPanel.get().add(rootPresenter.getView().asWidget());

        // Activate navigation history and go to default place
        historyHandler.handleCurrentHistory();
    }
}
