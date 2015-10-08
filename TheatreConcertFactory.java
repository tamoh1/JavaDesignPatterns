/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmaster;

/**
 *
 * @author R00050862
 */
public class TheatreConcertFactory implements ConcertFactory {
    
    Concert con;
    
    public TheatreConcertFactory() {}
    
    @Override
    public Concert createConcert(String cName, String cVenue, int cCap)
    {
        return con = new TheatreConcert(cName, cVenue, cCap);
    }
}
