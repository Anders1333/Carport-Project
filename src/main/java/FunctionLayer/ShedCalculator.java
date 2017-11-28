/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author jonas
 */
public class ShedCalculator {

    public static int getShedPoles(int width) {
        int poles = 4;
        // 150 is the lenght between the poles
        poles += width / 150;
        if (width % 150 > 0) {
            poles += 1;
        }
        return poles;
    }

    public static int getShedFrame(int width) {
        int frames = 0;
        // 480 is the lenght of the planks used
        frames += width / 480;
        if (width % 480 > 0) {
            frames += 1;
        }
        return frames;
    }

}
