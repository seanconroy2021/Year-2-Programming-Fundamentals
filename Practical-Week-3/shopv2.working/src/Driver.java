import java.util.Scanner;

/**
 * This class runs the application and handles the Product I/O
 *
 * @author Siobhan Drohan, Mairead Meagher
 * @version 1.0
 *
 */
public class Driver{

    private Scanner input = new Scanner(System.in);
    private Store store;  // this is the instance field

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
        driver.printProduct();
    }


    // new code - for v.2
    private void processOrder()
    {
        System.out.println("How many products would you like to have in your store?");
        int numberProducts = input.nextInt();

        store = new Store(numberProducts); // having problem with this pieace of code

        //this will use number of products and go around and enter in the details.
        for (int i = 0; i < numberProducts; i++){
            addProduct();
        }
    }
    //gather the product data from the user and create a new product object.
    private void addProduct(){
        input.nextLine();
        // this will fix the bug in the scanner class where push line together.
        // Note from moodle: there is a bug in Scanner. When you read an int and then do
        // a String read, Scanner ignores the String read. For this reason,
        // you need to put in a "dummy" read of
        // a String (i.e. input.nextLine() as the first line of code in the method).

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

        // this will return true/false
        boolean isAdded = store.add(new Product(productName, productCode, unitCost, inCurrentProductLine));
        if (isAdded) // is = to true it will.
        {
            System.out.println("Product  Added  Successfully");
        }
        else
        {
            System.out.println("No  Product  Added");
        }
    }

    //print the product (the toString method is automatically called).
    private void printProduct(){
        System.out.println(store.listProducts());
    }

}