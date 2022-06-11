import java.util.ArrayList;
import java.util.List;

public class Cart {
    
    int value;
    
    int[] CartList = new int[100];
    int index = 0;

    Biblioteka c = new Biblioteka();
    List<Produkty> products = c.selectProdukty();

    

    public void add(int id) {
        products = c.selectProdukty();
        boolean success = false; 
        for( Produkty element: products) {
            if (element.getId()==id) {
                if(element.getQuantity()>0){
                success = true;
                value += element.getPrice();
                CartList[index] = element.getId();
                index++;
                }else System.out.println("Currently we dont have this product!");
            }
        }
        if (success) {

            System.out.println("Product with id "+id+" added to the cart");
        }else System.out.println("Product not found!");
} 

     public void remove(int id) {
        products = c.selectProdukty();

        boolean found = false;
        for(int i = 0; i<index; i++){

            if(id == CartList[i]) {

                found = true;
                CartList[i] = -1;
                for( Produkty element: products) {
                    if (element.getId()==CartList[i]) {
                        value-=element.getPrice();
                    }
                    
                }
                System.out.println("Product with id "+id+" removed from the cart");
            }
        }
        if(found == false)System.out.println("Not found item with this id in cart!");
    }

    public void viewCart() {
        products = c.selectProdukty();
        System.out.println("Items in your cart:");
        System.out.println();
for(int i = 0; i<index; i++){
    if(CartList[i] != -1){
        int id = CartList[i];
        for( Produkty element: products) {
            if (element.getId()==id) {
                System.out.println(element.getId()+" | "+element.getProductName());
            }
        }
    }
    boolean found = false;
    for(int j = 0; j<index; j++){
        if(CartList[j] != -1) found = true;
    }
    if (found == false) System.out.println("Cart is empty!");

}
}

    void purchase(boolean Logged){
        if(Logged){
        products = c.selectProdukty();
        c.removeQuantity(CartList, index);
        for(int i = 0; i<index; i++){
            CartList [i] = -1;
    }
    index = 0;
    }else {System.out.println("Please login to commit purchase ");
    System.out.println();
}
}

    

}