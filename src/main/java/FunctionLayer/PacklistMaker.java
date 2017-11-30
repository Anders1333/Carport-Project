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
        packList.add(rimsWidth(carport));

        //---- Roof Materials ---- //
        //Sternbrædder
        //Vindskeder
        //
        return packList;
    }

//---------------------- Methods ------------------------//
    public static PacklistObject rimsWidth(Carport carport) throws CarportException {
        CarportCalculator cc = new CarportCalculator();
        int id = 24;
        int rimAmount = cc.getHorisontalRimsWidth(carport);
        // - 1 if shed
        int rimLength = 6;
        PacklistObject po = MaterialMapper.getMaterial(id, rimAmount, rimLength);
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
