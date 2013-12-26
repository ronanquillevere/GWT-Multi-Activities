package com.usesoft.gwt.multiactivities.client.logic.presenter;

import com.google.web.bindery.event.shared.EventBus;

public interface Presenter<T>
{
    void start(EventBus eventBus);

    void stop();

    T getView();
}
