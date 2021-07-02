/*
 * Interface für Spieler & Dealer
 * 30.04.2021
 * Amelie & Vroni
 */

public interface SpielerInterface
{
    //public int kartenwertBerechnen();
    //berechnet Kartensumme, die der Spieler in der Hand hat
    //public int spielerbudgetBerechnen();
    //berechnet das Budget, welches der Spieler hat
    
    public void karteZiehen();
    public int getKartenwert();
    public int getKartenanzahl();
}
