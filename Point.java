/**
* Execution: N/A, this class is meant to be used by other classes
*
* Description: defines the point (body ArrayList is made of points)
**/
public class Point {
    private double x, y;
    
    //defines a point as a data type with an
    //x coordinate and y coordinate
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
    * Inputs: none
    * Outputs: the x value of the point
    * Description: getter method for the xPos of the point
    */
    public double getX() {
        return x;
    }
    /**
    * Inputs: none
    * Outputs: the y value of the point
    * Description: getter method for y Pos
    */
    public double getY() {
        return y;
    }
}

