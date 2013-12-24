package com.usesoft.gwt.multiactivities.client.view.rootlayout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RootViewImpl extends Composite
{
    private static RootViewUiBinder uiBinder = GWT.create(RootViewUiBinder.class);

    @UiTemplate("RootView.ui.xml")
    interface RootViewUiBinder extends UiBinder<Widget, RootViewImpl>
    {
    }

    public RootViewImpl()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
