  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  import java.util.LinkedList;
  import java.util.List;

  public class Biblioteka {
  
      public static final String DRIVER = "org.sqlite.JDBC";
      public static final String DB_URL = "jdbc:sqlite:biblioteka.db";
  
      private Connection conn;
      private Statement stat;
  
      public Biblioteka() {
          try {
              Class.forName(Biblioteka.DRIVER);
          } catch (ClassNotFoundException e) {
              System.err.println("Brak sterownika JDBC");
              e.printStackTrace();
          }
  
          try {
              conn = DriverManager.getConnection(DB_URL);
              stat = conn.createStatement();
          } catch (SQLException e) {
              System.err.println("Problem z otwarciem polaczenia");
              e.printStackTrace();
          }
  
          createTables();
      }
  
      public boolean createTables()  {
          String createKonta = "CREATE TABLE IF NOT EXISTS czytelnicy (username varchar(255) PRIMARY KEY, password varchar(255), accountBalance int, points int)";
          String createKsiazki = "CREATE TABLE IF NOT EXISTS Produkty (id INTEGER PRIMARY KEY AUTOINCREMENT, price int, productName varchar(255), productType varchar(255), quantity int)";
        try {
              stat.execute(createKonta);
              stat.execute(createKsiazki);
          } catch (SQLException e) {
              System.err.println("Blad przy tworzeniu tabeli");
              e.printStackTrace();
              return false;
          }
          return true;
      }
  
      public boolean insertKonta(String username, String password, int accountBalance, int points) {
          try {
              PreparedStatement prepStmt = conn.prepareStatement(
                      "insert into czytelnicy values (NULL, ?, ?, ?);");
              prepStmt.setString(1, username);
              prepStmt.setString(2, password);
              prepStmt.setInt(3, accountBalance);
              prepStmt.setInt(4, points);
              prepStmt.execute();
          } catch (SQLException e) {
              System.err.println("Blad przy wstawianiu Konta");
              e.printStackTrace();
              return false;
          }
          return true;
      }
  
      public boolean insertKsiazka(int price, String productName, String productType, int quantity) {
          try {
              PreparedStatement prepStmt = conn.prepareStatement(
                      "insert into ksiazki values (NULL, ?, ?, ?, ?);");
              prepStmt.setInt(1, price);
              prepStmt.setString(2, productName);
              prepStmt.setString(3, productType);
              prepStmt.setInt(4, quantity);
              prepStmt.execute();
          } catch (SQLException e) {
              System.err.println("Blad przy wypozyczaniu");
              return false;
          }
          return true;
      }
  
      public List<Konta> selectCzytelnicy() {
          List<Konta> czytelnicy = new LinkedList<Konta>();
          try {
              ResultSet result = stat.executeQuery("SELECT * FROM czytelnicy");
              int accountBalance, points;
              String username, password;
              while(result.next()) {
                username = result.getString("username");
                password = result.getString("password");
                accountBalance = result.getInt("accountBalance");
                points = result.getInt("points");
                  czytelnicy.add(new Konta(username, password, accountBalance, points));
              }
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
          return czytelnicy;
      }
  
      public List<Ksiazka> selectKsiazki() {
          List<Ksiazka> ksiazki = new LinkedList<Ksiazka>();
          try {
              ResultSet result = stat.executeQuery("SELECT * FROM ksiazki");
              int id;
              String tytul, autor;
              while(result.next()) {
                  id = result.getInt("id_ksiazki");
                  tytul = result.getString("tytul");
                  autor = result.getString("autor");
                  ksiazki.add(new Ksiazka(id, tytul, autor));
              }
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
          return ksiazki;
      }
  
      public void closeConnection() {
          try {
              conn.close();
          } catch (SQLException e) {
              System.err.println("Problem z zamknieciem polaczenia");
              e.printStackTrace();
          }
      }
  }