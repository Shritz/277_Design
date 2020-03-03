/* Matt Nguyen
   Chinemerem Anunkor
     March 5, 2020
     Purpose: This purpose of this java class is to serve as the tester class
     Inputs:
     Outputs:
*/


import java.util.List;
import java.util.Scanner;

public class VendingMachineRunner {
    public static void main(String args[]) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner input = new Scanner(System.in);
        List<Product> productList;
        char choice;
        do {
            showMenu();
            choice = input.next().toLowerCase().charAt(0);
            switch (choice) {
                case 's':
                    productList = vendingMachine.getProductList();
                    printProductList(productList);
                    break;
                case 'i':
                    insertCoin(vendingMachine, input);
                    break;
                case 'b':
                    buyProduct(vendingMachine, input);
                    break;
                case 'a':
                    addProduct(vendingMachine, input);
                    break;
                case 'r':
                    double coinValue = vendingMachine.removeCoins();
                    System.out.println("Removed: $"+coinValue);
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Invalid choice entered! Try again!");
                    break;

            }
        } while (choice != 'q');
        input.close();
    }

    public static void showMenu() {
        System.out.println("S)how products I)nsert coin B)uy A)dd product R)emove coins Q)uit");
    }

    public static void printProductList(List<Product> productList) {
        for (Product p : productList) {
            System.out.println(p.getDescription()+ " @ $"+p.getPrice());
        }
    }

    public static void buyProduct(VendingMachine vendingMachine, Scanner input) {
        List<Product> productList = vendingMachine.getProductList();
        if (productList.size() == 0) {
            System.out.println("No products available");
            return;
        }
        int count = 0;
        for (Product p : productList) {
            System.out.print((char)('A'+count++)+")");
            System.out.print(p.getDescription()+ " @ $"+p.getPrice()+"\n");
        }
        char productChoice = input.next().toLowerCase().charAt(0);
        int index = productChoice - 'a';
        if (index >= productList.size()) {
            System.out.println("Invalid choice entered");
            return;
        }
        Product selectedProduct = productList.get(index);
        boolean isPurchaseSuccessful = vendingMachine.buyProduct(selectedProduct);
        if (isPurchaseSuccessful) {
            System.out.println("Purchased: "+selectedProduct.getDescription()+" @ $"+selectedProduct.getPrice());
        } else {
            System.out.println("Insufficient money");
        }

    }

    public static void insertCoin(VendingMachine vendingMachine, Scanner input) {
        System.out.println("A) nickel @ 0.05\n" +
                "B) dime @ 0.1\n" +
                "C) quarter @ 0.25\n" +
                "D) dollar @ 1.0");
        char coinChoice = input.next().toLowerCase().charAt(0);
        switch(coinChoice) {
            case 'a':
                vendingMachine.addCoin(0.05);
                break;
            case 'b':
                vendingMachine.addCoin(0.1);
                break;
            case 'c':
                vendingMachine.addCoin(0.25);
                break;
            case 'd':
                vendingMachine.addCoin(1.0);
                break;
            default:
                System.out.println("Invalid coin choice");
        }
    }

    public static void addProduct(VendingMachine vendingMachine, Scanner input) {
        System.out.println("Description:");
        String desc = input.next();
        System.out.println("Price:");
        double price = input.nextDouble();
        System.out.println("Quantity:");
        int quantity = input.nextInt();
        vendingMachine.addProduct(new Product(desc, price, quantity));
    }

}
