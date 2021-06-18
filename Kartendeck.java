/* 
 * 
 * Julian & Magdalena 
 * 14.05.2021
 * 
 */

public class Kartendeck 
{
    private Karte[] kartendeck;
    //private int z = 0;

    public Kartendeck()
    {
        int zaehler = 0;
        for(int farbe = 0; farbe<4; farbe++){
            for(int wert = 0; wert<11; wert++){
                kartendeck[zaehler]= new Karte(farbe, wert);
                zaehler++;
            }
        }
    }
    
    public void karteZiehen(){
        
    }
    
    public void kartenNeuMischen(){
    
    }
    
    public Karte[] testen(){
        return kartendeck;
    }
}