/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author DD
 */
public class Carport {
    
    double roofArea;
    int verticalPoles;
    int horizontalPoles;
    double price;

    public Carport(double roofArea, int verticalPoles, int horizontalPoles, double price) {
        this.roofArea = roofArea;
        this.verticalPoles = verticalPoles;
        this.horizontalPoles = horizontalPoles;
        this.price = price;
    }

    public double getRoofArea() {
        return roofArea;
    }

    public int getVerticalPoles() {
        return verticalPoles;
    }

    public int getHorizontalPoles() {
        return horizontalPoles;
    }

    public double getPrice() {
        return price;
    }

   
    
    
    
}
