/*
 * Amelie & Vroni
 */
public class Dealer implements SpielerInterface
{
    private Karte[] karten;
    private int kartenanzahl;
    private boolean dealerZuHoch;
    
    public Dealer()
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
    
    public int dealerSpielt()
    {
        karteZiehen();
        if(kartenwertBerechnen() < 17)
        {
            dealerSpielt();
        }
        else if(kartenwertBerechnen() <= 21)
        {
             return kartenwertBerechnen();   
        }
        return 0;
    }
}
