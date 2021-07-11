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
     * Beobachtet, ob bestimmte Knöpfe auf Haupt-, Spiel- oder PopupFenster gedrückt werden.
     */
    public void actionPerformed(ActionEvent e)
    {   
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
            popupfenster.erzeugen(0);
        }
        
        if(spiel.getSpielstatus() == true)
        {
            if(e.getSource() == spielfenster.getKnopfHit())
            {
                spiel.spielerZiehtKarte();
                spielfenster.spielerKarteHinzufügen(spiel.getSpielerKartenfarbe(), spiel.getSpielerKartenindex(), spiel.getSpielerkartenwert());
                if(spiel.gewonnenMitBlackjack() == true)
                {
                    spiel.setSpielstatus(false);
                    popupfenster.erzeugen(1);
                }
                if(spiel.verlorenWegenUeberzogen() == true)
                {
                    spiel.setSpielstatus(false);
                    popupfenster.erzeugen(2);
                }
            }
            else if(e.getSource() == spielfenster.getKnopfStand())
            {
                while(17 > spiel.getDealerkartenwert()){
                    spiel.dealerZiehtKarte();
                    spielfenster.dealerKarteHinzufügen(spiel.getDealerKartenfarbe(),spiel.getDealerKartenindex(),spiel.getDealerkartenwert());
                }
                spiel.setSpielstatus(false);
                if(spiel.gewonnenMitDealerUeberzogen() == true)
                {
                    popupfenster.erzeugen(3);
                }
                if(spiel.gewonnenMitAugenzahl() == true)
                {
                    popupfenster.erzeugen(4);
                }
                if(spiel.verlorenWegenAugenzahl() == true)
                {
                    popupfenster.erzeugen(5);
                }
                if(spiel.verlorenWegenGleicherAugenzahl() == true)
                {
                    popupfenster.erzeugen(5);
                }
            }
            if(e.getSource() == popupfenster.getKnopfJa())
            {
                spielfenster.schließen();
                new GraphicManager();
                popupfenster.schließen();
            }
            else if(e.getSource() == popupfenster.getKnopfNein())
            {
                popupfenster.schließen();
            }
        }
        else
        {
            if(e.getSource() == popupfenster.getKnopfJa())
            {
                hauptfenster.schließen();
                popupfenster.schließen();
            }
            else if(e.getSource() == popupfenster.getKnopfNein())
            {
                popupfenster.schließen();
            }
        }
        
        if(e.getSource() == spielfenster.getKnopfBeenden())
        {
            popupfenster.erzeugen(0);
        }
    }
    /**
     * Lässt den Thread eine bestimmte Zeit pausieren.
     * 
     * @param  millis - Gibt an wie viele Millisekunden der Thread pausiert wird.
     */
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
