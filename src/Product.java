/* Matt Nguyen
   Chinemerem Anunkor
     March 5, 2020
     Purpose: This purpose of this java class is to serve as the products
     Inputs:
     Output:
*/


/**
 * setting privates
 */
public class Product {
    private String description;
    private double price;
    private int quantity;

    /**
     * setting the product's quality
     */
    public Product() {
        this.description = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    /**
     *
     * @param description
     * @param price
     * @param quantity
     */
    public Product(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     *
     * @return the description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price, set the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return the quantity of the items
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return the String in the format
     */
    @Override
    public String toString() {
        return "Product [description=" + description + ", price=" + price + ", quantity=" + quantity + "]";
    }
}
