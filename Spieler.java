/*
 * Interface für Speler & Dealer
 * 30.04.2021
 * Amelie & Vroni
 */

public interface Spieler
{
    public int KartenwertBerechnen();
    //berechnet Kartensumme, die der Spieler in der Hand hat
    public int SpielerbudgetBerechnen();
    //berechnet das Budget, welches der Spieler hat
}
