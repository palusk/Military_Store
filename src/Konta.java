public class Konta {
    private String username;
    private String password;
    private int accountBalance;
    private int points;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public Konta() { }
    public Konta(String username, String password, int accountBalance, int points) {
        this.username = username;
        this.password = password;
        this.accountBalance = accountBalance;
        this.points = points;
    }

    @Override
    public String toString() {
        return "["+username+"] - "+password+" "+accountBalance+" - "+points;
    }
}