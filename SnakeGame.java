/**
* Execution: java SnakeGame
*
* Description: the main class for the game, creates the board (which contains
* the snake and fruit), controls the high score display, whent the game runs/
* stops, and when to restart
**/
public class SnakeGame {
    public static void main(String[] args) {
        boolean restart = false;
        boolean hardMode = false;
        int highScore = 0;

        //infinite loop that allows the game to run indedfinitely/restart when needed
        while (true) {
            //sets up the canvas and scale
            PennDraw.setCanvasSize(500, 500);
            PennDraw.enableDoubleBuffering();
            double width = 14.5;
            double height = 14.5;
            PennDraw.setScale(-0.5, width);
            
            Board board = new Board(width, height);

            //the start of the game, displays the welcome screen
            //until a key is pressed
            while (!PennDraw.hasNextKeyTyped()) {
                board.welcome();
                PennDraw.show();
                PennDraw.pause(60);
            }

            //once a key is pressed the game begins, updating and drawing the board
            while (board.isRunning()) {
                PennDraw.clear();
                board.update();
                board.draw();

                //checks if the highscore is broken, if it is, sets
                //highscore to be the current score
                if (highScore < board.getScore()) {
                    highScore = board.getScore();
                }
                //displays high score
                PennDraw.text(1.3, 14, "High Score: " + highScore);
                PennDraw.show();
                PennDraw.pause(60);
                restart = false;
            }
            
            //once you lose, displays the game over screen and wait for restart
            while (!restart) {
                board.displayGameOver();
                PennDraw.text(1.3, 14, "High Score: " + highScore);
                PennDraw.show();
                PennDraw.pause(60);
                if (PennDraw.hasNextKeyTyped()) {
                    //if the key r is typed, restart is set to true,
                    //restarting the game
                    if (PennDraw.nextKeyTyped() == 'r') {
                        restart = true;
                    }
                }
            }
        }
        
    }
}
