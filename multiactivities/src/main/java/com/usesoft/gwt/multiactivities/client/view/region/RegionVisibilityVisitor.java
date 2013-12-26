package com.usesoft.gwt.multiactivities.client.view.region;


public class RegionVisibilityVisitor implements RegionVisitor<Boolean, Void>
{
    private RegionContainter northRegionContainer;
    private RegionContainter southRegionContainer;
    private RegionContainter westRegionContainer;
    private RegionContainter centerRegionContainer;
    private RegionContainter eastRegionContainer;

    public RegionVisibilityVisitor(RegionContainter northRegionContainer, RegionContainter southRegionContainer, RegionContainter eastRegionContainer,
            RegionContainter westRegionContainer, RegionContainter centerRegionContainer)
    {
        this.northRegionContainer = northRegionContainer;
        this.southRegionContainer = southRegionContainer;
        this.westRegionContainer = westRegionContainer;
        this.eastRegionContainer = eastRegionContainer;
        this.centerRegionContainer = centerRegionContainer;
    }

    public Void visitNorth(Boolean in)
    {
        northRegionContainer.setVisible(in);
        return null;
    }

    public Void visitEast(Boolean in)
    {
        eastRegionContainer.setVisible(in);
        return null;
    }

    public Void visitCenter(Boolean in)
    {
        centerRegionContainer.setVisible(in);
        return null;
    }

    public Void visitWest(Boolean in)
    {
        westRegionContainer.setVisible(in);
        return null;
    }

    public Void visitSouth(Boolean in)
    {
        southRegionContainer.setVisible(in);
        return null;
    }

}
