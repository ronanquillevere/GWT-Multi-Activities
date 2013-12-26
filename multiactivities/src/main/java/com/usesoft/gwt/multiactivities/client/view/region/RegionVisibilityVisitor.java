package com.usesoft.gwt.multiactivities.client.view.region;

import com.google.gwt.user.client.ui.DockLayoutPanel;


public class RegionVisibilityVisitor implements RegionVisitor<Boolean, Void>
{
    private RegionContainer northRegionContainer;
    private RegionContainer southRegionContainer;
    private RegionContainer westRegionContainer;
    private RegionContainer centerRegionContainer;
    private RegionContainer eastRegionContainer;

    // TODO do not use a rootContainer here ! Should use a new kind of interface
    private DockLayoutPanel rootContainer;

    public RegionVisibilityVisitor(RegionContainer northRegionContainer, RegionContainer southRegionContainer, RegionContainer eastRegionContainer,
            RegionContainer westRegionContainer, RegionContainer centerRegionContainer, DockLayoutPanel rootContainer)
    {
        this.northRegionContainer = northRegionContainer;
        this.southRegionContainer = southRegionContainer;
        this.westRegionContainer = westRegionContainer;
        this.eastRegionContainer = eastRegionContainer;
        this.centerRegionContainer = centerRegionContainer;
        this.rootContainer = rootContainer;
    }

    @Override
    public Void visitNorth(Boolean in)
    {
        northRegionContainer.setVisible(in);
        rootContainer.setWidgetHidden(northRegionContainer.asWidget(), !in);
        return null;
    }

    @Override
    public Void visitEast(Boolean in)
    {
        eastRegionContainer.setVisible(in);
        rootContainer.setWidgetHidden(eastRegionContainer.asWidget(), !in);
        return null;
    }

    @Override
    public Void visitCenter(Boolean in)
    {
        centerRegionContainer.setVisible(in);
        rootContainer.setWidgetHidden(centerRegionContainer.asWidget(), !in);
        return null;
    }

    @Override
    public Void visitWest(Boolean in)
    {
        westRegionContainer.setVisible(in);
        rootContainer.setWidgetHidden(westRegionContainer.asWidget(), !in);
        return null;
    }

    @Override
    public Void visitSouth(Boolean in)
    {
        southRegionContainer.setVisible(in);
        rootContainer.setWidgetHidden(southRegionContainer.asWidget(), !in);
        return null;
    }

}
