CompSci 308: Cell Society
===================
Introduction
=======
The program will be able to read in any set of Cellular Automata simulation rules and grid parameters, and run a grid simulation based off those rules and any initial parameters required by the simulation. Primary design goals include being flexible enough to accept any grid dimensions and any set of rules regarding cell movement, cell interactions, and cell updates. They also include ease of access: being able to easily modify, add, and remove sets of rules depending on cell status and being able to easily create new Cellular Automata simulations based off new sets of rules. Preferably, the program will be easily followable and readable. We anticipate the program will be most flexible in terms of defining new rules for new simulations, and adding the new simulations as part of the choices for the user to make. The primary architecture of this game will follow the architecture of the game project we all completed before: a main class will set up and call the particular simulation of our choosing. The user will only interact with the main class, and the rest of the simulation will be determined by the computer, including rules to follow, grid set-up, and updates to the grid.

Overview
=======

###Picture
![User Input Pop Ups](/Desktop/Map.jpg)

User Interface
=======
###Description
When the user runs the program, he or she will be prompted first with a pop up box
with two inputs.  The first is a drop down list titled Simulation Type, and the user can only pick from the options provided.  The second will be Grid Size with an open box for a typed input.  There will be a message that says "enter integer size for each dimension separated by an 'x', eg. 4x4x4 will produce a 3 Dimensional grid with sides of length 4."  If the user does not input integers separated by x's, they will receive the message "Error, incorrect size input."  Once those inputs are done correctly, the user will be prompted with another pop up box labeled "Parameters".  The options for these will depend on the simulation chosen, but it should entail a certain number of boxes expecting integer values with a short labeled description.  Once that is complete, the simulation will pop up and run until complete.

###Picture
![User Input Pop Ups](/Pictures/UserInterface.jpg)

Design Details
=======

###Main Class:
In charge of starting and running the game. Functions include main() and start(); may be expanded with other methods and functions to help run the game, but at the moment, are unknown.
	
 - Main()
	 - launches the game
 - start()
	 - defines which simulation will be running, sets up the game, and runs the game
	 - calls Setup Class
	 - calls appropriate Simulation Subclass
	 - calls other methods necessary to run game

####Setup Class
In charge of setting up the game. Functions include initialize() and setupXML() and editXMLPreset(). 

 - initialize()
	 - Leads to a user interface that lets user decide which game to play and if applicable, the simulation game.
	 - returns specific simulation game to start() in Main class
 - setupXML()
	 - pick parameters for the grid
	 - sets up grid in accordance to specific simulation game
	 - returns grid to start() in Main class
 - editXMLPreset()
	 - edits XML preset to fit with particular simulation game
	 - returns new XML to setupXML()

####Simulation Class (Superclass):
Superclass of all simulation games. Each different type of simulation game is a subclass of this superclass. Includes all functions all simulation games implement in the same way, including init(), and step(). Also includes abstract functions that all simulation games have, but implement differently.

 - init()
	 - creates scene for simulation game (common among all subclasses)
 - step()
	 - updates cell positions (common among all subclasses)
	 - calls abstract functions dothis(), dothat()
 - dothis()*
	 - abstract function that implements simulation game rules
 - dothat()*
	 - abstract function that implements simulation game rules
 - check()
	 - returns boolean if rule is true (to be used in conjunction with dothis(), dothat() type functions)

*may have more such functions
The methods and functions in this class may potentially be split up into more classes.

Design Considerations
=======
The first and possibly more difficult task was deciding exactly would be the layout of the Main class.  We currently are modeling our experience from the Game project, with a start and main function, 


