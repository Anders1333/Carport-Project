/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import FunctionLayer.CarportException;


/**
 *
 * @author jonas
 */
public class CarportCalculatorTest {
    
    public CarportCalculatorTest() {
    }
    
    @Before
    public void setUp() {
        
        
    }

    @Test
    public void testGetInclineLength1() throws Exception {
        System.out.println("getInclineLength");
        Carport carport = new Carport(300, 300, 35,1 ,50);
        double expResult = 151.0;
        double result = CarportCalculator.getInclineLength(carport);
        assertEquals(expResult, result, 0.0);
//        
    }

    @Test
    public void testGetTopBattens() throws CarportException {
        System.out.println("getTopBattens");
        Carport carport = new Carport(700, 300, 35,1 ,50);
        int expResult = 2;
        int result = CarportCalculator.getTopBattens(carport);
        assertEquals(expResult, result);
        
    }
   

    @Test
    public void testGetInclineSheet() throws Exception {
        System.out.println("getInclineSheet");
         Carport carport = new Carport(300, 300, 35,1 ,50);
        
        double expResult = 3;
        double result = CarportCalculator.getInclineSheet(carport);
        assertEquals(expResult, result, 0.0);
        
    }


}
