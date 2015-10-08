package ticketmaster;

import java.util.Observable;
/**
 *  Thomas O Halloran
 *  Student No: R00050862
 *  Email: thomas.O'Halloran@mycit.ie
 *  Lab assignment 1
 */
public class GoldCustomer implements Observer {
    
    private String name;
    
    public GoldCustomer(String cName)
    {
        name = cName;
    }
    
    //When the observable object calls notify then this
    //method is called on all customers who are observers
    public void update() {
    
        System.out.println(name+" has been notified of gold option tickets.");   
    }
    
}