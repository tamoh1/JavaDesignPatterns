package ticketmaster;
/**
 *  Thomas O Halloran
 *  Student No: R00050862
 *  Email: thomas.O'Halloran@mycit.ie
 *  Lab assignment 1
 */
public class MusicConcertFactory implements ConcertFactory {

    Concert con;
    
    public MusicConcertFactory ( ) {}
    
    //This uses the factory method pattern where one class has control of 
    //creating the objects that the application is using.
    // Example: this method creates what ever concert type user requests.
    @Override
    public Concert createConcert(String cName, String cVenue, int cCap)
    {
        return con = new MusicConcert(cName, cVenue, cCap);
    }
    
}
