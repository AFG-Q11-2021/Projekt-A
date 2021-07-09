/**
 * Beschreiben Sie hier die Klasse SpielFenster.
 * 
 * @author (Paul Görner, Rafael Marsmann)
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
        spielfenster.getKnopfBeenden().addActionListener(this);
        
        popupfenster.getKnopfJa().addActionListener(this);
        popupfenster.getKnopfNein().addActionListener(this);
        
        hauptfenster.erzeugen();
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    
    public void actionPerformed(ActionEvent e)
    {   
        /*
         * Beobachtet, ob folgende Knöpfe auf dem Hauptmenü gedrückt werden.
         */
        if(e.getSource() == hauptfenster.getKnopfSingleplayer())
        {
            hauptfenster.schließen();
            spielfenster.erzeugen();
            spiel.setSpielstatus(true);
            spiel.karteZiehen();
            spielfenster.spielerKarteHinzufügen(spiel.getKartenfarbe(), spiel.getKartenindex(), spiel.getSpielerkartenwert());
            spiel.karteZiehen();
            spielfenster.spielerKarteHinzufügen(spiel.getKartenfarbe(), spiel.getKartenindex(), spiel.getSpielerkartenwert());
        }
        else if(e.getSource() == hauptfenster.getKnopfMultiplayer())
        {
            
        }

        else if(e.getSource() == hauptfenster.getKnopfProfil())
        {
            
        }
        
        else if(e.getSource() == hauptfenster.getKnopfBeenden())
        {
            popupfenster.popupFensterErzeugen(0);
        }
        
        if(spiel.getSpielstatus() == true)
        {
            if(e.getSource() == spielfenster.getKnopfHit())
            {
                spiel.karteZiehen();
                spielfenster.spielerKarteHinzufügen(spiel.getKartenfarbe(), spiel.getKartenindex(), spiel.getSpielerkartenwert());
                if(spiel.gewonnenMitBlackjack() == true)
                {
                    spiel.setSpielstatus(false);
                    popupfenster.popupFensterErzeugen(1);
                }
                if(spiel.verlorenWegenUeberzogen() == true)
                {
                    spiel.setSpielstatus(false);
                    popupfenster.popupFensterErzeugen(2);
                }
            }
            else if(e.getSource() == spielfenster.getKnopfStand())
            {
                spielfenster.dealerKarteHinzufügen(1,1,1);
                if(spiel.gewonnenMitDealerUeberzogen() == true)
                {
                    spiel.setSpielstatus(false);
                    popupfenster.popupFensterErzeugen(3);
                }
                if(spiel.gewonnenMitAugenzahl() == true)
                {
                    spiel.setSpielstatus(false);
                    popupfenster.popupFensterErzeugen(4);
                }
                if(spiel.verlorenWegenAugenzahl() == true)
                {
                    spiel.setSpielstatus(false);
                    popupfenster.popupFensterErzeugen(5);
                }
            }    
        }
        
        if(e.getSource() == spielfenster.getKnopfBeenden())
        {
            popupfenster.popupFensterErzeugen(0);
        }
        
        if(e.getSource() == popupfenster.getKnopfJa())
        {
            //hauptfenster.erzeugen();
            //spielfenster.kartenEntfernen();
            spielfenster.schließen();
            //spiel.remake();
            new GraphicManager();
            popupfenster.closePopupFenster();
        }
        else if(e.getSource() == popupfenster.getKnopfNein())
        {
            popupfenster.closePopupFenster();
        }
    }
}
