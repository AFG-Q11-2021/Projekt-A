/*
 * Amelie & Vroni
 */
public class Spieler implements SpielerInterface
{
    private Kartendeck kartendeck;
    private int kartenanzahl;
    private int budget;
    private int kartenwert;
    
    public Spieler()
    {
        kartendeck = new Kartendeck();
        kartenanzahl = 0;
        kartenwert = 0;
        budget = 1000;
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
    
    public int budgetErhoehen(int erhoehung)
    {
        budget = budget + erhoehung;
        return budget;
    }
    
    public int budgetVerringern(int verringerung)
    {
        budget = budget - verringerung;
        return budget;
    }
}
