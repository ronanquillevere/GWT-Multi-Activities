package com.usesoft.gwt.multiactivities.client.view.region;


public class RegionContainerGetterVisitor implements RegionVisitor<Void, RegionContainer>
{
    private RegionContainer northRegionContainer;
    private RegionContainer southRegionContainer;
    private RegionContainer westRegionContainer;
    private RegionContainer centerRegionContainer;
    private RegionContainer eastRegionContainer;

    public RegionContainerGetterVisitor(RegionContainer northRegionContainer, RegionContainer southRegionContainer, RegionContainer eastRegionContainer,
            RegionContainer westRegionContainer, RegionContainer centerRegionContainer)
    {
        this.northRegionContainer = northRegionContainer;
        this.southRegionContainer = southRegionContainer;
        this.westRegionContainer = westRegionContainer;
        this.eastRegionContainer = eastRegionContainer;
        this.centerRegionContainer = centerRegionContainer;
    }

    @Override
    public RegionContainer visitNorth(Void in)
    {
        return northRegionContainer;
    }

    @Override
    public RegionContainer visitEast(Void in)
    {
        return eastRegionContainer;
    }

    @Override
    public RegionContainer visitCenter(Void in)
    {
        return centerRegionContainer;
    }

    @Override
    public RegionContainer visitWest(Void in)
    {
        return westRegionContainer;
    }

    @Override
    public RegionContainer visitSouth(Void in)
    {
        return southRegionContainer;
    }

}
