
package FunctionLayer;

/**
 *
 * @author AndersHC
 */
public class PacklistObject {
    
    String name;
    double length;
    int amount;
    String unit;
    String description;
    double price;

    public PacklistObject(String name, double length, int amount, String unit, String description, double price) {
        this.name = name;
        this.length = length;
        this.amount = amount;
        this.unit = unit;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "  " + length +"  "+ amount +"  "+ unit +"  "+ description;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice(){
        return price;
    }
}
