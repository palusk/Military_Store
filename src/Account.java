public class Account {
    String username;
    String password;
    int accountBalance;
    boolean admin;
    int points;
    Cart userCart;
    
    public Account(String username, String password) {
        this.password = password;
        this.username = username;
    }
}