/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FunctionLayer.ShedCalculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonas
 */
public class SheedTest {

    public SheedTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void getShedPoles() {
        System.out.println("ShedPolesTest");
        int poles = ShedCalculator.getShedPoles(600);

        int expResult = 8;

        assertEquals(expResult, poles);
    }
    
    @Test
    public void getFrameTest(){
        System.out.println("ShedFrameTest");
        int frames = ShedCalculator.getShedFrame(600);
        int expResult =2 ; 
        assertEquals(expResult, frames);
    }
}
