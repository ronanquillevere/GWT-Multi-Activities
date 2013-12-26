GWT-Multi-Activities
====================

An example of GWT client application with multiple activities per place. Idea taken from http://blog.ltgt.net/gwt-21-activities-nesting-yagni/

Introduction
------------

When building a complex application with Activities and Places, quickly you start nesting Activities inside each others to handle each zone/region of your page. 

Maybe, if you have separated your presenter interface from the activity, you will have only one activity and multiple nested presenter inside this activity. 

Whatever your implementation, your design lack some modularity. So Thomas Broyer came up with what I beleive is a good idea which was described in this article.

In this project I have tried to implement Thomas idea, keeping it as simple as possible.

Layout
------

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


Implementation
---------------
