import java.util.List;
  
  public class JdbcTest {
  
      public static void main(String[] args) {
          Biblioteka b = new Biblioteka();

    
  
          List<Konta> konta = b.selectKonta();
          List<Produkty> produkty = b.selectProdukty();
  
          System.out.println("Lista Kont: ");
          for(Konta c: konta)
              System.out.println(c);
  
          System.out.println("Lista produkty:");
          for(Produkty k: produkty)
              System.out.println(k);
  
          b.closeConnection();
      }
  }