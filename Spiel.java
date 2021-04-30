/*
 * Organisiert das Spiel
 * am 30.04.2021
 * von Joel und Paul
 * 
 * Methode kartenwertPrüfen
 * von Magdalena und Julian am 30.04.
 */
import java.util.Scanner;

public class Spiel
{
    boolean spielGestartet = false;
    boolean spielVerloren = false;
    Spieler spieler;
    int spieleranzahl;
    
    public Spiel(int newSpieleranzahl){
        spieleranzahl = newSpieleranzahl;
        System.out.print("Möchtest du das Spiel starten? ");
        setSpieleranzahl();
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
    
    
    
    
    
    
    
    
    
    
    
    

    public void setSpieleranzahl(){
        for(int i = 0; i<spieleranzahl;i++){
            spieler = new Spieler();
        }
    }
}
