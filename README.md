# GWT-Multi-Activities

An example of GWT client application with multiple activities per place (without nesting activities). Idea taken from http://blog.ltgt.net/gwt-21-activities-nesting-yagni/

## Introduction

When building a complex application with [Activities and Places](http://www.gwtproject.org/doc/latest/DevGuideMvpActivitiesAndPlaces.html), quickly you start nesting activities inside each others to handle each zone/region of your application pages. What you would like to do is for example to re-use the same activity for the "header" part of all your pages. By header I mean the place where you usually log in/out etc.  

Maybe, if you have separated your presenter interface from the activity, you will have only one activity and multiple nested presenters inside your activity. 

Whatever your implementation is, your design lack some modularity. So Thomas Broyer came up with what I beleive is a good idea which was described in [this article](http://blog.ltgt.net/gwt-21-activities-nesting-yagni/).

The idea is that you create a base layout structure supporting all the different layouts of your pages. In this base layout structure you will have different regions. Each region will correspond to a different activity. Maybe for some places, some regions will be useless and will be hidden. All activities that will fill the regions are independant from eachother.

In this project I have tried to implement Thomas idea, keeping it as simple as possible. Nevertheless to understand the code (which is probably far from being perfect) you will need a good knowledge of Activities and Places, MVP, Injection with GIN. Plus you need to understand Thomas idea. You can have a look to my blog for some article on Activities and Places or have a look to the various questions on StackOverflow.


http://wpamm.blogspot.fr/2013/03/gwt-activity-place-introduction.html

http://wpamm.blogspot.fr/2013/08/nested-activities-alternative-with.html

http://stackoverflow.com/questions/tagged/gwt-activities

## Layout

In this example I stick with a simple layout with only 5 regions (North, South, East, West, Center). I could have splitted the center region vertically to add some more complexity. But my idea was to keep the code as simple as possible. You will see in the code that those 5 regions correspond to a DockLayoutPanel regions wich will keep the code simple. Nevertheless nothing prevents to use pure LayoutPanel to build a more complex layout or to nest another DockLayoutPanel inside the Center region for example.

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

### Activities and Places 

Just a quick diagram to remind you the major responsibilities when you go to a new place (called NewPlace in the diagram). 
![placediagram](http://2.bp.blogspot.com/-xDBUCS1gL0E/Ufsj7w8avPI/AAAAAAAAKcQ/K5I0ka1zttQ/s1600/SimpleActivityPlaceDiagram.png)

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

### RootView (and Presenter)

To code the basic layout structure and the different regions, I have created a RootView and an associated RootPresenter. Each region will be a kind of container where I will be able to insert an activity view. So it is natural that it implements the HasOneWidget interface.

    public interface RegionContainer extends HasOneWidget, IsWidget
    
The RootView will contain all the RegionContainers (North, West etc...). Its responsibility will be to instantiate the view containers and set the right parameters (the region etc.)

But the most important responsibility will be to hide the region container if there is no activity needed for a given place.

### Activities

Each region should have its own activity manager. On each place, each region should be assigned an activity. Maybe for some region there will be no activity, and the region will be hidden. The north region will be initialized lie this 

    ActivityManager northActivityManager = new ActivityManager(injector.getNorthActivityMapper(), eventBus);
    northActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.North));
    
Each region will have a specific ActivityMapper. The activity mapper will be responsible for creating an activity for one place for a specific region. Example the NorthActivityMapper will return the right activity for the north region depending if we are on Place1 or Place2. The implementation of this mapper will be based on a place [visitor](http://en.wikipedia.org/wiki/Visitor_pattern) (a kind of switch on class type).

#### West Activity

Inside the west region I create an activity that contains 2 buttons to navigate towards place1 or place2. This activity is a singleton (defined in the injection Module). So on place1 or place2 the WestActivityMapper will return the same instance of activity. It can be usefull if in some of your region, whatever the place the activity is always the same.

### Result

Here is the result, you can see the url in the screenshots. In Place2 there is no North region. The west activity enables you to navigate from place1 to Place2.

[Place1](./Place1.png)

[Place2](./Place2.png)

