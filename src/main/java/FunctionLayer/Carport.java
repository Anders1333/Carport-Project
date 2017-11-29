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
    private static int shedDepth;

    // construter for a Carport without a shed
    public Carport(int Length, int width, int height, double degree) {
        Carport.length = Length;
        Carport.width = width;
        Carport.height = height;
        Carport.degree = degree;

    }

    //  construter for a Carport with a shed
    public Carport(int Length, int width, int height, double degree, int shedDepth) {
        Carport.length = Length;
        Carport.width = width;
        Carport.height = height;
        Carport.degree = degree;
        Carport.shedDepth = shedDepth;

    }

    public static int getShedDepth() {
        return shedDepth;
    }

    public static int getLength() {
        return length;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static double getDegree() {
        return degree;
    }

    //------------------------ Roof ---------------------------------//
    public static double getInclineSheets() throws CarportException {

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

    public static int getHorizontalPolesWidth() throws CarportException {
        return CarportCalculator.getHorisontalPolesWidth(width);

    }

    //--------------------------Shed---------------------------------//
    public static int getShedPoles() throws CarportException {
        return ShedCalculator.getShedPoles(width);
    }

    public static int getShedFrames() throws CarportException {
        return ShedCalculator.getShedFrame(width);

    }
    
    //--------------------------PRICE------------------------------//
    
    public static double getTotalPrice () throws CarportException{
       
        return PriceCalculation.getTotalPrice(length, width, height, degree);
    
    
    }
}
