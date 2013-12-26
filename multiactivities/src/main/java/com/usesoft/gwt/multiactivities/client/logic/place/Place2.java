package com.usesoft.gwt.multiactivities.client.logic.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class Place2 extends BasePlace
{
    private final String paramPlace2;

    public Place2(String paramPlace2)
    {
        this.paramPlace2 = paramPlace2;
    }

    public String getParamPlace2()
    {
        return paramPlace2;
    }

    public static class Tokenizer implements PlaceTokenizer<Place2>
    {
        @Override
        public String getToken(Place2 place)
        {
            return place.getParamPlace2();
        }

        @Override
        public Place2 getPlace(String token)
        {
            return new Place2(token);
        }
    }

    @Override
    public <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in)
    {
        return visitor.visit(this, in);
    }
}
