//Julian & Magda 

public class Karte
{
    private int wert;
    
    public Karte()
    {
        wert = 1 + (int)(Math.random() * 11);
    }
    
    public int wertGeben()
    {
        return wert;
    }
    
    
}
