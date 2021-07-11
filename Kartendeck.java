/**
 * Verwaltet alle 52 Karten im Kartendeck.
 * 
 * @author (Paul Görner, Joel Bitterlich)
 * @version (04.07.2021)
 */
import java.util.Random;

public class Kartendeck 
{
    private Karte[] kartendeck;
    private int kartendeckGroeße;
    
    /**
     * Konstruktor für Objekte der Klasse Kartendeck
     * Setzt alle 52 Karten mit einmaliger Farbe und Index in eine Liste.
     */
    public Kartendeck()
    {
        kartendeck = new Karte[52];
        kartendeckGroeße = 52;
        int zaehler = 0;
        for(int farbe = 0; farbe<=3; farbe++){
            for(int index = 1; index<=13; index++){
                kartendeck[zaehler]= new Karte(farbe, index);
                zaehler++;
            }
        }
        kartenNeuMischen();
    }
    
    /**
     * Zeiht eine Karte von oben aus der Liste.
     * Ist die Liste leer wird das Kartedeck neugemischt.
     */
    public Karte karteZiehen(){
        if(kartendeckGroeße == 0){
            kartenNeuMischen();
        }
        kartendeckGroeße--;
        return kartendeck[kartendeckGroeße];
    }
    
    /**
     * Mischt die Karte zufällig in der Liste.
     */
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
}