package com.metacube.assignment3;

public class CalculateArea {
    
    /** to calculate Area of triangle
     * 
     * @param side1 of triangle
     * @param side2 of triangle
     * @param side3 of triangle
     * @return area of triangle
     */
    public double areaOfTriangle(double side1,double side2, double side3){
        double halfOfPerimeter = (side1+side2+side3)/ 2;
        double tempArea = halfOfPerimeter * (halfOfPerimeter - side1) * (halfOfPerimeter - side2)
                * (halfOfPerimeter - side3);
        return Math.sqrt(tempArea);
    }

}
