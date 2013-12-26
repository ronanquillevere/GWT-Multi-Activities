package com.usesoft.gwt.multiactivities.client.view.rootlayout;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.usesoft.gwt.multiactivities.client.view.region.Region;
import com.usesoft.gwt.multiactivities.client.view.region.RegionContainter;
import com.usesoft.gwt.multiactivities.client.view.region.RegionVisibilityVisitor;

public class RootViewImpl extends Composite implements RootView
{

    @Inject
    @UiField(provided = true)
    RegionContainter northRegionContainer;

    @Inject
    @UiField(provided = true)
    RegionContainter westRegionContainer;

    @Inject
    @UiField(provided = true)
    RegionContainter eastRegionContainer;

    @Inject
    @UiField(provided = true)
    RegionContainter southRegionContainer;

    @Inject
    @UiField(provided = true)
    RegionContainter centerRegionContainer;

    private RegionVisibilityVisitor regionVisibilityVisitor;

    @UiTemplate("RootView.ui.xml")
    interface RootViewUiBinder extends UiBinder<Widget, RootViewImpl>
    {
    }

    @Inject
    void init(RootViewUiBinder binder)
    {
        initWidget(binder.createAndBindUi(this));
        regionVisibilityVisitor = new RegionVisibilityVisitor(northRegionContainer, southRegionContainer, eastRegionContainer, westRegionContainer,
                centerRegionContainer);
    }


    @Override
    public void setRegionVisibility(Region region, boolean visible)
    {
        region.accept(regionVisibilityVisitor, visible);
    }
}
