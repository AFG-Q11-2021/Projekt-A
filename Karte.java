/*
 *  Klasse Karte:
 *  Erzeugt die Karten
 *  Zeigt Bilder der Karten
 *  Von: Paul, Sachsa, Julian
 */

public class Karte
{
    private static int KREUZ=0, PIK=1, HERZ=2, KARO=3;
    private static int BUBE=11, DAME=12, KOENIG=13, ASS=1;
    private int index, farbe;
    
    /*
     * Konstruktor der Klasse Karte:
     * Farbe und Index werden bei der Erzeugung mitgegeben.
     */
    public Karte(int newFarbe, int newIndex){
        farbe = newFarbe;
        index = newIndex;
    }
    
    // Methode zum Geben des Index
    public int indexGeben()
    {
        return index;
    }
    
    // Methode zum Geben der Farbe
    public int farbeGeben(){
        return farbe;
    }
}
