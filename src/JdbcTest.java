import java.util.List;
  
  public class JdbcTest {
  
      public static void main(String[] args) {
          Biblioteka b = new Biblioteka();
          b.insertKonta("Karol", "Maciaszek", 0, 0);
          b.insertKonta("Piotr", "Wojtecki", 0, 0);
          b.insertKonta("Abdul", "Dabdul", 0, 0);
  
          b.insertKsiazka("Cień Wiatru", "Carlos Ruiz Zafon");
          b.insertKsiazka("W pustyni i w puszczy", "Henryk Sienkiewicz");
          b.insertKsiazka("Harry Potter", "Joanne Kathleen Rowling.");
  
          List<Konta> czytelnicy = b.selectCzytelnicy();
          List<Ksiazka> ksiazki = b.selectKsiazki();
  
          System.out.println("Lista Kont: ");
          for(Konta c: czytelnicy)
              System.out.println(c);
  
          System.out.println("Lista książek:");
          for(Ksiazka k: ksiazki)
              System.out.println(k);
  
          b.closeConnection();
      }
  }