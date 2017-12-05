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
        packList.add(sternBoardsUpperShort(carport));
        packList.add(sternBoardsLowerSides(carport));
        packList.add(sternBoardsLowerShort(carport));
        
       
        // ---- Shed ----//
        // skurbrædder
                 
        
        // tagplader
        // vandbræt
        
        // if(carport.getDegree()>0)

        //---- Roof Materials ---- //
        //Sternbrædder
        //Vindskeder
        //lægter
        
       return packList; 
    }

//---------------------- Methods ------------------------//
    
    
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
        //deduct some if shed
        double verticalPolesLengthInMeters = cc.getVerticalPolesLength(carport) / 100;

        PacklistObject po = MaterialMapper.getMaterial(id, verticalPolesAmount, verticalPolesLengthInMeters);
        return po;
    }

}
