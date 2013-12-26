package com.usesoft.gwt.multiactivities.client.view.region;

import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.gwt.multiactivities.client.view.rootlayout.RootView;

public interface RegionContainer extends HasOneWidget, IsWidget
{
    void setVisible(boolean visibility);

    void setStyleName(String style);

    RootView getRootView();

    void setRootView(RootView rootView);

    void setRegionw(Region region);

    Region getRegion();
}
