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
        //setSpieleranzahl();
        setSpielStarten();
    }

    // GUI-Button drücken, zum Spielstart
    public void setSpielStarten(){
        System.out.print("Möchtest du das Spiel starten? Ja / Nein");
        scanner = new Scanner(System.in);
        eingabe = scanner.nextLine();
        if(eingabe == "Ja"){
            System.out.print("Spiel wurde gestartet.");
            spielGestartet = true;
        } else if(eingabe == "Nein"){
            System.out.print("Spiel wird abgebrochen");
            scanner.close();
        }else{
            System.out.print("Es kam zu einem Fehler.");
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
