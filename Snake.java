/**
* Name: Daniel Ranaudo
* Pennkey: ranaudo
* Execution: N/A, this class is meant to be used by other classes 
*
* Description: Controls and builds the snake
**/
import java.util.ArrayList;

public class Snake {
    
    private char key, prev;
    private double xPos, yPos, xVel, yVel;
    private ArrayList<Point> body;
    
    public Snake(ArrayList<Point> body) {
        this.body = body;
        
    }
    
    
    /**
     * Inputs: none
     * Outputs: the x position of the head
     * Description: getter for the xPos of the head
    */
    public double getX() {
        return body.get(0).getX();
    }
    
    /**
     * Inputs: none
     * Outputs: the y position of the head
     * Description: getter for the yPos of the head
    */
    public double getY() {
        return body.get(0).getY();
    }
    
    
    /**
     * Inputs: none
     * Outputs: none
     * Description: adds a point at the end of the snake,
     * used for when the snake grows
    */
    public void addPoint() {
        body.add(new Point(body.get(body.size() - 1).getX(), 
        body.get(body.size() - 1).getY()));
    }
    
    /**
    * Inputs: None
    * Outputs: None
    * Description: updates the position of the head taking the tail and moving
    * it to the front depending on the keypress
    *
    */
    public void update() {
        if (PennDraw.hasNextKeyTyped()) {
            key = PennDraw.nextKeyTyped();
        }
        
        //checks the keypress, including if it matches/is 
        //the opposite of previous keypress changes the velocity accordingly
        if (key == 'w' && prev != 's' && prev != key) {
            xVel = 0;
            yVel = 1;
        } else if (key == 's' && prev != 'w' && prev != key) {
            xVel = 0;
            yVel = -1;
        } else if (key == 'a' && prev != 'd' && prev != key) {
            xVel = -1;
            yVel = 0;
        } else if (key == 'd' && prev != 'a' && prev != key) {
            xVel = 1;
            yVel = 0;
        }
        prev = key;
        
        //saves the position of the head
        Point head = body.get(0);
        double headXpos = head.getX();
        double headYpos = head.getY();
        
        //removes the tail in order to get it ready to move up
        body.remove(body.size() - 1);
        
        //creates a newHead in front of old head, and puts 
        //it in the front of the array
        // it becomes the head for the next implementation of update
        double newHeadX = headXpos + xVel;
        double newHeadY = headYpos + yVel;
        Point newHead = new Point(newHeadX, newHeadY);
        body.add(0, newHead);
    }
    
    /*
    *Inputs: none
    *Outputs: none
    *Descriptions: draws the snake in its respective position
    * by iterating through each segment and drawing a square
    */
    public void draw() {
        for (int i = 0; i < body.size(); i++) {
            //changes the pen color depending if it
            //is the head or the rest of the body
            if (i == 0) {
                PennDraw.setPenColor(PennDraw.BLUE);
            } else {
                PennDraw.setPenColor(PennDraw.GREEN);
            }
            double xPos = body.get(i).getX();
            double yPos = body.get(i).getY();
            PennDraw.filledCircle(xPos, yPos, 0.5);
            PennDraw.setPenColor();
        }
    }
    
    /**
     * Inputs: none
     * Outputs: boolean that tells us if the snake collided
     * Description: checks if the snake has collided with itself
     * (used to check if the game should end)
    */
    public boolean selfCollision() {
        //if the position of the head is the same as the position
        // of any other part of the snake, the snake has collided
        for (int i = 1; i < body.size(); i++) {
            if (getX() == body.get(i).getX() && getY() == body.get(i).getY() &&
            body.size() > 2) {
                return true;
            }
        }
        return false;
    }
}
