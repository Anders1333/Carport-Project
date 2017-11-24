
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
