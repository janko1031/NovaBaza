/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import database.DBBroker;
import java.util.ArrayList;

/**
 *
 * @author bogdan
 */
public class Logika {

    public ArrayList vratiIDTimova() {
        ArrayList<String> lista;
        try {
            lista = DBBroker.getInstance().dajIDTimova();
// DBBroker.getinstace vraca objekat DBBrokera
            return lista;
        } catch (Exception e) {
            System.err.println("Greska u logici");
        }
        return null;
    }
    
    // vraca listu IDtima i prosledjuje ih GUI-u 

    public void dodajClana(Clan c) {
        try {
            DBBroker.getInstance().dodaj(c);
        } catch (Exception e) {
            System.err.println("Greska u logici");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
