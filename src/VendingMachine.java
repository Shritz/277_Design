/* Matt Nguyen
   Chinemerem Anunkor
     March 5, 2020
     Purpose: This purpose of this java class is to serve as the VendingMachine
     Inputs:
     Output:
*/


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class VendingMachine {
    private List<Product> productList = null;
    private double coinValueAvailable;

    /**
     *
     */
    public VendingMachine() {
        productList = new ArrayList<Product>();
        coinValueAvailable = 0.0;
    }

    /**
     *
     * @param product
     */
    public void addProduct(Product product) {
        productList.add(product);
    }

    /**
     *
     * @return
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     *
     * @param product
     * @return
     */
    public boolean buyProduct(Product product) {
        if (product.getPrice() > coinValueAvailable) {
            return false;
        }
        int newQuantity = product.getQuantity() - 1;
        if (newQuantity == 0) {
            productList.remove(product);
        } else {
            product.setQuantity(newQuantity);
        }
        coinValueAvailable-=product.getPrice();
        return true;
    }

    /**
     *
     * @param amount
     */
    public void addCoin(double amount) {
        coinValueAvailable+=amount;
    }

    /**
     *
     * @return
     */
    public double removeCoins() {
        double coinValueLeft = coinValueAvailable;
        this.coinValueAvailable = 0.0;
        return coinValueLeft;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "VendingMachine [productList=" + productList + ", coinValueAvailable=" + coinValueAvailable + "]";
    }


}
