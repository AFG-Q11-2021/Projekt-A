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
    private String eingabe;
    private Spieler spieler;
    private Scanner scanner;

    public Spiel(){
        spieler = new Spieler();

        setSpielStarten();
        laufendesSpiel();
    }

    // GUI-Button drücken, zum Spielstart
    public void setSpielStarten(){
        System.out.print("Möchtest du das Spiel starten? Ja / Nein \n");
        scanner = new Scanner(System.in);
        eingabe = scanner.nextLine();
        if(eingabe.equalsIgnoreCase("Ja")){
            System.out.print("Spiel wurde gestartet. \n");
            spielGestartet = true;
            scanner.close();
        } else if(eingabe.equalsIgnoreCase("Nein")){
            System.out.print("Spiel wird abgebrochen");
            scanner.close();
            spielBeendet();
        }else{
            System.out.print("Es kam zu einem Fehler.");
            scanner.close();
            spielBeendet();
        }
    }

    // Gibt zurück ob das Spiel läuft
    public boolean getSpielGestartet(){
        return spielGestartet;
    }

    public void laufendesSpiel(){
        if(spielGestartet==true){
            System.out.print("Möchtest du eine Karte ziehen? Ja / Nein \n");
            System.out.print("");
            scanner = new Scanner(System.in);
            eingabe = scanner.nextLine();
            if(eingabe.equalsIgnoreCase("Ja")){
                spieler.karteZiehen();
                System.out.print("Dein aktueller Kartenwert: " + spieler.kartenwertBerechnen() + "\n");
                System.out.print("");
                if(verloren() == true){
                    System.out.print("Dein Kartenwert: " + spieler.kartenwertBerechnen() + "\n");
                    System.out.print("Du hast leider über 21");
                    spielBeendet();
                }else {
                    laufendesSpiel();
                }
            }
        }else {
            System.out.print("Es kam zu einem Fehler.");
        }

    }

    public void spielBeendet(){
        try
        {
            Thread.sleep(5000);
            spielGestartet = false;
            System.exit(0);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public boolean verloren(){
        if(spieler.kartenwertBerechnen() > 21){
            return true;
        } else {
            return false;
        }
    }
}
