import java.util.List;
  
  public class JdbcTest {
  
      public static void main(String[] args) {
          Biblioteka b = new Biblioteka();
          b.insertKonta("Admin", "Admin", 100, 20);
          b.insertKonta("Mati", "123", 10, 0);
          b.insertKonta("Kamil", "123", 20, 0);
  
          b.insertProdukty(100,"kask bialy", "helm",1,"aaa");
          b.insertProdukty(200,"pistolet", "bron",2,"bbb");
          b.insertProdukty(2000,"kamizelka duza", "kamizelki",2,"ccc");
  
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