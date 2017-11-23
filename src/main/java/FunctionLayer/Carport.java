/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DD
 */
public class Carport {

    private static int length;
    private static int width;
    private static int height;
    private static double degree;

    public Carport(int Length, int width, int height, double degree) {
        Carport.length = Length;
        Carport.width = width;
        Carport.height = height;
        Carport.degree = degree;
    }

    
    
    
    
    
    //------------------------ Roof ---------------------------------//
    public static int getInclineSheets() throws CarportException {

        return CarportCalculator.getInclineSheet(width, length, degree);

    }

    public static double getRoofMeterial() throws CarportException {
        return CarportCalculator.getRoofMeterial(width, length, degree);

    }

    public static int getTopBattens() throws CarportException {
        return CarportCalculator.getTopBattens(length);

    }

    //-------------------------- Carport --------------------------//
    public static int getSternPalnksCarport() throws CarportException {
        return CarportCalculator.getSternPlanksCarport(length);

    }

    public static int getVerticalPoles() throws CarportException {
        return CarportCalculator.getVerticalPoles(length);

    }

    public static int getHorizontalPolesLength() throws CarportException {
        return CarportCalculator.getHorizontalPolesLength(length);

    }

    public static int getHorizintalPolesWidth() throws CarportException {
        return CarportCalculator.getHorisontalPolesWidth(length);

    }

}
