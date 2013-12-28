package com.usesoft.gwt.multiactivities.client.logic.activitymapper;

import javax.inject.Inject;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

//Singleton that hold the placeController to be able to use it easily in activities by injecting it
public class PlaceControllerHolder
{
    private final PlaceController placeController;
    private EventBus eventBus;

    @Inject
    public PlaceControllerHolder(EventBus eventBus)
    {
        this.eventBus = eventBus;
        this.placeController = new PlaceController(eventBus);
    }

    public PlaceController getPlaceController()
    {
        return placeController;
    }

    public EventBus getEventBus()
    {
        return eventBus;
    }
}
