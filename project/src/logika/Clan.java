/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 *
 * @author bogdan
 */
public class Clan {

    
    //domenska klasa, predstavlja vezu izmedju gui-a i baze
    
    
    private String ime, prezime, email, oblast, idTima;

    public Clan(String ime, String prezime, String email, String oblast, String idTima) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.oblast = oblast;
        this.idTima = idTima;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdTima() {
        return idTima;
    }

    public void setIdTima(String idTima) {
        this.idTima = idTima;
    }

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }
}
