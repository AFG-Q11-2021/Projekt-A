/*
 * Organisation des Spiels
 * am 30.04.2021
 * von Joel und Paul
 * 
 * Output für das Gui 
 * von Sasha und Raphael am 18.06.
 * 
 * Code organisiert und weiter am Popup-Fenster gearbeitet
 * von Raphael am 22.06.
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Spiel implements ActionListener
{
    boolean spielGestartet = false;
    private Spieler spieler;
    private Dealer dealer;
    private Gui gui;
    private PopupBeendenFenster popupBeendenFenster;

    public Spiel(){
        
        //setzt das Look and Feel
        gui.laF();

        spieler = new Spieler();
        dealer = new Dealer();
        gui = new Gui();
        popupBeendenFenster = new PopupBeendenFenster();
        
        
        gui.fensterErzeugen("Blackjack-Demo");
        gui.knopfHitGeben().addActionListener(this);
        gui.knopfStandGeben().addActionListener(this);
        gui.knopfStartGeben().addActionListener(this);
        gui.knopfStopGeben().addActionListener(this);        
    }

    // GUI-Button drücken, zum Spielstart
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == gui.knopfStartGeben())
        {
            gui.textleiste.append("Spiel wurde gestartet. \n");
            spieler.karteZiehen();
            spieler.karteZiehen();
            dealer.karteZiehen();
            dealer.karteZiehen();
            gui.textleiste.append("Dein aktueller Kartenwert beträgt " + spieler.getKartenwert() + ".\n");
            gui.textleiste.append("Der aktuelle Kartenwert vom Dealer beträgt " + dealer.getKartenwert() + ".\n");
            gui.textleiste.append("Möchtest du eine Karte ziehen? \n");
            spielGestartet = true;
        }

        if(e.getSource() == gui.knopfStopGeben())
        {
            popupBeendenFenster.beendenBestaetigen("Beenden","Abbrechen");
            
            popupBeendenFenster.popupJaKnopfGeben().addActionListener(this);
            popupBeendenFenster.popupNeinKnopfGeben().addActionListener(this);
        }

        if(spielGestartet==true) 
        {
            if(e.getSource() == gui.knopfHitGeben())
            {
                spieler.karteZiehen();
                gui.textleiste.append("Dein aktueller Kartenwert: " + spieler.getKartenwert() + "\n");
                gui.textleiste.append("Möchtest du eine Karte ziehen? \n");
                if(verloren() == true)
                {
                    gui.textleiste.append("Dein Kartenwert: " + spieler.getKartenwert() + "\n");
                    gui.textleiste.append("Du hast leider über 21 \n");
                    
                }
            }

            if(e.getSource() == gui.knopfStandGeben())
            {
                while(dealer.getKartenwert() <17){
                    dealer.karteZiehen();
                }

                if(dealer.getKartenwert() > spieler.getKartenwert() && dealer.getKartenwert() <= 21)
                {
                    gui.textleiste.append("Dein Kartenwert: " + spieler.getKartenwert() + "\n");
                    gui.textleiste.append("Der Dealer hat:"+ dealer.getKartenwert()+ "\n");
                    gui.textleiste.append("Du hast gegen den Dealer verloren." + "\n");
                }
                else if(dealer.getKartenwert() > 21)
                {
                    gui.textleiste.append("Dealer hat überzogen. Er hat: "+ dealer.getKartenwert() +"\n");
                    gui.textleiste.append("Du hast gewonnen!\n");
                }
                else
                {
                    gui.textleiste.append("Dealer hat: " + dealer.getKartenwert()+ "\n");
                    gui.textleiste.append("Du hast gewonnen!\n");
                }
            } 
        }
        else 
        {

            gui.textleiste.append("Es kam zu einem Fehler. \n");

        }
        
        //Bestätigen des Beenden

        if(e.getSource() == popupBeendenFenster.popupNeinKnopfGeben())
        {
            gui.textleiste.append("Beenden abgebrochen \n");
            popupBeendenFenster.beendenBestaetigenSchließen();            
        }
        else if(e.getSource() == popupBeendenFenster.popupJaKnopfGeben())
        {
            gui.textleiste.append("Beende \n");
            popupBeendenFenster.beendenBestaetigenSchließen();
            gui.fenster.setVisible(false);
            gui.fenster.dispose();
            spielBeendet();
        }
    }

    public boolean getSpielGestartet()
    {
        gui.textleiste.append("Beende \n");
        gui.beendenBestaetigenSchließen();
        gui.fenster.setVisible(false);
        gui.fenster.dispose();
        spielBeendet();
        
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

    public boolean verloren()
    {
        if(spieler.getKartenwert() > 21)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
