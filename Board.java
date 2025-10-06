/**
* Name: Daniel Ranaudo
* Pennkey: ranaudo
* Execution: N/A, this class is meant to be used by other classes
*
* Description: Manages the board, which also
* calls for the fruits and snake to be drawn and updates
**/
import java.util.ArrayList;

public class Board {
    private Snake cobra;
    private int score, highScore;
    private double width, height;
    private Fruit apple, orange;
    private boolean orangePres;
    
    public Board(double width, double height) {
        this.height = height;
        this.width = width;
        orangePres = false;
        score = 0;
        highScore = 0;
        
        //initializes an array list (first segment of snake)
        ArrayList<Point> body = new ArrayList<Point>();
        Point startPos = new Point(7, 7);
        body.add(0, startPos);
        
        //initializes three objects
        cobra = new Snake(body);
        apple = new Fruit(0, (int) (Math.random() * 15), (int) (Math.random() * 15));
        
        //initializes new fruit orange outside of the map
        orange = new Fruit(1, -5, -5);
    }
    
    
    /**
     * Inputs: none
     * Outputs: int of the score
     * Description: getter method for score
    */
    public int getScore() {
        return score;
    }
    
    /**
    * Inputs: none
    * Outputs: none
    * Description: implements the draw functions from the other classes,
    * draws the score
    */
    public void draw() {
        cobra.draw();
        apple.draw();
        PennDraw.text(0.6, 0, "Score: " + score);
        
        //checks if orangePres is true (code that determines this
        // in line 81-84) and draws the orange
        if (orangePres) {
            orange.draw();
        }
    }
    
    /**
    * Inputs: none
    * Outputs: none
    * Description: updates the positions of the snake and the fruit
    */
    public void update() {
        cobra.update();
        
        //if snake collides with apple, apple respawns elsewhere
        if (cobra.getX() == apple.getX() && cobra.getY() == apple.getY()) {
            score++;
            apple.update();
            cobra.addPoint();
            
            //determines if the orange should or shouldn't be on the board
            if (Math.random() > 0.7) {
                orangePres = true;
                orange.update();
            }
        }
        
        //if snake collides with orange
        if (cobra.getX() == orange.getX() && cobra.getY() == orange.getY()) {
            score = score + 2;

            //sets the position of the orange to be outside of the map
            orange.setX(-5);
            orange.setY(-5);
            cobra.addPoint();
            orangePres = false;
        }
    }
    
    /**
    * Inputs: none
    * Outputs: boolean on if the game is running
    * Description: checks if the game is still going on. False if it ends true if
    * it is still running
    */
    public boolean isRunning() {
        //if the snake is outside the map, game ends
        if (cobra.getX() > 14) {
            return false;
        }
        if (cobra.getX() < 0) {
            return false;
        }
        if (cobra.getY() > 14) {
            return false;
        }
        if (cobra.getY() < 0) {
            return false;
        }
        
        //calls the selfCollision function to ensure that
        // the snake has not collided with itself
        return true && !cobra.selfCollision();
    }
    
    /**
     * Inputs: none
     * Outputs: none
     * Description: displays the game over screen
    */
    public void displayGameOver() {
        PennDraw.clear();
        PennDraw.text(7, 7, "YOU LOSE Final Score: " + score);
        PennDraw.text(7, 6, "Press R to Restart");
    }
    
    /**
     * Inputs: none
     * Outputs: none
     * Description: Displays the title screen
    */
    public void welcome() {
        PennDraw.clear();
        PennDraw.text(7, 7, "Welcome to Snake! Press Any Key to Start");
    }
}
