/*
 * Amelie & Vroni
 */
public class Spieler implements SpielerInterface
{
    private Karte[] karten;
    private int kartenanzahl;
    
    public Spieler()
    {
        karten = new Karte[22];
        kartenanzahl = 0;
    }
    
    public int karteZiehen()
    {
        karte = new Karte();
        karten[kartenanzahl] = 
        kartenanzahl ++;
        return 
    }
    
    public int kartenwertBerechnen()
    {
        
    }
    
    public int spielerbudgetBerechnen()
    {
    }
}
