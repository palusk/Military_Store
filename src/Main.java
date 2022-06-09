public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Cart koszyk = new Cart();
        Helmet produkt = new Helmet(100, 1, "helm1", 2);
        Helmet produkt2 = new Helmet(100, 2, "helm2", 3);
        Helmet produkt3 = new Helmet(100, 3, "helm3", 5);

        koszyk.viewCart();
       
        koszyk.add(produkt2);
        koszyk.add(produkt3);
        koszyk.viewCart();
        System.out.println("remove:");
        koszyk.remove(produkt2);
        koszyk.viewCart();

        //Frame window = new Frame();
        while(true) {
        shop.menu();
       }
       //shop.input.close();
    }
}
