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
    }
    
    public void remakeSpiel()
    {
    
    }
    
    public void karteZiehen()
    {
        spieler.karteZiehen();
    }
    
    public int getKartenindex(){
        return spieler.getKarte().getIndex();
    }
    
    public int getKartenfarbe(){
        return spieler.getKarte().getFarbe();
    }
    
    public void dealerSpielt()
    {
        while(dealer.getKartenwert() <17){
            dealer.karteZiehen();
        }
    }
    
    public boolean gewonnenMitBlackjack()
    {
        return spieler.getKartenwert() == 21;
    }
    
    public boolean verlorenWegenUeberzogen()
    {
        return spieler.getKartenwert() > 21;
    }
    
    public boolean gewonnenMitDealerUeberzogen()
    {
        return dealer.getKartenwert() > 21 && spieler.getKartenwert() < 21;
    }
    
    public boolean gewonnenMitAugenzahl()
    {
        return dealer.getKartenwert() < 21 && spieler.getKartenwert() < 21 && spieler.getKartenwert() > dealer.getKartenwert();
    }
    
    public boolean verlorenWegenAugenzahl()
    {
        return dealer.getKartenwert() > spieler.getKartenwert() && dealer.getKartenwert() < 21;
    }
    
    public void setSpielstatus(boolean spielstatusNeu)
    {
        spielstatus = spielstatusNeu;
    }
    
    public boolean getSpielstatus()
    {
        return spielstatus;
    }
    
    public int getSpielerkartenwert()
    {
        return spieler.getKartenwert();
    }
}
