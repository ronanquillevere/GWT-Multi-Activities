package com.usesoft.gwt.multiactivities.client.view.rootlayout;

import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.gwt.multiactivities.client.view.region.Region;
import com.usesoft.gwt.multiactivities.client.view.region.RegionContainer;

public interface RootView extends IsWidget
{
    void setRegionVisibility(Region region, boolean visible);

    RegionContainer getRegion(Region region);

    interface Presenter extends com.usesoft.gwt.multiactivities.client.logic.presenter.Presenter<RootView>
    {

    }
}
