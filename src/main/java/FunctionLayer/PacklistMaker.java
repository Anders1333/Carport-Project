/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.MaterialMapper;
import java.util.ArrayList;

/**
 *
 * @author DD
 */
public class PacklistMaker {

    public static ArrayList<PacklistObject> makePacklist(Carport carport) throws CarportException {

        ArrayList<PacklistObject> packList = new ArrayList<>();

        // ---- Basic skeleton ---- //
        packList.add(verticalPoles(carport));
        packList.add(rimsLong(carport));
        packList.add(baseRafters(carport));
        packList.add(sternBoardsUpperSides(carport));
        packList.add(sternBoardsLowerSides(carport));
        packList.add(waterBoardsSides(carport));
        
        // --- Roof dependent --- //
        packList.add(sternBoardsLowerShort(carport));
        packList.add(sternBoardsUpperShort(carport));
        packList.add(waterBoardsShort(carport));
        
        
        //--- Roofplates on flat roof --- //
        if(carport.getDegree()==0){
           packList.add(roofPlates(carport));
        }
       
        
        // ---- Shed ----//
        if(carport.getShedDepth()>0){
          packList.add(shedBoards(carport));
          packList.add(shedSkeletonPostsLong(carport));
          packList.add(shedSkeletonPostsShort(carport));
          packList.add(shedDoorLatch(carport));
        }
        
        // ---- Inclined Roof ----//
        if(carport.getDegree()>0){
          // packList.add(sternBoards(carport));
          // packList.add(windBoards(carport));
          // packList.add(roofBattens(carprot));
          // packList.add(waterBoards(carport));
          // packList.add(roofTiles(carport));
        
        }
        
       return packList; 
    }

//---------------------- Methods ------------------------//

    
    public static PacklistObject waterBoardsShort(Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 12;
        int boardAmount = 2;
        int boardLength = carport.getWidth();
        PacklistObject po = MaterialMapper.getMaterial(id, boardAmount, boardLength);
        return po;
    }
    
    public static PacklistObject waterBoardsSides(Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 12;
        int boardAmount = 2;
        int boardLength = carport.getLength();
        PacklistObject po = MaterialMapper.getMaterial(id, boardAmount, boardLength);
        return po;
    }
    
    public static PacklistObject shedDoorLatch (Carport carport) throws CarportException {
        CarportCalculator cc = new CarportCalculator();
        int id = 26;
        int amount = 1;
        double latchLength = cc.getShedLatchLength(carport);
        
        PacklistObject po = MaterialMapper.getMaterial(id, amount, latchLength);
        return po;
    }
    
    
    public static PacklistObject shedSkeletonPostsShort (Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 23;
        int skeletonPostsAmount = cc.getSkeletonPostsAmountShort(carport);
        double skeletonPostsLength = cc.getSkeletonPostsLengthShort(carport);
        
        PacklistObject po = MaterialMapper.getMaterial(id, skeletonPostsAmount, skeletonPostsLength);
        return po;
    }
    
    
    
    public static PacklistObject shedSkeletonPostsLong(Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 23;
        int skeletonPostsAmount = cc.getSkeletonPostsAmountLong(carport);
        double skeletonPostsLength = cc.getSkeletonPostsLengthLong(carport);
        
        PacklistObject po = MaterialMapper.getMaterial(id, skeletonPostsAmount, skeletonPostsLength);
        return po;
    }
    
    
    public static PacklistObject shedBoards (Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 12;
        int shedBoardsAmount = cc.getShedBoardsAmount(carport);
        int shedBoardsLength = cc.getShedBoardsLength(carport);
        
        PacklistObject po = MaterialMapper.getMaterial(id, shedBoardsAmount, shedBoardsLength);
        
        return po;
    }
    
    public static PacklistObject roofPlates (Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 36;
        double numberOfPlates  = cc.getRoofPlatesAmount(carport);
        double roofPlatesLength = cc.getRoofPlatesLength(carport);
        
        PacklistObject po = MaterialMapper.getMaterial(id, (int) numberOfPlates, roofPlatesLength);
        
        return po;
    }
    
    public static PacklistObject sternBoardsUpperSides (Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 17;
        int sternBoardsAmount = 2;
        int sternBoardsLength = carport.getLength();
        
        PacklistObject po = MaterialMapper.getMaterial(id, sternBoardsAmount, sternBoardsLength);
        return po;
    }
    
      
    public static PacklistObject sternBoardsUpperShort (Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 17;
        int sternBoardsAmount = 2;  // -1 if shed
        int sternBoardsLength = carport.getWidth();
        
        PacklistObject po = MaterialMapper.getMaterial(id, sternBoardsAmount, sternBoardsLength);
        return po;
    }
    
    public static PacklistObject sternBoardsLowerSides (Carport carport) throws CarportException{
        CarportCalculator cc = new CarportCalculator();
        int id = 20;
        int sternBoardsAmount = 2; 
        int sternBoardsLength = carport.getLength();
        
        PacklistObject po = MaterialMapper.getMaterial(id, sternBoardsAmount, sternBoardsLength);
        return po;
    }
    
    public static PacklistObject sternBoardsLowerShort(Carport carport) throws CarportException {
        CarportCalculator cc = new CarportCalculator();
        int id = 20;
        int sternBoardsAmount = 2;
        int sternBoardsLength = carport.getWidth();
        
        PacklistObject po = MaterialMapper.getMaterial(id, sternBoardsAmount, sternBoardsLength);
        return po;
    }
    
    public static PacklistObject baseRafters(Carport carport) throws CarportException {
      
        CarportCalculator cc = new CarportCalculator();
        int id = 35;
        int rafterAmount = cc.getRafterAmount(carport);
        int rafterLength = carport.getWidth();
                
        PacklistObject po = MaterialMapper.getMaterial(id, rafterAmount, rafterLength);
     return po;    
    }
    
    
    public static PacklistObject rimsLong(Carport carport) throws CarportException {
        CarportCalculator cc = new CarportCalculator();
        int id = 24;
        int rimAmount = cc.getHorizontalRimsLength(carport);
        int rimLength = 6;

        PacklistObject po = MaterialMapper.getMaterial(id, rimAmount, rimLength);
        return po;
    }

    public static PacklistObject verticalPoles(Carport carport) throws CarportException {
        CarportCalculator cc = new CarportCalculator();
        int id = 34;
        int verticalPolesAmount = cc.getVerticalPolesAmount(carport);
        
        if(carport.getShedDepth()>0){
           double deductPoles = Math.ceil(carport.getShedDepth()/200);
           verticalPolesAmount -= deductPoles;
        }
        verticalPolesAmount = verticalPolesAmount*2;
        
        double verticalPolesLengthInMeters = cc.getVerticalPolesLength(carport) / 100;

        PacklistObject po = MaterialMapper.getMaterial(id, verticalPolesAmount, verticalPolesLengthInMeters);
        return po;
    }

}
