//Julian & Magda 

public class Karte
{
    private static int KREUZ=0, PIK=1, HERZ=2, KARO=3;
    private static int BUBE=11, DAME=12, KOENIG=13, ASS=1;
    private int wert, farbe;
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
    
    public int farbeGeben(){
        return farbe;
    }    
}
