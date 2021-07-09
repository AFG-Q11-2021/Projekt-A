/*
 * Interface für Spieler & Dealer
 * 30.04.2021
 * Amelie & Vroni
 */

public class SpielerManager
{
    private Kartendeck kartendeck;
    private Karte gezogeneKarte;
    private int kartenanzahl;
    public int kartenwert;
    
    public SpielerManager()
    {
        kartendeck = new Kartendeck();
        kartenanzahl = 0;
        kartenwert = 0;
    }

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
    
    public Karte getKarte()
    {
        return gezogeneKarte;
    }

    public int getKartenwert()
    {
        return kartenwert;
    }
    
    public int getKartenanzahl()
    {
        return kartenanzahl;
    }
    
    public void setKartenwert(int newKartenwert)
    {
        kartenwert = newKartenwert;
    }
    
    public void setKartenanzahl(int newKartenanzahl)
    {
        kartenanzahl = newKartenanzahl;
    }
}
