/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author AndersHC
 */
public class Order {
    int id;
    String username;
    double price;
    String date;
    String status;
    //------ Stykliste variabler----//
    int length;
    int width;
    int height;
    double roofIncline;
    

    public Order(int id, String username, double price, String date, String status) {
        this.id = id;
        this.username = username;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public Order(int length, int width, int height, double roofIncline) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.roofIncline = roofIncline;
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

    public double getRoofIncline() {
        return roofIncline;
    }
    

    @Override
    public String toString() {
        return "Oder Info:  " + "  ID: " +id+ "  Username: " +username+ "  Price: " +price+ "kr." + "  Date: " +date+ "  Status: " +status;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
