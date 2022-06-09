import java.util.ArrayList;

public class Cart {
    
    int value;
    int index;
    ArrayList<Product> CartList = new ArrayList<Product>();

    public void add(Product prod) {

        if(prod.quantity>0){
        CartList.add(prod);
        System.out.println("Product added to the cart");
        value+=prod.price;
        index++;
        prod.quantity--;
    } else{
        System.out.println("Product is sold out!");
    }
}

    public void remove(Product prod) {

        CartList.remove(prod);
        prod.quantity++;
        index--;
    }

    public void viewCart() {
for(int i = 0; i<index; i++)
System.out.println(CartList.get(i).productName);
    
    if(index==0) System.out.println("Cart is empty");
}

}
