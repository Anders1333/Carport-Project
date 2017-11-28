
package FunctionLayer;

/**
 *
 * @author AndersHC
 */
public class CarportCalculator {

   
   
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
        int meterial = (area / 1000);
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
