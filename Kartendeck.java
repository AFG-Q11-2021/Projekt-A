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
        kartendeckGroeße = 52;
        int zaehler = 0;
        for(int farbe = 1; farbe<=4; farbe++){
            for(int wert = 1; wert<=13; wert++){
                kartendeck[zaehler]= new Karte(farbe, wert);
                zaehler++;
            }
        }
        kartenNeuMischen();
    }
    
    public Karte karteZiehen(){
        if(kartendeckGroeße == 0){
            kartenNeuMischen();
        }
        kartendeckGroeße--;
        return kartendeck[kartendeckGroeße];
    }
    
    public void kartenNeuMischen(){
        Karte zwischenspeicher;
        Random random = new Random();     
        for(int i=51; i>=0; i--){
            int zufall = 1 + random.nextInt(51);
            if(zufall != i){
                zwischenspeicher = kartendeck[i];
                kartendeck[i] = kartendeck[zufall];
                kartendeck[zufall] = zwischenspeicher;
            }
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
    
    public void testen2(){
        System.out.print("Test 2 ergab: \n");
        System.out.print("Wert: " + karteZiehen().wertGeben() + " + ");
        System.out.print("Farbe: " + karteZiehen().farbeGeben() + "\n");
    }
}