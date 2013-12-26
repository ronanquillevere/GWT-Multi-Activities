package com.usesoft.gwt.multiactivities.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.usesoft.gwt.multiactivities.client.infrastructure.injection.MyGinjector;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;

public class Multiactivities implements EntryPoint {

    private final MyGinjector injector = GWT.create(MyGinjector.class);

    @Override
    public void onModuleLoad() {

        RootView.Presenter rootPresenter = injector.getRootPresenter();

        RootLayoutPanel.get().add(rootPresenter.getView().asWidget());
    }
}
