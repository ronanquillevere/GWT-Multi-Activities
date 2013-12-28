package com.usesoft.gwt.multiactivities.client.logic.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.usesoft.gwt.multiactivities.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.gwt.multiactivities.client.logic.place.Place1;
import com.usesoft.gwt.multiactivities.client.logic.place.Place2;
import com.usesoft.gwt.multiactivities.client.view.west.WestView;

public class WestSingletonActivity extends BaseActivity<WestView> implements Activity, WestView.Presenter
{
    @Inject
    PlaceControllerHolder placeControllerHolder;

    @Override
    public void onStop()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(AcceptsOneWidget panel)
    {
        panel.setWidget(getView());
        getView().setPresenter(this);
    }

    @Override
    public void navigateToPlace1()
    {
        placeControllerHolder.getPlaceController().goTo(new Place1("navigated"));
    }

    @Override
    public void navigateToPlace2()
    {
        placeControllerHolder.getPlaceController().goTo(new Place2("navigated"));
    }

}
