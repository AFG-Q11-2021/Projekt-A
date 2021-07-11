/**
 * Klasse SpielerManager enthält wichtige Methoden für Dealer und Spieler.
 * 
 * @author (Amelie Kleber, Veronika Klobensteiner) 
 * @version (30.05.2021)
 */
public class SpielerManager
{
    private Kartendeck kartendeck;
    private Karte gezogeneKarte;
    private int kartenanzahl;
    public int kartenwert;
    
    /**
     * Konstruktor für Objekte der Klasse SpielerManager
     */
    public SpielerManager()
    {
        kartendeck = new Kartendeck();
        kartenanzahl = 0;
        kartenwert = 0;
    }
    
    /**
     * Zieht eine Karte aus dem Kartendeck.
     * Ist der Index der Karte größer gleich 11 (entspricht Bube, Dame oder König),
     * wird der Kartenwert auf 10 gesetzt und dem Spieler/Dealer hinzugefügt. 
     */
    public void karteZiehen()
    {
        gezogeneKarte = kartendeck.karteZiehen();
        if(gezogeneKarte.getIndex() >= 11)
        {
            kartenwert = kartenwert + 10;
        }
        else
        {
            kartenwert = kartenwert + gezogeneKarte.getIndex();
        }
        kartenanzahl++;
    }
    
    /**
     * Gibt die gezogene Karte zurück.
     */
    public Karte getKarte()
    {
        return gezogeneKarte;
    }
    
    /**
     * Gibt den Kartenwert zurück.
     */
    public int getKartenwert()
    {
        return kartenwert;
    }
    
    /**
     * Gibt die Kartenanzahl zurück.
     */
    public int getKartenanzahl()
    {
        return kartenanzahl;
    }
    
    /**
     * Setzt einen neuen Kartenwert.
     */
    public void setKartenwert(int newKartenwert)
    {
        kartenwert = newKartenwert;
    }
    
    /**
     * Setzt eine neue Kartenanzahl.
     */
    public void setKartenanzahl(int newKartenanzahl)
    {
        kartenanzahl = newKartenanzahl;
    }
}
