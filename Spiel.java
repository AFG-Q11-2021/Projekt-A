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
    int spieleranzahl;
    private String eingabe;
    private Spieler spieler;
    private Scanner scanner;
    

    public Spiel(/*int newSpieleranzahl*/){
        //spieleranzahl = newSpieleranzahl;
        scanner = new Scanner(System.in);
        eingabe = scanner.nextLine();
        System.out.print("Möchtest du das Spiel starten? Ja / Nein");
        setSpieleranzahl();
    }

    // GUI-Button drücken, zum Spielstart
    public void setSpielStarten(){
        if(eingabe == "Ja"){
            System.out.print("Spiel wurde gestartet.");
        }
    }

    // Gibt zurück ob das Spiel läuft
    public boolean getSpielGestartet(){
        return spielGestartet;
    }
    
    public void setSpieleranzahl(){
        for(int i = 0; i<spieleranzahl;i++){
            spieler = new Spieler();
        }
    }

    public void kartenwertPrüfen(){
        if(spieler.kartenwertBerechnen() > 21){
            spielVerloren = true;
        }
    }
}
