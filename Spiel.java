/*
 * Organisiert das Spiel
 * am 30.04.2021
 * von Joel und Paul
 * 
 * Methode kartenwertPrüfen
 * von Magdalena und Julian am 30.04.
 */

public class Spiel
{
    boolean spielGestartet = false;
    boolean spielVerloren = false;
    //int spieleranzahl;
    
    public Spiel(){
        //new Spieler();
    }
    
    
    // GUI-Button drücken, zum Spielstart
    public void setSpielStarten(){
        
    }
    
    // Gibt zurück ob das Spiel läuft
    public boolean getSpielGestartet(){
        return spielGestartet;
    }
    
    public void kartenwertPrüfen(){
        if(Spieler.kartenwertBerechnen() > 21){
            spielVerloren = true;
        }
    }
}
