/**
 * Erzeugt die Karte mit den Variablen Farbe und Index.
 * 
 * @author (Paul Görner, Sachsa Kuckelkorn, Julian Kupfer)
 * @version (04.07.2021)
 */
public class Karte
{ 
    private int index, farbe;
    /**
     * Konstruktor für Objekte der Klasse Karte.
     * Farbe und Index werden beim erzeugen einer Karte mitgegeben.
     */
    public Karte(int newFarbe, int newIndex){
        farbe = newFarbe;
        index = newIndex;
    }
    
    /**
     * Gibt den Index einer Karte zurück.
     */
    public int getIndex()
    {
        return index;
    }
    
    /**
     * Gibt die Farbe einer Karte zurück.
     */
    public int getFarbe(){
        return farbe;
    }
}
