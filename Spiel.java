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
    private SpielFenster spielFenster;
    private StartMenue startMenue;

    public Spiel(){ 
        //setzt das Look and Feel
        gui.laF();

        spieler = new Spieler();
        dealer = new Dealer();
        popupBeendenFenster = new PopupBeendenFenster();
        spielFenster = new SpielFenster();

        startMenue = new StartMenue();
        startMenue.fensterErzeugen("Blackjack-Demo-Start");
        startMenue.knopfSpielstartGeben().addActionListener(this);
        startMenue.knopfSpielstartAbbrechenGeben().addActionListener(this);        
    }

    // GUI-Button drücken, zum Spielstart
    public void actionPerformed(ActionEvent e)
    {   
        //erzeugt das Spielfenster und die dafür benötigten knöpfe; schließt das Startmenü
        if(e.getSource() == startMenue.knopfSpielstartGeben())
        {
            spielFenster.fensterErzeugen("Blackjack-Demo");
            spielFenster.knopfHitGeben().addActionListener(this);
            spielFenster.knopfStandGeben().addActionListener(this);
            spielFenster.knopfStartGeben().addActionListener(this);
            spielFenster.knopfStopGeben().addActionListener(this);
            
            startMenue.fenster.setVisible(false);
            startMenue.fenster.dispose();
        }
        else if(e.getSource() == startMenue.knopfSpielstartAbbrechenGeben())
        {
            startMenue.fenster.setVisible(false);
            startMenue.fenster.dispose();
        }
        
        if(e.getSource() == spielFenster.knopfStartGeben())
        {
            spielFenster.textleiste.append("Spiel wurde gestartet. \n");
            spieler.karteZiehen();
            spieler.karteZiehen();
            dealer.karteZiehen();
            dealer.karteZiehen();
            spielFenster.textleiste.append("Dein aktueller Kartenwert beträgt " + spieler.getKartenwert() + ".\n");
            spielFenster.spielerWertPane.setText(String.valueOf(spieler.getKartenwert()));
            spielFenster.textleiste.append("Der aktuelle Kartenwert vom Dealer beträgt " + dealer.getKartenwert() + ".\n");
            spielFenster.dealerWertPane.setText(String.valueOf(dealer.getKartenwert()));
            spielFenster.textleiste.append("Möchtest du eine Karte ziehen? \n");
            spielGestartet = true;
        }

        if(e.getSource() == spielFenster.knopfStopGeben())
        {
            popupBeendenFenster.popupFensterErzeugen("Beenden","Abbrechen");

            popupBeendenFenster.popupJaKnopfGeben().addActionListener(this);
            popupBeendenFenster.popupNeinKnopfGeben().addActionListener(this);
        }

        if(spielGestartet==true) 
        {
            if(e.getSource() == spielFenster.knopfHitGeben())
            {
                spieler.karteZiehen();
                spielFenster.textleiste.append("Dein aktueller Kartenwert: " + spieler.getKartenwert() + "\n");
                spielFenster.spielerWertPane.setText(String.valueOf(spieler.getKartenwert()));
                spielFenster.textleiste.append("Möchtest du eine Karte ziehen? \n");
                if(verloren() == true)
                {
                    spielFenster.textleiste.append("Dein Kartenwert: " + spieler.getKartenwert() + "\n");
                    spielFenster.spielerWertPane.setText(String.valueOf(spieler.getKartenwert()));
                    spielFenster.textleiste.append("Du hast leider über 21 \n");
                }
            }

            if(e.getSource() == spielFenster.knopfStandGeben())
            {
                while(dealer.getKartenwert() <17){
                    dealer.karteZiehen();
                }

                if(dealer.getKartenwert() > spieler.getKartenwert() && dealer.getKartenwert() <= 21)
                {
                    spielFenster.textleiste.append("Dein Kartenwert: " + spieler.getKartenwert() + "\n");
                    spielFenster.spielerWertPane.setText(String.valueOf(spieler.getKartenwert()));
                    spielFenster.textleiste.append("Der Dealer hat:"+ dealer.getKartenwert()+ "\n");
                    spielFenster.textleiste.append("Du hast gegen den Dealer verloren." + "\n");
                }
                else if(dealer.getKartenwert() > 21)
                {
                    spielFenster.textleiste.append("Dealer hat überzogen. Er hat: "+ dealer.getKartenwert() +"\n");
                    spielFenster.dealerWertPane.setText(String.valueOf(dealer.getKartenwert()));
                    spielFenster.textleiste.append("Du hast gewonnen!\n");
                }
                else
                {
                    spielFenster.textleiste.append("Dealer hat: " + dealer.getKartenwert()+ "\n");
                    spielFenster.dealerWertPane.setText(String.valueOf(dealer.getKartenwert()));
                    spielFenster.textleiste.append("Du hast gewonnen!\n");
                }
            } 
        }
        else 
        {

            //spielFenster.textleiste.append("Es kam zu einem Fehler. \n");

        }

        //Bestätigen des Beenden
        if(e.getSource() == popupBeendenFenster.popupNeinKnopfGeben())
        {
            spielFenster.textleiste.append("Beenden abgebrochen \n");
            popupBeendenFenster.popupFensterErzeugenSchließen();            
        }
        else if(e.getSource() == popupBeendenFenster.popupJaKnopfGeben())
        {
            spielFenster.textleiste.append("Beende \n");
            popupBeendenFenster.popupFensterErzeugenSchließen();
            spielFenster.fenster.setVisible(false);
            spielFenster.fenster.dispose();
            spielBeendet();
        }
    }

    public boolean getSpielGestartet()
    {
        spielFenster.textleiste.append("Beende \n");
        spielFenster.popupFensterErzeugenSchließen();
        spielFenster.fenster.setVisible(false);
        spielFenster.fenster.dispose();
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
