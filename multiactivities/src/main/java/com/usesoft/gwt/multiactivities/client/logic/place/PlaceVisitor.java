package com.usesoft.gwt.multiactivities.client.logic.place;

public interface PlaceVisitor<IN, OUT>
{
    OUT visit(Place1 place1, IN in);

    OUT visit(Place2 place2, IN in);
}
