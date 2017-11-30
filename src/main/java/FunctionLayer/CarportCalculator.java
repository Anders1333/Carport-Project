
package FunctionLayer;

/**
 *
 * @author AndersHC
 */
public class CarportCalculator {

   
   
//----------------- ROOF CALCULATIONS ------------------------------//

    public static double getInclineLength(Carport carport) throws CarportException {

        if (carport.getDegree()<= 0) {
            return carport.getLength() * carport.getWidth();
        } else if (carport.getDegree() >= 90) {
            throw new CarportException("This roof is not buildable.");
        } else {
            double radians = Math.toRadians(carport.getDegree());
            double hypotenuse = (carport.getWidth() / 2) / Math.cos(radians);
            //   double roofWidthRound = Math.floor(hypotenuse);
           double hypotenuseRound = Math.ceil((hypotenuse / 10) * 10);
            return hypotenuseRound;
        }
    }

    public static int getTopBattens(Carport carport) throws CarportException {
        int topBattens = carport.getLength() / 420;
        if (carport.getLength()% 420 > 0) {
            topBattens += 1;
        }
        return topBattens;
    }

    public static double getInclineSheet(Carport carport) throws CarportException {
        double inclineSheetLength = getInclineLength(carport);

        double numberOfInclineSheet = ((inclineSheetLength * 4) / 480);
        if ((inclineSheetLength * 4) % 480 > 0) {
            numberOfInclineSheet += 1;
        }
        double numberOfInclineSheetRound =  Math.ceil((numberOfInclineSheet /10)*10);
        return  numberOfInclineSheetRound;
    }

    public static double getRoofMeterial(Carport carport) throws CarportException {
        double inclineSheetLength = getInclineLength(carport);
        int area;
        if (carport.getDegree() <= 0) {
            area = (carport.getWidth() * carport.getLength());
        } else if (carport.getDegree() >= 90) {
            throw new CarportException("This roof is not buildable");
        } else {
            area = (int) ((inclineSheetLength * carport.getLength()) * 2);
        }
        int meterial = (area / 1000);
        if (area % 100 > 0) {
            meterial += 2;
        }
        return meterial;

    }
 
    //------------------- BUILDING CALCULATIONS --------------------//
    public static int getSternPlanksCarport(Carport carport) throws CarportException {
        int numberOfSternPlanksCarport = carport.getLength() / 600;
        if (carport.getLength() % 600 > 0) {
            numberOfSternPlanksCarport += 1;
        }
        return numberOfSternPlanksCarport*2;
    }

    public static int getVerticalPolesAmount(Carport carport) throws CarportException {
        int numberOfPoles = 1;
        numberOfPoles += carport.getLength() / 200;
        return numberOfPoles * 2;
    }
    
    public static int getVerticalPolesLength(Carport carport) throws CarportException{
        return carport.getHeight()+70;
    }

    public static int getHorizontalRimsLength(Carport carport) throws CarportException {
        int rimAmount = carport.getLength() / 600;
        if (rimAmount % 600 > 0) {
            rimAmount += 1;
        }
        return rimAmount;
    }

    public static int getHorisontalRimsWidth(Carport carport) throws CarportException {
        int poleWidth = carport.getWidth() / 480;
        if (poleWidth % 480 > 0) {
            poleWidth += 1;
        }
        return poleWidth;
    }

}
