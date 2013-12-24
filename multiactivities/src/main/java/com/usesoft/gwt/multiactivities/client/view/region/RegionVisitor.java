package com.usesoft.gwt.multiactivities.client.view.region;

public interface RegionVisitor<IN, OUT>
{
    OUT visitNorth(IN in);

    OUT visitEast(IN in);

    OUT visitCenter(IN in);

    OUT visitWest(IN in);

    OUT visitSouth(IN in);
}
