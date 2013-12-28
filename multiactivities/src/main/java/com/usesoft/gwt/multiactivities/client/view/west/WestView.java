package com.usesoft.gwt.multiactivities.client.view.west;

import com.google.gwt.user.client.ui.IsWidget;

public interface WestView extends IsWidget
{
    void setPresenter(Presenter presenter);

    interface Presenter
    {
        void navigateToPlace1();

        void navigateToPlace2();
    }
}
