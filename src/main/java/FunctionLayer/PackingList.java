/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author DD
 */
public class PackingList {
    
    //--- CarPort ---//
    private int inclineSheets;
    private int SternPlanksCarport;
    private int VerticalePoles;
    private int HorizontalPolesLength;
    private int HorizontalPolesWidth;
    private int TopBattens;
    
    //--- Roof ---//
    private int roofMeterial;

    public PackingList(int inclineSheets, int SternPlanksCarport, int VerticalePoles, int HorizontalPolesLength, int HorizontalPolesWidth, int TopBattens, int roofMeterial) {
        this.inclineSheets = inclineSheets;
        this.SternPlanksCarport = SternPlanksCarport;
        this.VerticalePoles = VerticalePoles;
        this.HorizontalPolesLength = HorizontalPolesLength;
        this.HorizontalPolesWidth = HorizontalPolesWidth;
        this.TopBattens = TopBattens;
        this.roofMeterial = roofMeterial;
    }
    
    
    
    
    
    
    
    
    
}
