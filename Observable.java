package ticketmaster;

import java.util.ArrayList;
/**
 *  Thomas O Halloran
 *  Student No: R00050862
 *  Email: thomas.O'Halloran@mycit.ie
 *  Lab assignment 1
 */
public class Observable extends Object {
    
     private ArrayList<Observer> observers = new ArrayList();
    
    //This adds an observer to the Observable list of observers
    public void addObserver( Observer o )
    {
        observers.add(o);
    }
    
    //This allows the removal of an observer from the list
    public void removeObserver( Observer o )
    {
        observers.remove(o);
    }
    
    //This method runs through all observers for this observable
    //and allows the object hierarchy decide on what update method is called.
    public void Notify()
    {
        for(int i = 0; i<observers.size();i++)
        {
            observers.get(i).update();
        }
    }
    
}
