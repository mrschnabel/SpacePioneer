# SpacePioneer
A video game in which the user controls a block figure and tries to make it to the other end of the screen while avoiding the enemies and barriers.
The MAIN file creates the Jframe and initiates the game.  game.java contains the game loop.  All objects are drawn here, and the game flow is
controlled here.  Enemies are created in enemy.java.  Barriers are created in barrier.java.

The user scores points by successfully making it from the bottom of the screen to the top without hitting any enemies or barriers.
The game is over if a barrier or enemy is hit.
There are 3 levels, each of increasing difficulty.  The user makes it to the next level after every 100 points scored.

