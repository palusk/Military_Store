  public class Produkty {
      private int id;
      private int price;
      private String productName;
      private String productType;
      private int quantity;
      private String description;
  
      public int getId() {
          return id;
      }
      public void setId(int id) {
          this.id = id;
      }
      public int getPrice() {
          return price;
      }
      public void setPrice(int price) {
          this.price = price;
      }
      public String getProductName() {
          return productName;
      }
      public void setProductName(String productName) {
          this.productName = productName;
      }
      public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
  
      public Produkty() {}
      public Produkty(int id, int price, String productName, String productType, int quantity, String description) {
          this.id = id;
          this.price = price;
          this.productName = productName;
          this.productType = productType;
          this.quantity = quantity;
          this.description = description;
      }
  
      @Override
      public String toString() {
          return "["+id+"] - "+price+" - "+productName+" - "+productType+" - "+quantity+" - "+description;
      }
  }