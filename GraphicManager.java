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
     * Methode die beobachtet, ob bestimmte Knöpfe auf Haupt-, Spiel- oder PopupFenster gedrückt wurden.
     * 
     * @param  e - 
     */
    public void actionPerformed(ActionEvent e)
    {   
        /**
         * 
         */
        if(e.getSource() == hauptfenster.getKnopfSingleplayer())
        {
            hauptfenster.schließen();
            spielfenster.erzeugen();
            spiel.setSpielstatus(true);
            spiel.spielerZiehtKarte();
            spielfenster.spielerKarteHinzufügen(spiel.getSpielerKartenfarbe(), spiel.getSpielerKartenindex(), spiel.getSpielerkartenwert());
            spiel.spielerZiehtKarte();
            spielfenster.spielerKarteHinzufügen(spiel.getSpielerKartenfarbe(), spiel.getSpielerKartenindex(), spiel.getSpielerkartenwert());
            spiel.dealerZiehtKarte();
            spielfenster.dealerKarteHinzufügen(spiel.getDealerKartenfarbe(), spiel.getDealerKartenindex(), spiel.getDealerkartenwert());
            spiel.dealerZiehtKarte();
            spielfenster.dealerKarteHinzufügen(spiel.getDealerKartenfarbe(), spiel.getDealerKartenindex(), spiel.getDealerkartenwert());
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
                spiel.spielerZiehtKarte();
                spielfenster.spielerKarteHinzufügen(spiel.getSpielerKartenfarbe(), spiel.getSpielerKartenindex(), spiel.getSpielerkartenwert());
                if(spiel.gewonnenMitBlackjack() == true)
                {
                    sleep(3000);
                    spiel.setSpielstatus(false);
                    popupfenster.popupFensterErzeugen(1);
                }
                if(spiel.verlorenWegenUeberzogen() == true)
                {
                    sleep(3000);
                    spiel.setSpielstatus(false);
                    popupfenster.popupFensterErzeugen(2);
                }
            }
            else if(e.getSource() == spielfenster.getKnopfStand())
            {
                spiel.setSpielstatus(false);
                while(17 > spiel.getDealerkartenwert()){
                    sleep(2000);
                    spiel.dealerZiehtKarte();
                    spielfenster.dealerKarteHinzufügen(spiel.getDealerKartenfarbe(),spiel.getDealerKartenindex(),spiel.getDealerkartenwert());
                }
                if(spiel.gewonnenMitDealerUeberzogen() == true)
                {
                    sleep(3000);
                    popupfenster.popupFensterErzeugen(3);
                }
                if(spiel.gewonnenMitAugenzahl() == true)
                {
                    sleep(3000);
                    popupfenster.popupFensterErzeugen(4);
                }
                if(spiel.verlorenWegenAugenzahl() == true)
                {
                    sleep(3000);
                    popupfenster.popupFensterErzeugen(5);
                }
                if(spiel.verlorenWegenGleicherAugenzahl())
                {
                    sleep(3000);
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
    /**
     * Lässt den Thread eine bestimmte Zeit pausieren.
     * 
     * @param  millis    Gibt and, wie viele Millisekunden der Thread pausiert wird.
     * @return        die Summe aus x und y
     */
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
