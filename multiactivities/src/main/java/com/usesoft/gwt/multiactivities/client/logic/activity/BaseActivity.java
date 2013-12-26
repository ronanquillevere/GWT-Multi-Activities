package com.usesoft.gwt.multiactivities.client.logic.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public abstract class BaseActivity<T extends IsWidget> implements Activity
{
    @Inject
    T view;

    private EventBus eventBus;

    @Override
    public String mayStop()
    {
        return null;
    }

    @Override
    public void onCancel()
    {
    }

    public T getView(){
        return view;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        this.eventBus = eventBus;
        onStart(panel);
    }

    public abstract void onStart(AcceptsOneWidget panel);

    public EventBus getEventBus()
    {
        return eventBus;
    }
}
