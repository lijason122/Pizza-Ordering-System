package jason_li_project1.model;

/**
 * This class represents the type of the pizza
 *
 * @author Jason Li
 */
public class Pizza {

    // Create private data fields
    private int size;
    private String[] toppings;

    /**
     * This is a constructor of pizza
     *
     * @param size the number of size
     * @param toppings the array of string toppings
     */
    public Pizza(int size, String[] toppings) {
        this.size = size;
        this.toppings = toppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * this method finds the correct size string of the pizza
     *
     * @return the correct size of string with the specified size number
     */
    public String getSizeString() {
        switch (size) {
            case 1:
                return "Small";
            case 2:
                return "Medium";
            default:
                return "Large";
        }
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }
}
