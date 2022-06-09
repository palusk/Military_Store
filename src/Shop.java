import java.util.Scanner;
import java.util.ArrayList;
public class Shop{

    ArrayList<Account> accountsList = new ArrayList<Account>();

public void menu(){

    System.out.println("Login - 1");
    System.out.println("Registration - 2");
    System.out.println("Products - 3");
    
    Scanner input = new Scanner(System.in);
    int key = input.nextInt();
    
    switch(key){
        
        case 1:
        System.out.println("You choose login section");
        log_in();
        break;
        
        case 2:
        System.out.println("You choose registration section");
        registration();
        break;
        
        case 3:
        System.out.println("You choose products section");
        produkty();
        break;

        default:
        break;
        
    }
    //////////////////////////////////////////////////////////////input.close();
   

}

public void registration() {
    Scanner input = new Scanner(System.in);
    System.out.println("REGISTRATION");
    System.out.println("LOGIN: ");
    String log = input.nextLine();
    System.out.println("PASSWORD: ");
    String pass = input.nextLine();
    accountsList.add(new Account(log,pass));
//System.out.println((accountsList.get(0)).username);
}

public void log_in() {
    Scanner input = new Scanner(System.in);
    System.out.println("LOGOWANIE");
    System.out.println("LOGIN: ");
    String log = input.nextLine();
    System.out.println("PASSWORD: ");
    String pass = input.nextLine();
    boolean success = false; 
    for( Account element: accountsList) {
        if (element.username.equals(log) && element.password.equals(pass)) {
            success = true;
        }
    }
    if (success) {
        System.out.println("Hello "+log+"!");
    }else System.out.println("Bad password or login!");
}



public void produkty(){
    Scanner input = new Scanner(System.in);
    System.out.println("1. Weapons");
    System.out.println("2. Cevlars");
    System.out.println("3. Helmets");
    System.out.println("4. Clothes");
    System.out.println("5. Accessories");
    int key2 = input.nextInt();
    switch(key2) {
        case 1:
        System.out.println("Weapons:");
        break;
        
        case 2:
        System.out.println("Cevlars:");
        break;
        
        case 3:
        System.out.println("Helmets:");
        break;

        case 4:
        System.out.println("Clothes:");
        break;

        case 5:
        System.out.println("Accessories:");
        break;

        default:
        break;
    }

}
}