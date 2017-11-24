/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author AndersHC
 */
public class CarportCalculator {

    public static PackingList getPacklist(int length, int width, int height, double degree) throws CarportException {

//        //--- CARPORT ---//
//        int inclineSheets = getInclineSheet(getInclineLength(length, width, degree));
//        int sternPlanksCarport = getSternPlanksCarport(length);
//        int verticalPoles = getVerticalPoles(length);
//        int horizontalPolesLength = getHorizontalPolesLength(length);
//        int horizontalPolesWidth = getHorisontalPolesWidth(width);
//        int topBattens = getTopBattens(length);
//  
//        //--- Roof ---//
//        int roofMeterial = (int) getRoofMeterial(width, (int) getInclineLength(length, width, degree), length, degree);
//
//        return new PackingList(inclineSheets, sternPlanksCarport,
//                verticalPoles, horizontalPolesLength, horizontalPolesWidth,
//                topBattens, roofMeterial);
        return null;

    }

    public static Carport CalculateMaterials(int length, int width, int height, double degree) throws CarportException {
//        double roofHypotenuse = getRoofHypotenuse(length,width,degree);
//        double roofArea = getRoofArea(roofHypotenuse,length);
//        int verticalPoles = getVerticalPoles(length);
//        int horizontalPoles = getHorizontalPoles(length,width);
//        
//        double price = CalculatePrice(roofArea,verticalPoles,horizontalPoles,length,width,height,degree);
//        
//        Carport carport = new Carport(roofArea,verticalPoles,horizontalPoles,price);
//        
//        return carport;
//         }
//    public static double CalculatePrice(double roofArea,int verticalPoles,int HorizontalPoles,int length,int width,int height,double degree) throws CarportException{
//        
//        double verticalPolePrice = MaterialMapper.getMeterPrice(3)*(height/100);
//        double horizontalPolePrice = MaterialMapper.getMeterPrice(3)*(width/100);
//        double roofprice = roofArea * 50;
//        
//        double totalForVerticalPoles = verticalPolePrice * verticalPoles;
//        double totalForHorizontalPoles = horizontalPolePrice * HorizontalPoles;
//        
//        
//        double totalPrice = totalForVerticalPoles+totalForHorizontalPoles+roofprice;
//        
//        
        return null;
    }
//----------------- ROOF CALCULATIONS ------------------------------//

    public static double getInclineLength(int length, int width, double degree) throws CarportException {

        if (degree <= 0) {
            return length * width;
        } else if (degree >= 90) {
            throw new CarportException("This roof is not buildable.");
        } else {
            double radians = Math.toRadians(degree);
            double hypotenuse = (width / 2) / Math.cos(radians);
            //   double roofWidthRound = Math.floor(hypotenuse);
           double hypotenuseRound = Math.ceil((hypotenuse / 10) * 10);
            return hypotenuseRound;
        }
    }

    public static int getTopBattens(int length) throws CarportException {
        int topBattens = length / 420;
        if (length % 420 > 0) {
            topBattens += 1;
        }
        return topBattens;
    }

    public static double getInclineSheet(int width, int length, double degree) throws CarportException {
        double inclineSheetLength = getInclineLength(length, width, degree);

        double numberOfInclineSheet = ((inclineSheetLength * 4) / 480);
        if ((inclineSheetLength * 4) % 480 > 0) {
            numberOfInclineSheet += 1;
        }
        double numberOfInclineSheetRound =  Math.ceil((numberOfInclineSheet /10)*10);
        return  numberOfInclineSheetRound;
    }

    public static double getRoofMeterial(int width, int length, double degree) throws CarportException {
        double inclineSheetLength = getInclineLength(length, width, degree);
        int area;
        if (degree <= 0) {
            area = (width * length);
        } else if (degree >= 90) {
            throw new CarportException("This roof is not buildable");
        } else {
            area = (int) ((inclineSheetLength * length) * 2);
        }
        int meterial = (area / 10000);
        if (area % 100 > 0) {
            meterial += 2;
        }
        return meterial;

    }

    //------------------- BUILDING CALCULATIONS --------------------//
    public static int getSternPlanksCarport(int length) throws CarportException {
        int numberOfSternPlanksCarport = length / 600;
        if (length % 600 > 0) {
            numberOfSternPlanksCarport += 1;
        }
        return numberOfSternPlanksCarport*2;
    }

    public static int getVerticalPoles(int length) throws CarportException {
        int numberOfPoles = 1;
        numberOfPoles += length / 200;
        return numberOfPoles * 2;
    }

    public static int getHorizontalPolesLength(int length) throws CarportException {
        int poleLength = length / 300;
        if (poleLength % 300 > 0) {
            poleLength += 1;
        }
        return poleLength;
    }

    public static int getHorisontalPolesWidth(int width) throws CarportException {
        int poleWidth = width / 480;
        if (poleWidth % 480 > 0) {
            poleWidth += 1;
        }
        return poleWidth;
    }

}
