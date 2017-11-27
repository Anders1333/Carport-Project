/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.MaterialMapper;
import javafx.scene.paint.Material;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author DD
 */
public class PriceCalculation {
    
    public static double getTotalPrice(Carport carport) throws CarportException{
    
    double inclineSheets = MaterialMapper.getPrice(18)* carport.getInclineSheets();
   // double roofMeterial = MaterialMapper.getPrice(0) //mangler i DB
    double topBatten = MaterialMapper.getPrice(26)* carport.getTopBattens();
    double SternSheet = MaterialMapper.getPrice(18) * carport.getSternPalnksCarport();
    // double verticalPoles = MaterialMapper.getPrice(0) //mangler i DB
    // double horizontalPolesLength = MaterialMapper.getPrice(0) //mangler i DB
    // double horizontalPolesWidth = MaterialMapper.getPrice(0) //mangler i DB
    
    double carportTotalPrice = inclineSheets+topBatten+SternSheet;
        
    return carportTotalPrice;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
