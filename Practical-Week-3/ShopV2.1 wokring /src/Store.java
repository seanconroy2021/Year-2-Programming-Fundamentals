/**
 * The store class saves all the entered products into a primitive array.
 *
 * @author Mairead Meagher, Siobhan Drohan
 * @version 2.0
 */

public class Store {

    private Product[] products;
    private int total = 0;  //dual purpose. 1) number of items stored in array, 2) next available index location

    public Store(int numberItems){
        products = new Product[numberItems];
    }

    private boolean isFull(){
        return total == products.length;
    }

    private boolean isEmpty(){
        return total == 0;
    }

    /**
     *  If there is space available, add the product object, passed as a parameter, to the array.
//     * @param product  Product object to be added to the array.
     * @return Status of the add; true for success, false for fail.
     */


    // new code

    public String ListCurrentProducts()
    {
        if (isEmpty())
        {
            return"No products in the store";
        }

        else
        {
            String text="";
            for (int i =0; i<total; i++)
            {
                text = text + i + " : "+products[i]+"\n";
            }

            return text;
        }
    }

    public Product cheapestProduct()
    {
        if (isEmpty() == false) {


            Product cheapProduct = products[0];// so we first need something to compare the cheapest unit cost
            for (int i = 0; i < total; i++) {
                if (products[i].getUnitCost() < cheapProduct.getUnitCost()) {
                    cheapProduct = products[i]; // this statement is correct it will update and change next lowest number.
                }
                return cheapProduct;

            }
        }
        return null;
    }

    public double averageProductPrice()
    {
        if (isEmpty() == true) {
            return -1;
        }
        else
        {
            double unitCostAdded=0;
            for (int i = 0; i < total; i++)
            {unitCostAdded = unitCostAdded + products[i].getUnitCost();}
            return unitCostAdded / total;
        }

    }

    public String listProductsAboveAPrice(double price) {
        if (isEmpty() == true) //isEmpty() it is the same without the == true
        {
            return "No products in the store";
        } else {
            String result = "";
            for (int i = 0; i < total; i++) {
                if (products[i].getUnitCost() >= price)
                {
                    result = "Product" + i + " : " + products[i] + "\n";

                }

            }

            if (result.equals(""))
            {
                return "No Product cost as much as " + price;
            }
            else return result;
            }
        }



        public boolean add(Product product){
        if (isFull()){
            return false;
        }
        else{
            products[total] = product;
            total++;
            return true;
        }
    }

    /**
     * This method builds and returns a String containing all the products in the array.
     * For each product in the array, the associated index number is included.
     * If no products are stored in the array, the String "No products" is returned.
     *
     * @return  A String containing all the products in the array, or "No products in the store", if empty.
     */
    public String listProducts(){
        if (isEmpty()){
            return "No products in the store";
        }
        else{
            String listOfProducts = "";
            for (int i = 0; i < total; i++){
                listOfProducts = listOfProducts + i + ": " + products[i] + "\n";
            }
            return listOfProducts;
        }
    }

}
