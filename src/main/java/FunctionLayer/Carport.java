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
public class Carport {

    private int length;
    private int width;
    private int height;
    private double degree;
    private int shedDepth;

    public Carport(int length, int width, int height, double degree) {
        this(length, width, height, degree, 0);

    }

    public Carport(int length, int width, int height, double degree, int shedDepth) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.degree = degree;
        this.shedDepth = shedDepth;

    }

    public void setShedDepth(int shedDepth) throws CarportException {
        if (degree > 90) {
            throw new CarportException("The incline is too steep");
        } else {
            this.shedDepth = shedDepth;
        }
    }

    public int getShedDepth() {
        return shedDepth;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getDegree() {
        return degree;
    }

}
