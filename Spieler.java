/*
 * Amelie & Vroni
 */
public class Spieler extends SpielerManager
{
    private int budget;
    
    public Spieler()
    {
        budget = 1000;
    }
    
    public int budgetErhoehen(int erhoehung)
    {
        budget = budget + erhoehung;
        return budget;
    }
    
    public int budgetVerringern(int verringerung)
    {
        budget = budget - verringerung;
        return budget;
    }
}
