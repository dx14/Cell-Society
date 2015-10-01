#Simulation APIs
 - Cell
	 -  getSurroundingCells - should be internal
 - Simulation
- loopThroughCells - should not be part of API
- simStep - should be internal (needed by API)

If this was done properly there would be a simulation package that had the simulation and cell superclasses and subclasses.  This way every method in cell could be protected, and loop through cells in simulation would be private.  The reason cell needs to be protected and not private is because it has to be used in all  the simulation classes, so in order to write any other code these methods cannot be private. No other function in simulation is still there.  All the subclasses in simulation should have all private methods.

## Configuration APIs
 - Dom
- HandleDom method - should be internal API
 - Step
- updateStep method - should be internal
- simFactory method - should be not part of API
- initLoop method - should be external
- changeLoop method - should be external

The Dom class methods read in the data from the XML file and make it available for the rest of the program to use. Thus, it needs to be public. 
The step() method should public because you need to populate the buttons with the appropriate functions each time a step is run. Other than these two methods, the rest of the configuration should be hidden from public eye because they do not interact with other code and do not need to be extended to add functionality to the code.
The main method should be public because it starts the entire code.

##Visualization APIs
 - GUI
	 - initGUI not part of the API
	 - addGrid should be internal
 - Buttons
- addButtons and addBox should both be internal API

The GUI is a separate interface that calls in preset values from the Buttons and Grid classes. The initGUI method would private since no other class should or needs to call this method. Grids are passed in from the Grid method, whose methods needed to make the grid should be private. However, the class addGrid in GUI should be public and the Grid class should be able to call this method to add the grid to the GUI interface.
