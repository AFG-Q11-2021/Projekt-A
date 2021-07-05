/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Paul Görner, Julian Kupfer) 
 * @version (05.07.2021)
 */
public class Spiel
{
    private Spieler spieler;
    private Dealer dealer;
    
    private Kartendeck kartendeck;
    
    public boolean spielstatus;

    public Spiel(){
        spieler = new Spieler();
        dealer = new Dealer();
        
        spielstatus = false;
        
        //popupBeendenFenster = new PopupBeendenFenster();
        //popupNeustartFenster = new PopupNeustartFenster();    
        kartendeck = new Kartendeck() ;
    }
    
    public void setupSpiel(){
        if(getSpielstatus() == false){
            setSpielstatus(true);
        }
        
        spieler.karteZiehen();
        spieler.karteZiehen();
        
        dealer.karteZiehen();
        dealer.karteZiehen();
    }
    
    public void remakeSpiel()
    {
    
    }
    
    public void karteZiehen()
    {
        spieler.karteZiehen();
    }
    
    public void dealerSpielt()
    {
        while(dealer.getKartenwert() <17){
            dealer.karteZiehen();
        }
    }
    
    public boolean gewonnenMitBlackjack()
    {
        if(spieler.getKartenwert() == 21)
        {
            return true;
        }
        return false;
    }
    
    public boolean verlorenWegenUeberzogen()
    {
        if(spieler.getKartenwert() > 21)
        {
            return true;
        }
        return false;
    }
    
    public boolean gewonnenMitDealerUeberzogen()
    {
        if(dealer.getKartenwert() > 21 && spieler.getKartenwert() < 21)
        {
            return true;
        }
        return false;
    }
    
    public boolean gewonnenMitAugenzahl()
    {
        if(dealer.getKartenwert() < 21 && spieler.getKartenwert() < 21 && spieler.getKartenwert() > dealer.getKartenwert())
        {
            return true;
        }
        return false;
    }
    
    public boolean verlorenWegenAugenzahl()
    {
        if(dealer.getKartenwert() > spieler.getKartenwert() && dealer.getKartenwert() < 21)
        {
            return true;
        }
        return false;
    }
    
    public void setSpielstatus(boolean spielstatusNeu)
    {
        spielstatus = spielstatusNeu;
    }
    
    public boolean getSpielstatus()
    {
        return spielstatus;
    }
}
