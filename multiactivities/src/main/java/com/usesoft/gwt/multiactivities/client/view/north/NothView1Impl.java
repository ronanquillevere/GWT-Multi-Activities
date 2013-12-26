package com.usesoft.gwt.multiactivities.client.view.north;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class NothView1Impl extends SimpleLayoutPanel implements NorthView1
{
    public NothView1Impl()
    {
        Label l = new Label("North Activity for place 1");
        this.add(l);
    }
}
