/*
 * 
 * Julian & Magdalena 
 * 14.05.2021
 * 
 */
public class Kartendeck 
{
    private Karte[][] kartendeck;
    private Karte[] karo;
    private Karte[] pik;
    private Karte[] herz;
    private Karte[] kreuz;
    //private int z = 0;

    public Kartendeck()
    {
        kartendeck = new Karte[][] {karo, pik, herz, kreuz};
        for(int k = 2; k <= 14; k++) //Ass wird sperat betrachtet!
        {
            kreuz[k] = new Karte(k);
            herz[k] = new Karte(k);
            pik[k] = new Karte(k);
            karo[k] = new Karte(k);
        }
    }
}

