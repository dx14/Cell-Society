CompSci 308: Cell Society
===================
Introduction
=======
The program will be able to read in any set of Cellular Automata simulation rules and grid parameters, and run a grid simulation based off those rules and any initial parameters required by the simulation. Primary design goals include being flexible enough to accept any grid dimensions and any set of rules regarding cell movement, cell interactions, and cell updates. They also include ease of access: being able to easily modify, add, and remove sets of rules depending on cell status and being able to easily create new Cellular Automata simulations based off new sets of rules. Preferably, the program will be easily followable and readable. We anticipate the program will be most flexible in terms of defining new rules for new simulations, and adding the new simulations as part of the choices for the user to make. The primary architecture of this game will follow the architecture of the game project we all completed before: a main class will set up and call the particular simulation of our choosing. The user will only interact with the main class, and the rest of the simulation will be determined by the computer, including rules to follow, grid set-up, and updates to the grid.
===================
User Interface
=======
###Description
When the user runs the program, he or she will be prompted first with a pop up box
with two inputs.  The first is a drop down list titled Simulation Type, and the user can only pick from the options provided.  The second will be Grid Size with an open box for a typed input.  There will be a message that says "enter integer size for each dimension separated by an 'x', eg. 4x4x4 will produce a 3 Dimensional grid with sides of length 4."  If the user does not input integers separated by x's, they will receive the message "Error, incorrect size input."  Once those inputs are done correctly, the user will be prompted with another pop up box labeled "Parameters".  The options for these will depend on the simulation chosen, but it should entail a certain number of boxes expecting integer values with a short labeled description.  Once that is complete, the simulation will pop up and run until complete.

###Picture
![User Input Pop Ups](/Pictures/UserInterface.jpg)

Design Considerations
=======
The first and possibly more difficult task was deciding exactly would be the layout of the Main class.  We currently are modeling our experience from the Game project, with a start and main function, 


