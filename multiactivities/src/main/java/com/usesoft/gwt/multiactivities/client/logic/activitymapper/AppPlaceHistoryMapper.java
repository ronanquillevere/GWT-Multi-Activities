package com.usesoft.gwt.multiactivities.client.logic.activitymapper;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.usesoft.gwt.multiactivities.client.logic.place.Place1;
import com.usesoft.gwt.multiactivities.client.logic.place.Place2;

@WithTokenizers({ Place1.Tokenizer.class, Place2.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{
}
