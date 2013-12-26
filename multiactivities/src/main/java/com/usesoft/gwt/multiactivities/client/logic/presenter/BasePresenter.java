package com.usesoft.gwt.multiactivities.client.logic.presenter;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;

public abstract class BasePresenter<T> implements Presenter<T>
{
    private EventBus eventBus;

    @Inject
    T view;

    @Override
    public final void start(EventBus eventBus)
    {
        this.eventBus = eventBus;
        onStart();
    }

    @Override
    public final void stop()
    {
        onStop();
    }

    abstract void onStart();

    abstract void onStop();

    protected EventBus getEventBus()
    {
        return eventBus;
    }

    @Override
    public T getView()
    {
        return view;
    }
}
