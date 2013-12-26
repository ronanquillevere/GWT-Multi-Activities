package com.usesoft.gwt.multiactivities.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.usesoft.gwt.multiactivities.client.infrastructure.injection.MyGinjector;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.gwt.multiactivities.client.logic.place.Place1;
import com.usesoft.gwt.multiactivities.client.view.region.Region;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;

public class Multiactivities implements EntryPoint {

    private final MyGinjector injector = GWT.create(MyGinjector.class);

    @Override
    public void onModuleLoad() {

        RootView.Presenter rootPresenter = injector.getRootPresenter();


        EventBus eventBus = injector.getEventBus();

        ActivityManager northActivityManager = new ActivityManager(injector.getNorthActivityMapper(), eventBus);
        northActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.North));


        PlaceController placeController = new PlaceController(eventBus);

        AppPlaceHistoryMapper historyMapper= injector.getAppPlaceHistoryMapper();
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, new Place1("test"));

        RootLayoutPanel.get().add(rootPresenter.getView().asWidget());
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();
    }
}
