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
public class PriceCalculation {

    public static double CalculatePrice(ArrayList<PacklistObject> packlist) {

        double price = 0;

        for (int i = 0; i < packlist.size(); i++) {
            price += packlist.get(i).getPrice();
        }

        return price;

    }
}
