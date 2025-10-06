# Snake Game (Java)
Programmed this classic arcade game as my final project in my introductory programming course (CIS 1100). This project served to show my understanding of basic core concepts in object oriented programming, state management, and GUI rendering.

## Features Implemented

* ** Classic Gameplay: ** Standard snake mechanics, which includes constant movement (controlled by WASD), growing snake, score tracking, and collision detection.
* ** High Score Tracking: ** Implemented a high score mechanic which tracks the highest score in the current session
* ** Bonus Fruits: ** Added an orange bonus fruit, different from the standard apple, which appears randomly after an apple is eaten and grants bonus points.
* ** Game States: ** Includes cutom title screen, game over screen, and the ability to restart by pressing 'R'

## Class Structure: 
* SnakeGame.java: This is the main entry point of the application. It manages the game loop, initializes the Board, and handles game states
* Board.java: This is the program's main game controller. It handles the grid, updates positions for the snake and fruit objects, checks for collisions, and updates the score.
* Snake.java: Encapsulates the snake object, implementing its constructor, movement, growth, and checks for self collision
* Fruit.java: Encapsulates the fruit objects (apple and orange), implementing its constructor, and position on the grid.
* Point.java: Simple utility class used to represent the x and y coordinates of each segment of the snakes body.

## NOTE: 
This program uses StdDraw (initially PennDraw, but had to change as its library is not publicly available) as its GUI. The required file is included in this repository.

  
