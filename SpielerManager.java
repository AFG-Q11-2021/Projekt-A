/*
 * Interface für Spieler & Dealer
 * 30.04.2021
 * Amelie & Vroni
 */

public class SpielerManager
{
    private Kartendeck kartendeck;
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
        Karte gezogeneKarte = kartendeck.karteZiehen();
        if(gezogeneKarte.indexGeben() >= 11)
        {
            kartenwert = kartenwert + 10;
        }
        else
        {
            kartenwert = kartenwert + gezogeneKarte.indexGeben();
        }
        kartenanzahl++;
    }

    public int getKartenwert()
    {
        return kartenwert;
    }
    
    public int getKartenanzahl()
    {
        return kartenanzahl;
    }
}
