/**
 * Beschreiben Sie hier die Klasse SpielFenster.
 * 
 * @author (Paul Görner, Rafael Marsmann, )
 * @version (04.07.2021)
 */

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.*;

public class GraphicManager implements ActionListener
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ImageIcon fensterIcon;
    private JFrame frame;
    
    private SpielFenster spielfenster;
    private HauptFenster hauptfenster;
    private PopupFenster popupfenster;
    
    private Spiel spiel;

    /**
     * Konstruktor für Objekte der Klasse GraphicManager
     */
    public GraphicManager()
    {
        fensterIcon = new ImageIcon(getClass().getResource("\\res\\Icon.png"));
        frame = new JFrame();
        
        spiel = new Spiel();
        
        spielfenster = new SpielFenster();
        hauptfenster = new HauptFenster();
        popupfenster = new PopupFenster();
        
        hauptfenster.getKnopfSingleplayer().addActionListener(this);
        hauptfenster.getKnopfMultiplayer().addActionListener(this);
        hauptfenster.getKnopfProfil().addActionListener(this);
        hauptfenster.getKnopfBeenden().addActionListener(this);
        
        spielfenster.getKnopfHit().addActionListener(this);
        spielfenster.getKnopfStand().addActionListener(this);
        
        popupfenster.getKnopfBestaetigen().addActionListener(this);
        popupfenster.getKnopfAbbrechen().addActionListener(this);
        
        updateFensterZuMenue();
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    
    public void setupFenster()
    {
        frame.getContentPane().removeAll();
        frame.setExtendedState(JFrame.NORMAL);
        //frame.remove(hauptfenster);
        //frame.remove(hauptfenster.knoepfeErzeugen());
        //frame.remove(spielfenster);
        //frame.remove(spielfenster);
        frame.dispose();
    }
    
    public void updateFensterZuSpiel()
    {
        setupFenster();
        frame.setBackground(Color.decode("#D1D1D1"));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        frame.add(spielfenster);
        frame.add(BorderLayout.SOUTH, spielfenster.knoepfeErzeugen());
        frame.setVisible(true);
    }
    
    public void updateFensterZuMenue()
    {
        setupFenster();
        frame.setSize(0, 0);
        frame.add(hauptfenster);
        frame.add(hauptfenster.knoepfeErzeugen());
        frame.pack();
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {   
        //erzeugt das Spielfenster und die dafür benötigten Knöpfe; schließt das Startmenü
        if(e.getSource() == hauptfenster.getKnopfSingleplayer())
        {
            updateFensterZuSpiel();
            spiel.setupSpiel();
        }
        
        else if(e.getSource() == hauptfenster.getKnopfMultiplayer())
        {
        
        }

        else if(e.getSource() == hauptfenster.getKnopfProfil())
        {
            
        }
        
        else if(e.getSource() == hauptfenster.getKnopfBeenden())
        {
            popupfenster.popupFensterErzeugen("Möchtest du das Spiel beenden?");
            if(e.getSource() == popupfenster.getKnopfBestaetigen())
            {
                setupFenster();
                popupfenster.closePopupFenster();
            }
            else if(e.getSource() == popupfenster.getKnopfAbbrechen())
            {
                popupfenster.closePopupFenster();
            }
        }
        if(spiel.getSpielstatus() == true)
        {
            if(e.getSource() == spielfenster.getKnopfHit())
            {
                spiel.karteZiehen();
                
                

                if(spiel.gewonnenMitBlackjack() == true)
                {
                    
                }
                if(spiel.verlorenWegenUeberzogen() == true)
                {
                    
                }
            }
            else if(e.getSource() == spielfenster.getKnopfStand())
            {
                if(spiel.gewonnenMitDealerUeberzogen() == true)
                {
                    
                }
                if(spiel.gewonnenMitAugenzahl() == true)
                {
                
                }
                if(spiel.verlorenWegenAugenzahl() == true)
                {
                
                }
            }
        }
        /*
        if(s==true) 
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

                    spielFenster.textleiste.append("Du hast leider über 21 und somit verloren ... \nLust auf noch ein Spiel? \n");
                    
                    popupNeustartFenster.popupFensterErzeugen("Neustart","Beenden");
                    popupNeustartFenster.popupJaKnopfGeben().addActionListener(this);
                    popupNeustartFenster.popupNeinKnopfGeben().addActionListener(this); 
                }
            }

            if(e.getSource() == spielFenster.knopfStandGeben())
            {
                while(dealer.getKartenwert() <17){
                    dealer.karteZiehen();
                }

                if(dealer.getKartenwert() > spieler.getKartenwert() && dealer.getKartenwert() < 21)
                {
                    spielFenster.textleiste.append("Dein Kartenwert: " + spieler.getKartenwert() + "\n");
                    spielFenster.spielerWertPane.setText(String.valueOf(spieler.getKartenwert()));
                    spielFenster.textleiste.append("Der Dealer hat: "+ dealer.getKartenwert()+ "\n");
                    spielFenster.textleiste.append("Du hast gegen den Dealer verloren.\nLust auf noch ein Spiel? \n");
                    //spielBeendet();
                    popupNeustartFenster.popupFensterErzeugen("Neustart","Beenden");
                    popupNeustartFenster.popupJaKnopfGeben().addActionListener(this);
                    popupNeustartFenster.popupNeinKnopfGeben().addActionListener(this); 
                }

                else if(dealer.getKartenwert() > 21)
                {
                    spielFenster.textleiste.append("Dealer hat überzogen. Er hat: "+ dealer.getKartenwert() +"\n");
                    spielFenster.dealerWertPane.setText(String.valueOf(dealer.getKartenwert()));
                    spielFenster.textleiste.append("Du hast gewonnen!\nLust auf noch ein Spiel? \n");
                    //spielBeendet();
                    popupNeustartFenster.popupFensterErzeugen("Neustart","Beenden");
                    popupNeustartFenster.popupJaKnopfGeben().addActionListener(this);
                    popupNeustartFenster.popupNeinKnopfGeben().addActionListener(this); 
                }

                else
                {
                    spielFenster.textleiste.append("Dealer hat: " + dealer.getKartenwert()+ "\n");
                    spielFenster.dealerWertPane.setText(String.valueOf(dealer.getKartenwert()));
                    spielFenster.textleiste.append("Du hast gewonnen!\nLust auf noch ein Spiel? \n");
                    //spielBeendet();
                    popupNeustartFenster.popupFensterErzeugen("Neustart","Beenden");
                    popupNeustartFenster.popupJaKnopfGeben().addActionListener(this);
                    popupNeustartFenster.popupNeinKnopfGeben().addActionListener(this); 
                }
            } 
        }
        else 
        {
            spielFenster.textleiste.append("ERROR \nDas Spiel wurde noch nicht gestartet, somit kann keiner dieser Knöpfe gedrückt werden. \n");
        }

        //erzeugt das Popup nach dem Klicken von "Beenden"
        if(e.getSource() == spielFenster.knopfStopGeben())
        {
            popupBeendenFenster.popupFensterErzeugen("Beenden","Abbrechen");

            popupBeendenFenster.popupJaKnopfGeben().addActionListener(this);
            popupBeendenFenster.popupNeinKnopfGeben().addActionListener(this); 
        }
        
        //Bestätigen des Beenden im Popupfenster
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

        //Neustart/Beenden nach Velieren(PopupFenster)
        if(e.getSource() == popupNeustartFenster.popupJaKnopfGeben())
        {
            popupNeustartFenster.popupFensterErzeugenSchließen(); 
            spielFenster.textleiste.setText("");
            neustart();
        }
        else if(e.getSource() == popupNeustartFenster.popupNeinKnopfGeben())
        {
            spielFenster.textleiste.append("Beende \n");
            popupNeustartFenster.popupFensterErzeugenSchließen();
            spielFenster.fenster.setVisible(false);
            spielFenster.fenster.dispose();
            spielBeendet();
        }*/
    }
    /*
    public boolean getSpielGestartet()
    {
        spielFenster.textleiste.append("Beende \n");
        spielFenster.popupFensterErzeugenSchließen();
        spielFenster.fenster.setVisible(false);
        spielFenster.fenster.dispose();
        spielBeendet();

        return spielGestartet;
    }
    */
}
