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
    //------ Stykliste variabler----//
    int length;
    int width;
    int height;
    int shedDepth;
    double roofIncline;

    public Order(int id, String username, double price, String date) {
        this.id = id;
        this.username = username;
        this.price = price;
        this.date = date;
    }

    public Order(int length, int width, int height, double roofIncline, int shedDepth) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.roofIncline = roofIncline;
        this.shedDepth = shedDepth;
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

    public int getShedDepth() {
        return shedDepth;
    }
    

    public double getRoofIncline() {
        return roofIncline;
    }

    @Override
    public String toString() {
        return "<h5>" + "ORDER INFO" + "</h5>"
                + "<strong><p>" + "Username: </strong>" + username
                + "<strong><p>" + "Price: </strong>" + price + ",-" + "</p>"
                + "<strong><p>" + "Date: </strong>" + date + "</p>"
                ;
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

   

}
