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
//    @Test (expected = CarportException.class)
//    public void testGetInclineLength2() throws CarportException{ 
//        Carport carport = new Carport(300, 300, 91,1 ,50);
//        double expResult = 151.0;
//        double result = CarportCalculator.getInclineLength(carport);
//       
//        
//    }

//    @Test
//    public void testGetTopBattens() throws CarportException {
//        System.out.println("getTopBattens");
//        Carport carport = new Carport(300, 300, 35,1 ,50);
//        int expResult = 0;
//        int result = CarportCalculator.getTopBattens(carport);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetInclineSheet() throws Exception {
//        System.out.println("getInclineSheet");
//        Carport carport = null;
//        double expResult = 0.0;
//        double result = CarportCalculator.getInclineSheet(carport);
//        assertEquals(expResult, result, 0.0);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetRoofMeterial() throws Exception {
//        System.out.println("getRoofMeterial");
//        Carport carport = null;
//        double expResult = 0.0;
//        double result = CarportCalculator.getRoofMeterial(carport);
//        assertEquals(expResult, result, 0.0);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetRafterAmount() {
//        System.out.println("getRafterAmount");
//        Carport carport = null;
//        int expResult = 0;
//        int result = CarportCalculator.getRafterAmount(carport);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetSternPlanksCarport() throws Exception {
//        System.out.println("getSternPlanksCarport");
//        Carport carport = null;
//        int expResult = 0;
//        int result = CarportCalculator.getSternPlanksCarport(carport);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetVerticalPolesAmount() throws Exception {
//        System.out.println("getVerticalPolesAmount");
//        Carport carport = null;
//        int expResult = 0;
//        int result = CarportCalculator.getVerticalPolesAmount(carport);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetVerticalPolesLength() throws Exception {
//        System.out.println("getVerticalPolesLength");
//        Carport carport = null;
//        int expResult = 0;
//        int result = CarportCalculator.getVerticalPolesLength(carport);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetHorizontalRimsLength() throws Exception {
//        System.out.println("getHorizontalRimsLength");
//        Carport carport = null;
//        int expResult = 0;
//        int result = CarportCalculator.getHorizontalRimsLength(carport);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//    
}
