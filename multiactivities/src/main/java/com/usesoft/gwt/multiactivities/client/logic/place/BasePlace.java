package com.usesoft.gwt.multiactivities.client.logic.place;

import com.google.gwt.place.shared.Place;


public abstract class BasePlace extends Place
{
    public abstract <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in);
}
