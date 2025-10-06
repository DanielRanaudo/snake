/**
 * Execution: N/A, this class is meant to be used by other classes
 *
 * Description: Builds the fruits
**/
public class Fruit {
    private double xPos, yPos;
    private int type;
    public Fruit(int type, double xPos, double yPos) {
        //type is needed to distinguish between bonus fruit and 
        // regular fruit
        this.type = type;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //updates creates a new fruit (when it collides with snake)
    /**
     * Inputs: none
     * Outputs: none
     * Description: function to draw the fruit, later to be 
     * called in the Board class
    */
    public void draw() {
        //drawing for apple
        if (this.type == 0) {
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledSquare(xPos, yPos, 0.5);
            PennDraw.setPenColor();

          //drawing for orange
        } else if (this.type == 1) {
            PennDraw.setPenColor(PennDraw.ORANGE);
            PennDraw.filledSquare(xPos, yPos, 0.5);
            PennDraw.setPenColor();
        }
    }
    
    /**
     * Inputs: none
     * Outputs: none
     * Description: sets a new randrom position for the 
     * fruit to be in
    */
    public void update() {
        //multiplies by 15 to make sure that
        //its always on the map
        xPos = (int) (Math.random() * 15);
        yPos = (int) (Math.random() * 15);
    }
    
    /**
     * Inputs: none
     * Outputs: double
     * Description: getter for the xPos of the fruit
    */
    public double getX() {
        return xPos;
    }
    
    /**
     * Inputs: none
     * Outputs: the y position 
     * Description: getter for the y position of fruit
    */
    public double getY() {
        return yPos;
    }
    
    /**
     * Inputs: the new desired X position
     * Outputs: the new X position
     * Description: setter for the X position of fruit
    */
    public double setX(double newX) {
        xPos = newX;
        return xPos;
    }
    
    /**
     * Inputs: the new desired Y position
     * Outputs: the new Y position
     * Description: setter for the Y position of fruit
    */
    public double setY(double newY) {
        yPos = newY;
        return yPos;
    }
}
