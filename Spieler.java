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
        Karte karte = new Karte();
        karten[kartenanzahl] = karte;
        kartenanzahl ++;
        return karte.wertGeben();
    }
    
    public int kartenwertBerechnen()
    {
        int kartenwert = 0;
        for(int i = 0; i<kartenanzahl; i++)
        {
            kartenwert = kartenwert + karten[i].wertGeben();
        }
        return kartenwert;
    }
    
    /*
     * public int spielerbudgetBerechnen()
     *{
     *}
     */
}
