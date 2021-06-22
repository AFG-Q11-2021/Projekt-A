/* 
 * 
 * Paul & Joel
 * 18.06.2021
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
        kartendeck = new Karte[52];
        int zaehler = 0;
        for(int farbe = 1; farbe<=4; farbe++){
            for(int wert = 1; wert<=13; wert++){
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
            System.out.print("Wert: " + kartendeck[i].wertGeben() + " + ");
            System.out.print("Farbe: " + kartendeck[i].farbeGeben() + "\n");
        }
    }
}