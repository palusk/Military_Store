import java.util.Scanner;
import java.util.List;

public class Shop{
    Biblioteka a = new Biblioteka();
    List<Konta> accountsList = a.selectKontaById();
    List<Produkty> products = a.selectProdukty();

public void print(String type){
    for( Produkty element: products) {
        if (element.getProductType().equals(type)) {
            System.out.println(element);
        }
    }
}

public void menu(){


          for(Konta c: accountsList)
              System.out.println(c);

    a.removeKonta("chujowysklep");
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
    
    a.insertKonta(log,pass,0,0);
    System.out.println("Successful registration, welcom to our family "+log);

}



public void log_in() {
    Scanner input = new Scanner(System.in);
    System.out.println("LOGOWANIE");
    System.out.println("LOGIN: ");
    String log = input.nextLine();
    System.out.println("PASSWORD: ");
    String pass = input.nextLine();
    boolean success = false; 
    for( Konta element: accountsList) {
        if (element.getUsername().equals(log) && element.getPassword().equals(pass)) {
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
    System.out.println();
    int key2 = input.nextInt();
    System.out.println();
    switch(key2) {
        case 1:
        System.out.println("Weapons:");
        System.out.println("1. Assault rifles");
        System.out.println("2. Pistols");
        System.out.println("3. Sniper rifles");
        System.out.println("4. Sniper rifles");
        System.out.println();
        key2 = input.nextInt();
        System.out.println();

switch(key2) {
case 1:
System.out.println("Assault rifles:");
print("bron");

key2 = input.nextInt();
System.out.println();
break;

case 2:
System.out.println("Pistols:");
key2 = input.nextInt();
System.out.println();
break;

case 3:
System.out.println("Sniper rifles:");
key2 = input.nextInt();
System.out.println();
break;

case 4:
System.out.println("Shotguns:");
key2 = input.nextInt();
System.out.println();
break;
}

        break;
        
        case 2:
        System.out.println("Cevlars:");
        System.out.println("1. Heavy cevlars");
        System.out.println("2. Normal cevlars");
        System.out.println("3. Lightweight cevlars");
        System.out.println();
        key2 = input.nextInt();
        System.out.println();

        switch(key2){
case 1:
System.out.println("Heavy cevlars:");
key2 = input.nextInt();
System.out.println();
break;

case 2:
System.out.println("Normal cevlars:");
key2 = input.nextInt();
System.out.println();
break;

case 3:
System.out.println("Lightweight cevlars:");
key2 = input.nextInt();
System.out.println();
break;

        }
        break;
        
        case 3:
        System.out.println("Helmets:");
        System.out.println("1. Balistic helmets");
        System.out.println("2. Industrial helmets");
        System.out.println();
        key2 = input.nextInt();
        System.out.println();

        switch(key2){
            case 1:
            System.out.println("Balistic helmets:");
            key2 = input.nextInt();
            System.out.println();
            break;
            
            case 2:
            System.out.println("Industrial helmets:");
            key2 = input.nextInt();
            System.out.println();
            break;
            
                    }

        break;

        case 4:
        System.out.println("Clothes:");
        System.out.println("1. Military uniforms");
        System.out.println("2. Camo uniforms");
        System.out.println();
        key2 = input.nextInt();
        System.out.println();

        switch(key2){
            case 1:
            System.out.println("Military uniforms:");
            key2 = input.nextInt();
            System.out.println();
            break;
            
            case 2:
            System.out.println("Camo uniforms:");
            key2 = input.nextInt();
            System.out.println();
            break; 
                    }

        break;

        case 5:
        System.out.println("Accessories:");
        System.out.println("1. Lotteries");
        System.out.println("2. Watches");
        System.out.println("3. Shawls");
        System.out.println();
        key2 = input.nextInt();
        System.out.println();

        switch(key2){
            case 1:
            System.out.println("Lotteries:");
            key2 = input.nextInt();
            System.out.println();
            break;
            
            case 2:
            System.out.println("Watches:");
            key2 = input.nextInt();
            System.out.println();
            break;
            
            case 3:
            System.out.println("Shawls:");
            key2 = input.nextInt();
            System.out.println();
            break;
            
                    }

        break;

        default:
        break;
    }

}
}