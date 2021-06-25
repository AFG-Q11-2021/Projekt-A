//Julian & Magda 

public class Karte
{
    private static int KREUZ=0, PIK=1, HERZ=2, KARO=3;
    private static int BUBE=11, DAME=12, KOENIG=13, ASS=1;
    private int index, farbe;
    
    public Karte(int newFarbe, int newIndex){
        farbe = newFarbe;
        index = newIndex;
    }
    
    public int indexGeben()
    {
        return index;
    }
    
    public int farbeGeben(){
        return farbe;
    }    
}
