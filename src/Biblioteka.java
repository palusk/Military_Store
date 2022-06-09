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
          String createKonta = "CREATE TABLE IF NOT EXISTS konta (username varchar(255) PRIMARY KEY, password varchar(255), accountBalance int, points int)";
          String createProdukty = "CREATE TABLE IF NOT EXISTS Produkty (id INTEGER PRIMARY KEY AUTOINCREMENT, price int, productName varchar(255), productType varchar(255), quantity int, description varchar(255))";
        try {
              stat.execute(createKonta);
              stat.execute(createProdukty);
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
                      "insert into konta values (?, ?, ?, ?);");
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
  
      public boolean insertProdukty(int price, String productName, String productType, int quantity, String description) {
          try {
              PreparedStatement prepStmt = conn.prepareStatement(
                      "insert into produkty values (NULL, ?, ?, ?, ?, ?);");
              prepStmt.setInt(1, price);
              prepStmt.setString(2, productName);
              prepStmt.setString(3, productType);
              prepStmt.setInt(4, quantity);
              prepStmt.setString(5, description);
              
              prepStmt.execute();
          } catch (SQLException e) {
              System.err.println("Blad przy wypozyczaniu");
              return false;
          }
          return true;
      }
  
      public List<Konta> selectKonta() {
          List<Konta> konta = new LinkedList<Konta>();
          try {
              ResultSet result = stat.executeQuery("SELECT * FROM konta");
              int accountBalance, points;
              String username, password;
              while(result.next()) {
                username = result.getString("username");
                password = result.getString("password");
                accountBalance = result.getInt("accountBalance");
                points = result.getInt("points");
                  konta.add(new Konta(username, password, accountBalance, points));
              }
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
          return konta;
      }
  
      public List<Produkty> selectProdukty() {
          List<Produkty> produkty = new LinkedList<Produkty>();
          try {
              ResultSet result = stat.executeQuery("SELECT * FROM produkty");
              int id, price, quantity;
              String productName, productType, description;
              while(result.next()) {
                  id = result.getInt("id");
                  price = result.getInt("price");
                  productName = result.getString("productName");
                  productType = result.getString("productType");
                  quantity = result.getInt("quantity");
                  description = result.getString("description");

                  produkty.add(new Produkty(id, price, productName, productType, quantity, description));
              }
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
          return produkty;
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