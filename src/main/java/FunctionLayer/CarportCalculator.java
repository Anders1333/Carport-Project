package FunctionLayer;

/**
 *
 * @author AndersHC
 */
public class CarportCalculator {

//----------------- ROOF CALCULATIONS ------------------------------//
    
    public static int getRoofTiles(Carport carport) throws CarportException{
        double areaToCoverOneSide = getInclineLength(carport)*carport.getLength();
        double fullArea = areaToCoverOneSide*2;
        double numberOfTiles = Math.ceil(fullArea/900);
        
        return (int) numberOfTiles;
        
    }
    
    
    public static int getRoofRafterAmount(Carport carport) throws CarportException{
        double lengthToCover = getInclineLength(carport)*2;
        double boardsNeeded = Math.ceil(lengthToCover/30);
        return (int) boardsNeeded;
    }
    
    
    public static int getGableBoardAmount (Carport carport) throws CarportException{
        double baseLine = carport.getWidth();
        double halfHeight = (getRoofHeight(carport)/2);
        double areaToCover = halfHeight*baseLine;
        double oneBoardCover = 10*200;
        double boardAmountBottom = Math.ceil(areaToCover/oneBoardCover);
        double boardAmountTotal = Math.ceil(boardAmountBottom*1.5);
        return (int) boardAmountTotal;
    }
    
    public static double getRoofHeight (Carport carport) throws CarportException{
        if(carport.getDegree()>=90){
            throw new CarportException("Dette tag kan ikke bygges");
        }else{
        
        double radians = Math.toRadians(carport.getDegree());
        double height = Math.sin(radians)*getInclineLength(carport);
        return height;
    }
      
    }

    public static double getInclineLength(Carport carport) throws CarportException {

        if (carport.getDegree() <= 0) {
            return carport.getLength() * carport.getWidth();
        } else if (carport.getDegree() >= 90) {
            throw new CarportException("Dette tag kan ikke bygges");
        } else {
            double radians = Math.toRadians(carport.getDegree());
            double hypotenuse = (carport.getWidth() / 2) / Math.cos(radians);
            double hypotenuseRound = Math.ceil((hypotenuse / 10) * 10);
            return hypotenuseRound;
        }
    }

    public static int getTopBattens(Carport carport) throws CarportException {
        int topBattens = carport.getLength() / 420;
        if (carport.getLength() % 420 > 0) {
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
        double numberOfInclineSheetRound = Math.ceil((numberOfInclineSheet / 10) * 10);
        return numberOfInclineSheetRound;
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
    
    
    
    public static double getSkeletonPostsLengthShort(Carport carport){
        double postLength = (carport.getShedDepth())*0.8;
        return postLength;
        
    }
    
    
    public static int getSkeletonPostsAmountShort(Carport carport){
        int postAmount = 4;
        return postAmount;
    }
    
    
    public static double getSkeletonPostsLengthLong(Carport carport){
        double postLength = (carport.getWidth()-60)/2;
        return postLength;
    }
    
    public static int getSkeletonPostsAmountLong(Carport carport){
        int postAmount = 12; 
                
                return postAmount;
    }
    
    
    
    public static int getShedBoardsLength(Carport carport){
        double shedBoardsLength = carport.getHeight()-20;
        return (int) shedBoardsLength;
    }
    
    
    
    public static int getShedBoardsAmount(Carport carport){
        double numberOfBoardsLong = (((carport.getWidth())-60)/10);
        double numberOfBoardsShort = (((carport.getShedDepth())-20)/10);
        double totalNumberOfBoards = (numberOfBoardsLong+numberOfBoardsShort)*1.5;
        
        return (int) totalNumberOfBoards;
    }
    
    public static double getRoofPlatesAmount(Carport carport){
        double numberOfPlates = carport.getWidth()/90;
        
        double realNumber = Math.ceil(numberOfPlates);
        
        return realNumber;
    }
    
    
    
    public static double getRoofPlatesLength(Carport carport){
        double roofPlatesLength = carport.getLength();
        
        
        return roofPlatesLength;
        
    }
    
    public static int getRafterAmount(Carport carport){
        if(carport.getDegree()>0){
            int numberOfRafters = carport.getLength()/89;
            if(carport.getLength() % 89 > 40){
                numberOfRafters += 1;
            }
           return numberOfRafters;  
        }
        
        int numberOfRafters = carport.getLength() /55;
        if (carport.getLength() % 55 > 30){
            numberOfRafters += 1;
        }
        return numberOfRafters;
    }
    

    public static int getSternPlanksCarport(Carport carport) throws CarportException {
        int numberOfSternPlanksCarport = carport.getLength() / 600;
        if (carport.getLength() % 600 > 0) {
            numberOfSternPlanksCarport += 1;
        }
        return numberOfSternPlanksCarport * 2;
    }

    public static int getVerticalPolesAmount(Carport carport) throws CarportException {
        int numberOfPoles = 1;
        numberOfPoles += carport.getLength() / 200;
        return numberOfPoles;
    }

    public static int getVerticalPolesLength(Carport carport) throws CarportException {
        return carport.getHeight() + 70;
    }

    public static int getHorizontalRimsLength(Carport carport) throws CarportException {
        int rimAmount = carport.getLength() / 600;
        if (rimAmount % 600 > 0) {
            rimAmount += 1;
        }
        return rimAmount;
    }

    double getShedLatchLength(Carport carport) {
        double latchLength = carport.getWidth()*0.8;
        return latchLength;
    }



}
