import java.util.Scanner;
import java.util.ArrayList;
public class Shop{
    ArrayList<Account> accountsList = new ArrayList<Account>();
public void menu(){


    System.out.println("Logowanie - 1");
    System.out.println("Rejestracja - 2");
    System.out.println("Produkty - 3");
    Scanner input = new Scanner(System.in);
    int key = input.nextInt();
    
    switch(key){
        
        case 1:
        System.out.println("wybrano logowanie");
        log_in();
        break;
        
        case 2:
        System.out.println("wybrano rejestracje");
        registration();
        System.out.println((accountsList.get(0)).username);
        break;
        
        case 3:
        System.out.println("wybrano produkty");
        break;

        default:
        System.out.println((accountsList.get(0)).username);
        break;
        
    }
    //////////////////////////////////////////////////////////////input.close();
   

}

public void registration(){
Scanner input = new Scanner(System.in);
System.out.println("REGISTRATION");
System.out.println("LOGIN: ");
String log = input.nextLine();
System.out.println("PASSWORD: ");
String pass = input.nextLine();
accountsList.add(new Account(log,pass));
//System.out.println((accountsList.get(0)).username);
}

public void log_in()
{
    Scanner input = new Scanner(System.in);
    System.out.println("LOGOWANIE");
    System.out.println("LOGIN: ");
    String log = input.nextLine();
    System.out.println("PASSWORD: ");
    String pass = input.nextLine();
    boolean success = false; 
    for( Account element: accountsList)
    {
        if (element.username.equals(log) && element.password.equals(pass)){
            success = true;
        }
    }
    if (success){
        System.out.println("Hello "+log+"!");
    }else System.out.println("Bad password or login!");
}

}