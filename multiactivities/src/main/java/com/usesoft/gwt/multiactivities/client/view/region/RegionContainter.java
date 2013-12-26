package com.usesoft.gwt.multiactivities.client.view.region;

import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public interface RegionContainter extends HasOneWidget, IsWidget
{
    void setVisible(boolean visibility);

    void setStyleName(String style);
}
