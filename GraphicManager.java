/**
 * Beschreiben Sie hier die Klasse SpielFenster.
 * 
 * @author (Paul Görner, Rafael Marsmann)
 * @version (04.07.2021)
 */
import java.awt.event.ActionListener;
import java.awt.event.*;

public class GraphicManager implements ActionListener
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private SpielFenster spielfenster;
    private HauptFenster hauptfenster;
    private PopupFenster popupfenster;
    private SonstigeFenster regelnfenster, creditsfenster;
    
    private Spiel spiel;

    /**
     * Konstruktor für Objekte der Klasse GraphicManager
     */
    public GraphicManager()
    {
        spiel = new Spiel();
        
        spielfenster = new SpielFenster();
        hauptfenster = new HauptFenster();
        popupfenster = new PopupFenster();
        regelnfenster = new SonstigeFenster();
        creditsfenster = new SonstigeFenster();
        
        hauptfenster.getKnopfSingleplayer().addActionListener(this);
        hauptfenster.getKnopfMultiplayer().addActionListener(this);
        hauptfenster.getKnopfCredits().addActionListener(this);
        hauptfenster.getKnopfRegeln().addActionListener(this);
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

        else if(e.getSource() == hauptfenster.getKnopfRegeln())
        {
            regelnfenster.erzeugen(1);
        }
        else if(e.getSource() == hauptfenster.getKnopfCredits())
        {
            creditsfenster.erzeugen(2);
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
                    popupfenster.erzeugen(1);
                }
                if(spiel.verlorenWegenUeberzogen() == true)
                {
                    popupfenster.erzeugen(2);
                }
            }
            else if(e.getSource() == spielfenster.getKnopfStand())
            {
                while(17 > spiel.getDealerkartenwert()){
                    spiel.dealerZiehtKarte();
                    spielfenster.dealerKarteHinzufügen(spiel.getDealerKartenfarbe(),spiel.getDealerKartenindex(),spiel.getDealerkartenwert());
                }
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
                if(spiel.verlorenWegenDealerBlackjack() == true)
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
        else if(spiel.getSpielstatus() == false)
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
}
