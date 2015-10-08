package ticketmaster;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *  Thomas O Halloran
 *  Student No: R00050862
 *  Email: thomas.O'Halloran@mycit.ie
 *  Lab assignment 1
 */
public class TicketMaster {
    
    //Creeated static tyo be accessible for worker methods
    //at the bottom of the class
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        MusicConcertFactory myMCF = new MusicConcertFactory();
        ComedyConcertFactory myCCF = new ComedyConcertFactory();
        TheatreConcertFactory myTCF = new TheatreConcertFactory();
        ArrayList<Concert> conList = new ArrayList();
        Concert concert = null;
        String selection;
        String custName;
        String cType, cName, cVenue;
        int cCap, choice;
        Observer obs;
        boolean quit = false;
        
        //Main Menu options displayed
        while ( quit != true )
        {
            System.out.println("Please choose one of the following:\n"
                              +"1. Create a concert\n"
                              +"2. Add customer to concert waiting list\n"
                              +"3. Notify customers of available tickets\n"
                              +"4. Exit");
        
            selection = scanner.nextLine();
            switch (selection)
            {
                case "1":   //Create a concert
                        System.out.println("Confirm customer type"
                                                +"\n  1. Music Concert"
                                                +"\n  2. Comedy Concert"
                                                +"\n  3. Theatre Concert");
                        selection = scanner.nextLine();
                            switch (selection)
                            {
                                case "1":   //Create music concert
                                        System.out.print("Please enter concert name:");
                                        cName = verifyName();
                                        System.out.print("Please enter concert venue:");
                                        cVenue = scanner.nextLine();
                                        System.out.print("Please enter concert capacity:");
                                        cCap = verifyCapacity();
                                        concert = myCCF.createConcert(cName, cVenue, cCap);
                                        conList.add(concert);
                                    break;
                                
                                case "2":   //Create comedy concert
                                        System.out.print("Please enter concert name:");
                                        cName = verifyName();
                                        System.out.print("Please enter concert venue:");
                                        cVenue = scanner.nextLine();
                                        System.out.print("Please enter concert capacity:");
                                        cCap = verifyCapacity();
                                        concert = myCCF.createConcert(cName, cVenue, cCap);
                                        conList.add(concert);
                                    break;
                                    
                                case "3":   //Create theatre concert
                                        System.out.print("Please enter concert name:");
                                        cName = verifyName();
                                        System.out.print("Please enter concert venue:");
                                        cVenue = scanner.nextLine();
                                        System.out.print("Please enter concert capacity:");
                                        cCap = verifyCapacity();
                                        concert = myTCF.createConcert(cName, cVenue, cCap);
                                        conList.add(concert);
                                    break;
                                    
                                default : System.out.println("That was not a vlaid selection.");
                            }
                    break;
                    
                case "2":   //Add a customer to a concert waiting list
                        if( conList.size() > 0 )
                        {
                            //Displays all concerts currently available
                            System.out.println("Please choose a concert from the list below:");
                            for(int i = 0; i<conList.size();i++)
                            {
                                System.out.println("     "+(i+1)+". "+conList.get(i).getName());
                            }
                            
                            choice = verifyCapacity();
                            if( choice > conList.size())
                            {
                                System.out.println("That was not a valid selection.");
                            }
                            else
                                {
                                    concert = conList.get(choice-1);
                                    System.out.println("Confirm customer type"
                                                        +"\n  1. Regular Customer"
                                                        +"\n  2. Gold Member Customer"
                                                        +"\n  3. VIP Customer");
                                    selection = scanner.nextLine();
                                    switch (selection)
                                    {
                                        case "1":   //Creates regular customer
                                                System.out.print("Enter customer name:");
                                                custName = verifyName();
                                                Observer ob1 = new RegCustomer(custName);
                                                concert.addObserver(ob1);
                                                System.out.println(custName+" has been added to waiting list");
                                            break;
                                        case "2":   //Creates gold customer
                                                System.out.print("Enter customer name:");
                                                custName = verifyName();
                                                Observer ob2 = new GoldCustomer(custName);
                                                concert.addObserver(ob2);
                                                System.out.println(custName+" has been added to waiting list");
                                            break;
                                        case "3":   //Creates vip customer
                                                System.out.print("Enter customer name:");
                                                custName = verifyName();
                                                Observer ob3 = new VipCustomer(custName);
                                                concert.addObserver(ob3);
                                                System.out.println(custName+" has been added to waiting list");
                                            break;
                                        default : System.out.println("That was not a valid selection.");
                                    }
                                }
                        }
                        else
                            {
                                System.out.println("No concert currently available");
                            }
                    break;
                    
                case "3":   //Notify customers of available tickets for a concert
                    if( conList.size() > 0 )
                    {
                        System.out.println("Please choose a concert from the list below:");
                        for(int i = 0; i<conList.size();i++)
                        {
                            System.out.println("     "+(i+1)+". "+conList.get(i).getName());
                        }
                        
                        choice = verifyCapacity();
                        if( choice > conList.size())
                        {
                            System.out.println("That was not a vlaid selection.");
                        }
                        else
                            {
                                concert = conList.get(choice-1);
                                System.out.println("|------------------------------------------------|\n"
                                                +"   Concert Name: "+concert.getName()+"\n"
                                                +"|------------------------------------------------|");
                    
                                concert.changeState();
                                System.out.println("|------------------------------------------------|");
                            }
                    }
                    else
                        {
                            System.out.println("No concert available yet");
                        }
                        
                    break;
                    
                case "4":   
                        quit = true;
                        System.out.println("Goodbye!!");
                    break;  
                    
                default : System.out.println("Please eneter a valid selection");
            }
        }
    }
    
    //The following are worker methods to validate user input
    
    //Validates that only letters are entered to create a name
    public static String verifyName()
    {
        boolean correct = false;
        do
        {
            String name = scanner.nextLine();
            if( name.replaceAll("\\s", "").matches("[a-zA-Z]+"))
            {
                correct = true;
                return name;
            }
            else
                {
                    System.out.print("Please enter letters only:");
                }
        }while( correct != true);
        return null;
    }
    
    //Validates that only numbers are entered to create the capacity
    // and in some cases to validate user choice option
    public static int verifyCapacity()
    {
        int cap;
            while(!scanner.hasNextInt())
            {
                System.out.print("Please enter numbers only:");
                scanner.next();
            }
            cap = scanner.nextInt();
            scanner.nextLine();
            return cap;
    }
    
}
