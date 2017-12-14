/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.CarportCalculator;
import FunctionLayer.CarportException;
import FunctionLayer.PacklistMaker;
import FunctionLayer.PacklistObject;
import java.util.ArrayList;

/**
 *
 * @author AndersHC
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CarportException {
        Carport carport1 = new Carport(780,400,300,45.0,0);
        Carport carport2 = new Carport(780,400,300,30.0,200);
        Carport carport3 = new Carport(780,400,300,20.0,400);

    
     ArrayList<PacklistObject> list = new ArrayList();
     
  
     
     int length = 800;
     int rest = 800%89;
     
        System.out.println(rest);
     
       
     
    
 
    
}
}
