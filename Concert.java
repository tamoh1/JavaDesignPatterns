package ticketmaster;

import java.util.ArrayList;
/**
 *  Thomas O Halloran
 *  Student No: R00050862
 *  Email: thomas.O'Halloran@mycit.ie
 *  Lab assignment 1
 */
public class Concert extends Observable {
    
    private String name;
    private String venue;
    private int capacity;
    
    public Concert (){}
    
    public Concert ( String cName, String cVenue, int cap )
    {
        name = cName;
        venue = cVenue;
        capacity = cap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    //This method is used to call the notify method 
    //in the super class observable
    public void changeState()
    {
        this.Notify();
    }
    
}
