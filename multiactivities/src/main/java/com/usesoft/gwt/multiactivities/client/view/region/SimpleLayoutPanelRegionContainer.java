package com.usesoft.gwt.multiactivities.client.view.region;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;

public class SimpleLayoutPanelRegionContainer extends SimpleLayoutPanel implements RegionContainer
{
    private RootView rootView;
    private Region region;

    @Override
    public void setWidget(IsWidget w)
    {
        // TODO use a presenter not a view this is logic !!!
        if (w == null)
            rootView.setRegionVisibility(region, false);
        else
            rootView.setRegionVisibility(region, true);
        super.setWidget(w);
    }

    @Override
    public void setRootView(RootView rootView)
    {
        this.rootView = rootView;
    }

    @Override
    public RootView getRootView()
    {
        return rootView;
    }

    @Override
    public void setRegionw(Region region)
    {
        this.region = region;
    }

    @Override
    public Region getRegion()
    {
        return region;
    }
}
