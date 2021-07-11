/**
 * Organisiert das Spiel und dient als Schnittstelle zwischen SpielerManager und GraphicManager.
 * Verwaltet die Bedingungen fürs Gewinnen und Verlieren.
 * 
 * @author (Paul Görner, Julian Kupfer, Joel Bitterlich) 
 * @version (05.07.2021)
 */
public class Spiel
{
    private Spieler spieler;
    private Dealer dealer;
    private Kartendeck kartendeck;
    public boolean spielstatus;
    
    /**
     * Konstruktor für Objekte der Klasse Spiel.
     */
    public Spiel(){
        spieler = new Spieler();
        dealer = new Dealer();
        
        spielstatus = false;
        
        kartendeck = new Kartendeck() ;
    }
    
    /**
     * Zieht Karte für den Spieler.
     */
    public void spielerZiehtKarte()
    {
        spieler.karteZiehen();
    }
    
    /**
     * Zieht Karte für den Dealer.
     */
    public void dealerZiehtKarte()
    {
        dealer.karteZiehen();
    }
    
    /**
     * Setzt das Spiel erneut auf.
     */
    public void remake()
    {
        kartendeck.kartenNeuMischen();
        spieler.setKartenwert(0);
        spieler.setKartenanzahl(0);
        dealer.setKartenwert(0);
        dealer.setKartenanzahl(0);
    }
    
    /**
     * Gibt zurück, ob der Spieler mit einem Blackjack gewonnen hat.
     * 
     * @return - true/false
     */
    public boolean gewonnenMitBlackjack()
    {
        return spieler.getKartenwert() == 21;
    }
    
    /**
     * Gibt zurück, ob der Spieler aufgrund Überziehen verloren hat..
     * 
     * @return - true/false
     */
    public boolean verlorenWegenUeberzogen()
    {
        return spieler.getKartenwert() > 21;
    }
    
    /**
     * Gibt zurück, ob der Spieler aufgrund des Überziehen des Dealers gewonnen hat.
     * 
     * @return - true/false
     */
    public boolean gewonnenMitDealerUeberzogen()
    {
        return dealer.getKartenwert() > 21 && spieler.getKartenwert() < 21;
    }
    
    /**
     * Gibt zurück, ob der Spieler aufgrund eines Blackjack des Dealers verloren hat.
     * 
     * @return - true/false
     */
    public boolean verlorenWegenDealerBlackjack()
    {
        return dealer.getKartenwert()==21;
    }
    
    /**
     * Gibt zurück, ob der Spieler mit einem höheren Kartenwert unter 21 als der Dealer gewonnen hat.
     * 
     * @return - true/false
     */
    public boolean gewonnenMitAugenzahl()
    {
        return dealer.getKartenwert() < 21 && spieler.getKartenwert() < 21 && spieler.getKartenwert() > dealer.getKartenwert();
    }
    
    /**
     * Gibt zurück, ob der Spieler einen geringeren Kartenwert unter 21 als der Dealer hat.
     * 
     * @return - true/false
     */
    public boolean verlorenWegenAugenzahl()
    {
        return dealer.getKartenwert() > spieler.getKartenwert() && dealer.getKartenwert() < 21;
    }
    
    /**
     * Gibt zurück, ob der Spieler aufgrund gleichem Kartenwert unter 21 verloren hat.
     * 
     * @return - true/false
     */
    public boolean verlorenWegenGleicherAugenzahl()
    {
        return dealer.getKartenwert() == spieler.getKartenwert() && spieler.getKartenwert() < 21;
    }
    
    /**
     * Setzt den Spielstatus.
     * 
     * @param  spielstatusNeu - Gibt an auf welchen Spielstatus das Spiel gesetzt wird.
     */
    public void setSpielstatus(boolean spielstatusNeu)
    {
        spielstatus = spielstatusNeu;
    }
    
    /**
     * Gibt den Spielstatus des Spiels zurück.
     */
    public boolean getSpielstatus()
    {
        return spielstatus;
    }
    
    /**
     * Gibt den Kartenindex der Karte vom Spieler zurück.
     */
    public int getSpielerKartenindex(){
        return spieler.getKarte().getIndex();
    }
    
    /**
     * Gibt die Kartenfarbe der Karte vom Spieler zurück.
     */
    public int getSpielerKartenfarbe(){
        return spieler.getKarte().getFarbe();
    }
    
    /**
     * Gibt den Kartenindex der Karte vom Dealer zurück.
     */
    public int getDealerKartenindex(){
        return dealer.getKarte().getIndex();
    }
    
    /**
     * Gibt die Kartenfarbe der Karte vom Dealer zurück.
     */
    public int getDealerKartenfarbe(){
        return dealer.getKarte().getFarbe();
    }
    
    /**
     * Gibt den Spielerkartenwert zurück.
     */
    public int getSpielerkartenwert()
    {
        return spieler.getKartenwert();
    }
    
    /**
     * Gibt den Dealerkartenwert zurück.
     */
    public int getDealerkartenwert()
    {
        return dealer.getKartenwert();
    }
}
