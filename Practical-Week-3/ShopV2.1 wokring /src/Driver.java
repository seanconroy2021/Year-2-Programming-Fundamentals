import java.util.Scanner;

/**
 * This class runs the application and handles the Product I/O
 *
 * @author Mairead Meagher, Siobhan Drohan
 * @version 2.0
 *
 */
public class Driver{

    private Scanner input = new Scanner(System.in);
    private Store store;

    /**
     * The main method is the starting point for the program.
     * When started, the main method calls the addProduct() method
     * followed by the printProduct() method.
     *
     * @param args  Any arguments for the main method
     */
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.processOrder();
        driver.printProducts();
        driver.printCurrentProducts();
        driver.printAverageProductPrice();
        driver.printCheapestProduct();
        driver.printProductsAboveAPrice();
    }


    // new code added to driver

    private void printCurrentProducts(){ // this will list all products in the system.
        System.out.println("List of CURRENT Products are:");
        System.out.println(store.ListCurrentProducts());
    }


    private void printCheapestProduct()
    {
        Product cheapestProduct = store.cheapestProduct();
        if(cheapestProduct==null){System.out.println("Sorry there is no products in the system !!!");}
        else
        {
            System.out.println("The cheapest product in the system is: "+cheapestProduct.getProductName());
        }
    }

    private void printAverageProductPrice()
    {
        double averagePrice = store.averageProductPrice();
        if(averagePrice == -1)
        {
            System.out.println("There are no products in the store");
        }
        else
        {
           System.out.println("The average product price is: "+averagePrice );
        }
    }

    private void printProductsAboveAPrice()
    {   double price;
        System.out.print("View the products costing more than this price:  ");
        price = input.nextDouble(); // ask a user to enter it send it back to the store class and check it against what in the system.
        System.out.println(store.listProductsAboveAPrice(price));
    }


    private void processOrder(){
        //find out from the user how many products they would like to order
        System.out.print("How many Products would you like to have in your Store?  ");
        int numberProducts = input.nextInt();

        store = new Store(numberProducts);

        //ask the user for the details of the products and add them to the order
        for (int i = 0; i < numberProducts; i++){
            addProduct();
        }
    }

    //gather the product data from the user and create a new product object.
    private void addProduct(){
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.

    	System.out.print("Enter the Product Name:  ");
        String productName = input.nextLine();
        System.out.print("Enter the Product Code:  ");
        int productCode = input.nextInt();
        System.out.print("Enter the Unit Cost:  ");
        double unitCost = input.nextDouble();

        //Ask the user to type in either a Y or an N.  This is then
        //converted to either a True or a False (i.e. a boolean value).
    	System.out.print("Is this product in your current line (y/n): ");
    	char currentProduct = input.next().charAt(0);
    	boolean inCurrentProductLine = false;
    	if ((currentProduct == 'y') || (currentProduct == 'Y'))
    		inCurrentProductLine = true;

        boolean isAdded = store.add(new Product(productName, productCode, unitCost, inCurrentProductLine));
        if (isAdded){
            System.out.println("Product Added Successfully");
        }
        else{
            System.out.println("No Product Added");
        }
    }
    
    //print the product (the toString method is automatically called).
    private void printProducts(){
    	System.out.println(store.listProducts());
    }

}