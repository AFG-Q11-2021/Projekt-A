//Julian & Magda 

public class Karte
{
    private int wert;
    private int farbe;
    public Karte(/*,int newWert String newFarbe*/)
    {
        //wert = newWert;
        //farbe = newFarbe;
        wert = 1 + (int)(Math.random() * 11);
    }
    
    public Karte(int newFarbe, int newWert){
        farbe = newFarbe;
        wert = newWert;
    }
    
    public int wertGeben()
    {
        return wert;
    }
    
    /*public String farbeGeben()
    {
        return farbe;
    }*/
    
}
