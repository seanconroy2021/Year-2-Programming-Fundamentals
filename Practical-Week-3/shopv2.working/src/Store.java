public class Store {

    private Product[] products;
    private int total = 0;  // this will allow us to keep track of what is in store.

    public Store(int numberItems) {  // store constructor.
        products = new Product[numberItems];
    }

    public boolean isFull() {
        return (total == products.length);
    } // the == is same writing if else stat.

    public boolean isEmpty() {
        return (total == 0);

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

    // check if
    public String listProducts()
    {

        if(isEmpty() == false)
        {
                String result = "";
                for (int i = 0; i < total; i++){
                    result =  i + result + ": " + products[i] + "\n";
                }
                return result;

        }


       return "no products";
    } //toString


















}
