import java.util.Scanner;
import java.util.List;

public class Shop{
    Biblioteka a = new Biblioteka();
    List<Konta> accountsList = a.selectKontaById();
    List<Produkty> products = a.selectProdukty();

   
    Account admin = new Account("admin","admin");
    Account LoggedUser = admin;
    

public void print(String type){
    for( Produkty element: products) {
        if (element.getProductType().equals(type)) {
            System.out.println(element);
        }
    }
}
public void buy(String type){
    Scanner input = new Scanner(System.in);
    System.out.println("Insert id to add to cart or anything else to exit this section");
    int id = input.nextInt();
    
    


    boolean success = false; 
    for( Produkty element: products) {
        if ((element.getProductType()).equals(type)&&element.getId()==id) {
            LoggedUser.userCart.add(id);
            System.out.println("Item with id "+id+" added to the cart.");
            success = true;
        }
    }
    if (success == false) System.out.println("Wrong id!");
}
public void buyMenu(String type){
System.out.println(type+":");
print(type);
buy(type);
}
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
    
    System.out.println("1. Weapons");       System.out.println("2. Military Vests");        System.out.println("3. Helmets");       System.out.println("4. Military Clothes");       System.out.println("5. Accessories");    System.out.println("6. Backpacks");   System.out.println();
    int mainType = input.nextInt();
    System.out.println();
    
    switch(mainType) {
        case 1:
            System.out.println("Weapons:");     System.out.println("1. Assault rifles");     System.out.println("2. Pistols");   System.out.println("3. Sniper rifles");     System.out.println("4. Machine pistols");       System.out.println("5. Shotguns");        System.out.println();
            int Type = input.nextInt();
            System.out.println();

            switch(Type) {
            case 1:
            buyMenu("Assault rifles");
            break;

            case 2:
            buyMenu("Pistols");
            break;

            case 3:
            buyMenu("Sniper rifles");
            break;

            case 4:
            buyMenu("Machine pistols");
            break;

            case 5:
            buyMenu("Shotguns");
            break;
            }break;
        
        case 2:
            System.out.println("Military Vests:");      System.out.println("1. Heavy Vests");       System.out.println("2. Normal Vests");      System.out.println("3. Lightweight Vests");     System.out.println();
            Type = input.nextInt();
            System.out.println();

            switch(Type){
            case 1:
            buyMenu("Heavy Vests");
            break;

            case 2:
            buyMenu("Normal Vests");
            break;

            case 3:
            buyMenu("Lightweight Vests");
            break;

            }break;
        
        case 3:
            System.out.println("Helmets:");      System.out.println("1. Balistic helmets");     System.out.println("2. Tactical helmets");      System.out.println();
            Type = input.nextInt();
            System.out.println();

            switch(Type){
            case 1:
            buyMenu("Balistic helmets");
            break;
            
            case 2:
            buyMenu("Tactical helmets");
            break;
            
            }break;

        case 4:
            System.out.println("Military Clothes:");     System.out.println("1. Military uniforms");         System.out.println("2. Jackets");     System.out.println("3. Pants");         System.out.println("4. Boots");      System.out.println();
            Type = input.nextInt();
            System.out.println();

            switch(Type){
                case 1:
                buyMenu("Military uniforms");
                break;
                
                case 2:
                buyMenu("Jackets");
                break; 

                case 3:
                buyMenu("Pants");
                break; 

                case 4:
                buyMenu("Boots");
                break; 

            }break;

        case 5:
            System.out.println("Accessories:");     System.out.println("1. Headlamps");     System.out.println("2. Scarves");       System.out.println("3. Mechanix gloves");       System.out.println("4. Ballistic glasses");      System.out.println();
            Type = input.nextInt();
            System.out.println();

            switch(Type){
                case 1:
                buyMenu("Headlamps");
                break;
                
                case 2:
                buyMenu("Scarves");
                break;
                
                case 3:
                buyMenu("Mechanix gloves");
                break;

                case 4:
                buyMenu("Ballistic glasses");
                break;
                
                }break;

        case 6:
            buyMenu("Backpacks");
            break;
        
        default:
        break;
    }

}
}