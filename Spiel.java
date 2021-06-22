/*
 * Organisiert das Spiel
 * am 30.04.2021
 * von Joel und Paul
 * 
 * Methode kartenwertPrüfen
 * von Magdalena und Julian am 30.04.
 * 
 * Output für das Gui 
 * von Sasha und Raphael am 18.06.
 * 
 * Code organisiert und weiter am Popup-Fenster gearbeitet
 * von Raphael am 22.06.
 */
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Spiel implements ActionListener
{
    boolean spielGestartet = false;
    private String eingabe;
    private Spieler spieler;
    private Scanner scanner;
    private Dealer dealer;
    private Gui gui;

    public Spiel(){
        spieler = new Spieler();
        dealer = new Dealer();
        gui = new Gui();
        
        
        gui.knopf1Geben().addActionListener(this);
        gui.knopf2Geben().addActionListener(this);
        gui.knopf3Geben().addActionListener(this);
        gui.knopf4Geben().addActionListener(this);
        
        gui.beendenJaKnopfGeben().addActionListener(this);
        gui.beendenNeinKnopfGeben().addActionListener(this);
    }

    // GUI-Button drücken, zum Spielstart
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == gui.knopf3Geben())
        {
            System.out.print("Spiel wurde gestartet. \n");
            gui.textleiste.setText("Spiel wurde gestartet  \n");
            spielGestartet = true;
        }
        
        if(e.getSource() == gui.knopf4Geben())
        {
 
            System.out.print("Spiel wird abgebrochen  \n");
            //spielBeendet();
            gui.beendenBestaetigen();
            
        }
        
        if(spielGestartet==true){
            System.out.print("Möchtest du eine Karte ziehen? Ja / Nein \n");
            System.out.print("");
            gui.textleiste.setText("Möchtest du eine Karte ziehen? Ja / Nein  \n");
            if(e.getSource() == gui.knopf1Geben()){
                spieler.karteZiehen();
                System.out.print("Dein aktueller Kartenwert: " + spieler.kartenwertBerechnen() + "\n");
                System.out.print("");
                gui.textleiste.setText("Dein aktueller Kartenwert: " + spieler.kartenwertBerechnen() + "\n");
                if(verloren() == true){
                    System.out.print("Dein Kartenwert: " + spieler.kartenwertBerechnen() + "\n");
                    System.out.print("Du hast leider über 21  \n");
                    
                    gui.textleiste.setText("Dein Kartenwert: " + spieler.kartenwertBerechnen() + "\n");
                    gui.textleiste.setText("Du hast leider über 21 \n");

                    spielBeendet();
                } /*else {
                    actionPerformed(e);
                }*/ 
            }else if(e.getSource() == gui.knopf2Geben()){
                if(dealer.dealerSpielt() > spieler.kartenwertBerechnen()){
                    System.out.print("Dein Kartenwert: " + spieler.kartenwertBerechnen() + "\n");
                    System.out.print("Der Dealer hat:"+ dealer.kartenwertBerechnen()+ "\n");
                    System.out.print("Du hast gegen den Dealer verloren." + "\n");
                    gui.textleiste.setText("Dein Kartenwert: " + spieler.kartenwertBerechnen() + "\n");
                    gui.textleiste.setText("Der Dealer hat:"+ dealer.kartenwertBerechnen()+ "\n");
                    gui.textleiste.setText("Du hast gegen den Dealer verloren." + "\n");                  
                } else {
                    if(dealer.kartenwertBerechnen() > 21)
                    {
                        System.out.print("Dealer hat überzogen. Er hat: "+ dealer.kartenwertBerechnen() +"\n");
                        System.out.print("Du hast gewonnen!\n");
                        gui.textleiste.setText("Dealer hat überzogen. Er hat: "+ dealer.kartenwertBerechnen() +"\n");
                        gui.textleiste.setText("Du hast gewonnen!\n");
                    }
                    else
                    {
                        System.out.print("Dealer hat: " + dealer.kartenwertBerechnen()+ "\n");
                        gui.textleiste.setText("Dealer hat: " + dealer.kartenwertBerechnen()+ "\n");
                    }
                }
            } else {

            }
        }else {
            System.out.print("Es kam zu einem Fehler. \n");
            gui.textleiste.setText("Es kam zu einem Fehler. \n");
        }
    }
    
    //Knöpfe für das Popup-Beenden-Fenster
     public void actionPerformedBeenden(ActionEvent b)
    {
        
            
        
            if(b.getSource() == gui.beendenNeinKnopfGeben())
            {
                gui.textleiste.setText("Beenden abgebrochen \n");
                System.out.println("test");
                gui.beendenBestaetigenSchließen();
            }
            else if(b.getSource() == gui.beendenJaKnopfGeben())
            {
                gui.textleiste.setText("Beende \n");
                gui.beendenBestaetigenSchließen();
                spielBeendet();
            }
                   
        
    }
    
    // Gibt zurück ob das Spiel läuft
    public boolean getSpielGestartet()
    {
        return spielGestartet;
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

    public int spielerKartenwert()
    {
        return spieler.kartenwertBerechnen();
    }
}
