/* 
 * 
 * Julian & Magdalena 
 * 14.05.2021
 * 
 */
import java.util.Random;

public class Kartendeck 
{
    private Karte[] kartendeck;
    private int kartendeckGroeße;
    //private int z = 0;

    public Kartendeck()
    {
        int zaehler = 0;
        kartendeck = new Karte[52];
        for(int farbe = 0; farbe<4; farbe++){
            for(int wert = 0; wert<14; wert++){
                kartendeck[zaehler]= new Karte(farbe, wert);
                zaehler++;
            }
        }
        kartenNeuMischen();
    }
    
    public void karteZiehen(){
        
    }
    
    public void kartenNeuMischen(){
        Karte zwischenspeicher;
        kartendeckGroeße = 52;
        Random random = new Random();
        int zufall1 = 1 + random.nextInt(52);
        int zufall2 = 1 + random.nextInt(52);        
        for(int i = 0; kartendeckGroeße < i; i++){
            zwischenspeicher = kartendeck[zufall1];
            kartendeck[zufall1] = kartendeck[zufall2];
            kartendeck[zufall2] = zwischenspeicher;
        }
    }
    
    public void testen(){
        for(int i = 0; i < 52; i++){
            kartendeck[i].wertGeben();
            kartendeck[i].farbeGeben();
        }
    }
}