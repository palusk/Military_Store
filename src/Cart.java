import java.util.ArrayList;
import java.util.List;

public class Cart {
    
    int value;
    
    int[] CartList = new int[100];
    int index = 0;

    Biblioteka c = new Biblioteka();
    List<Produkty> products = c.selectProdukty();

    

    public void add(int id) {

        boolean success = false; 
        for( Produkty element: products) {
            if (element.getId()==id) {
                success = true;
                value += element.getPrice();
                CartList[index] = element.getId();
                index++;
            }
        }
        if (success) {

            System.out.println("Product with id "+id+" added to the cart");
        }else System.out.println("Product not found!");
} 

     public void remove(int id) {

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
}