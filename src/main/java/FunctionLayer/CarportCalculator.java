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
    
    public static double CalculatePrice (int length, int width , int height)throws CarportException{
        
        // We find out how manny boards are needed in height (they are 10 cm wide)
        // We multiply it by 2, because the opposite side is identical
        // At last we multiply by the length, and so we should have the total length of 
        // all the boards needed for 1 pair of sides.
        
       
        double widthInMeters = width / 100;
        double lengthInMeters = length / 100;
        
        
        
           double sideType1 = ((height / 10) * 2)*lengthInMeters;
           double sideType2 = ((height / 10) * 2)*widthInMeters;
           double bottomAndTop = ((width /10) * 2)* lengthInMeters;
           
           double totalLength = (sideType1 + sideType2 + bottomAndTop);
          
           
           return totalLength *  MaterialMapper.getMeterPrice(3);
          
    }
    
    
     public static double roofArea(int length, int width, double Degree) {
        double radians = Math.toRadians(Degree);
        double hypotenuse = (width/2)/Math.cos(radians);
        double roofWidthRound = Math.floor(hypotenuse*100)/100;
        return  Math.round(roofWidthRound);
        
    }
    
}
