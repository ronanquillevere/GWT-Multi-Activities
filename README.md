# GWT-Multi-Activities

An example of GWT client application with multiple activities per place. Idea taken from http://blog.ltgt.net/gwt-21-activities-nesting-yagni/

## Introduction

When building a complex application with [Activities and Places](http://www.gwtproject.org/doc/latest/DevGuideMvpActivitiesAndPlaces.html), quickly you start nesting activities inside each others to handle each zone/region of your page. 

Maybe, if you have separated your presenter interface from the activity, you will have only one activity and multiple nested presenters inside this activity. 

Whatever your implementation, your design lack some modularity. So Thomas Broyer came up with what I beleive is a good idea which was described in [this article](http://blog.ltgt.net/gwt-21-activities-nesting-yagni/).

In this project I have tried to implement Thomas idea, keeping it as simple as possible.

## Layout

I this example I stick with a simple layout with only 5 regions (North, South, East, West, Center). They correspond to a DockLayoutPanel regions wich will keep the code simple. Nevertheless nothing prevents to use pure LayoutPanel to build a more complex layout or to nest another DockLayoutPanel inside the Center region for example.

Here is my layout

    _____________________________
    |          North            |
    _____________________________
    |        |         |        |   
    |  West  | Center  |  East  | 
    |        |         |        |
    _____________________________
    |           South           |
    _____________________________


## Implementation

### RootView (and Presenter)
To code the basic layout and the different regions, I have created a RootView and an associated RootPresenter. Each region will be a kind of container where I will be able to insert an activity view. So it is natural that it implements the HasOneWidget interface.

    public interface RegionContainer extends HasOneWidget, IsWidget
    
The RootView will contain all the RegionContainers (North, West etc...). Its responsibility will be to instantiate the view containers and set the right parameters (the region etc.)

### Activities

Each region should have its own activity manager. The north region will be initialized lie this 

    ActivityManager northActivityManager = new ActivityManager(injector.getNorthActivityMapper(), eventBus);
    northActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.North));
    
Each region will have a specific ActivityMapper. The activity mapper will be responsible for creating an activity for one place for a specific region. Example the NorthActivityMapper will return the right activity for the north region depending if we are on Place1 or Place2. The implementation of this mapper will be based on a place [visitor](http://en.wikipedia.org/wiki/Visitor_pattern) (a kind of switch on class type).

### Place

I created 2 places : Place1 and Place2. For each place the layout will be different. In place 2 I will hide the north region by simply not creating any activity related to this region.

Place 1 layout

    _____________________________
    |          North            |
    _____________________________
    |        |         |        |   
    |  West  | Center  |  East  | 
    |        |         |        |
    _____________________________
    |           South           |
    _____________________________

Place 2 layout

    _____________________________
    |        |         |        |   
    |  West  | Center  |  East  | 
    |        |         |        |
    _____________________________
    |           South           |
    _____________________________
