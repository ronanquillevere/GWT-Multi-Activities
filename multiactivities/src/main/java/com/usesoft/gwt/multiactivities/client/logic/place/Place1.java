package com.usesoft.gwt.multiactivities.client.logic.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class Place1 extends BasePlace
{
    private final String paramPlace1;

    public Place1(String paramPlace1)
    {
        this.paramPlace1 = paramPlace1;
    }

    public String getParamPlace1()
    {
        return paramPlace1;
    }

    public static class Tokenizer implements PlaceTokenizer<Place1> {
        @Override
        public String getToken(Place1 place) {
            return place.getParamPlace1();
        }

        @Override
        public Place1 getPlace(String token) {
            return new Place1(token);
        }
    }

    @Override
    public <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in)
    {
        return visitor.visit(this, in);
    }
}
