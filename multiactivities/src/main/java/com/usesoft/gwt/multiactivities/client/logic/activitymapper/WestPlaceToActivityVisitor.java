package com.usesoft.gwt.multiactivities.client.logic.activitymapper;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.activity.shared.Activity;
import com.usesoft.gwt.multiactivities.client.logic.activity.WestSingletonActivity;
import com.usesoft.gwt.multiactivities.client.logic.place.Place1;
import com.usesoft.gwt.multiactivities.client.logic.place.Place2;
import com.usesoft.gwt.multiactivities.client.logic.place.PlaceVisitor;

public class WestPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    Provider<WestSingletonActivity> provider1;

    @Override
    public Activity visit(Place1 place1, Void in)
    {
        return provider1.get();
    }

    @Override
    public Activity visit(Place2 place2, Void in)
    {
        return provider1.get();
    }

}
