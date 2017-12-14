/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author DD
 */
public class PriceCalculation {

    /**
     * A simple method that calculates a price from an ArrayList
     * of PacklistObjects.
     * @param packlist
     * @return double 
     */
    public static double CalculatePrice(ArrayList<PacklistObject> packlist) {

        double price = 0;

        for (int i = 0; i < packlist.size(); i++) {
            price += packlist.get(i).getPrice();
        }

        return price;

    }
}
