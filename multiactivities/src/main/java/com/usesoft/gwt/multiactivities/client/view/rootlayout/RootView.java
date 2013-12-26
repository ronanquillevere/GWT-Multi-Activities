package com.usesoft.gwt.multiactivities.client.view.rootlayout;

import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.gwt.multiactivities.client.view.region.Region;

public interface RootView extends IsWidget
{
    void setRegionVisibility(Region region, boolean visible);

    interface Presenter extends com.usesoft.gwt.multiactivities.client.presenter.Presenter<RootView>
    {

    }
}
