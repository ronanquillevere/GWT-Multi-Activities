package com.usesoft.gwt.multiactivities.client.view.west;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class WestViewImpl extends Composite implements WestView
{
    private Presenter presenter;

    @Inject
    public WestViewImpl(WestViewUiBinder binder)
    {
        initWidget(binder.createAndBindUi(this));
    }

    @UiTemplate("WestView.ui.xml")
    interface WestViewUiBinder extends UiBinder<Widget, WestViewImpl>
    {

    }

    @UiHandler("place1Button")
    void click1(ClickEvent event)
    {
        presenter.navigateToPlace1();
    }

    @UiHandler("place2Button")
    void click2(ClickEvent event)
    {
        presenter.navigateToPlace2();
    }

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

}
