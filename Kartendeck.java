/*
 * 
 * Julian & Magdalena 
 * 14.05.2021
 * 
*/
public class Kartendeck 
{
    private Karte[] kartendeck;
    private int z = 0;
    
    public Kartendeck()
    {
        for (int i = 1; i <= 4 ; i++)
        {
            for(int k = 1; k < 13; k++) //Ass wird sperat betrachtet!
            {
                if(i == 1)
                {
                    kartendeck[k] = new Karte();
                }
            }
        }
    }
}
