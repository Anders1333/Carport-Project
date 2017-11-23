/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.MaterialMapper;

/**
 *
 * @author AndersHC
 */
public class CarportCalculator {

   

    
    
    public static Carport CalculateMaterials(int length, int width, int height, double degree) throws CarportException {
        double roofHypotenuse = getRoofHypotenuse(length,width,degree);
        double roofArea = getRoofArea(roofHypotenuse,length);
        int verticalPoles = getVerticalPoles(length);
        int horizontalPoles = getHorizontalPoles(length,width);
        
        double price = CalculatePrice(roofArea,verticalPoles,horizontalPoles);
        
        Carport carport = new Carport(roofArea,verticalPoles,horizontalPoles,price);
        
        return carport;
         }
        
        
        
    public static double CalculatePrice(double roofArea,int verticalPoles,int HorizontalPoles){
        
        return 100;
    }
        
    

    public static double getRoofHypotenuse(int length, int width, double degree) throws CarportException {

        if (degree <= 0) {
            return length * width;
        } else {
            double radians = Math.toRadians(degree);
            double hypotenuse = (width / 2) / Math.cos(radians);
            double roofWidthRound = Math.floor(hypotenuse * 100) / 100;
            return Math.round(roofWidthRound);
        }

    }

    public static double getRoofArea(double roofWidth, int length) throws CarportException {
        return (roofWidth * length*2)/10000;
    }

    static int getVerticalPoles(int length) throws CarportException {
        int numberOfPoles = 1;
        numberOfPoles += length / 200;
        return numberOfPoles * 2;

    }

    static int getHorizontalPoles(int length, int width) throws CarportException{
        int poleLength = length / 200;
        if (poleLength % 200 > 0) {
            poleLength += 1;
        }
        int poleWidth = width / 200;
        if (poleWidth % 200 > 0) {
            poleWidth += 1;
        }
        return poleLength+poleWidth;
    }

   

}
