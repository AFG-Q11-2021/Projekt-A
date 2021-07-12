/**
 * Erzeugt das Spielfenster mit Hintergrund und Knöpfen.
 * Verwalten das Hinzufügen und Entfernen der Karten.
 * 
 * @author (Rafael Marsmann, Paul Görner) 
 * @version (05.07.2021)
 */

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SpielFenster
{
    private JFrame frame;
    private ImageIcon dealertischIcon, karteIcon, knopfHitIcon, knopfStandIcon, knopfBeendenIcon;
    private JButton knopfHit, knopfStand, knopfBeenden;
    private JPanel northcenterPanel, southcenterPanel;
    private JTextPane spielerKartenwertPane, dealerKartenwertPane;
    private BackgroundImagePanel mainPanel;
    
    /**
     * Konstruktor der Klasse SpielFenster
     */
    public SpielFenster() 
    {
        frame = new JFrame();
        
        knopfHitIcon = new ImageIcon(getClass().getResource("\\res\\knopfHit.jpg"));
        knopfStandIcon = new ImageIcon(getClass().getResource("\\res\\knopfStand.jpg"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfClose.jpg"));
        
        
        knopfHit = new JButton(knopfHitIcon);
        knopfStand = new JButton(knopfStandIcon);
        knopfBeenden = new JButton(knopfBeendenIcon);
        
        northcenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southcenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        spielerKartenwertPane = new JTextPane();
        dealerKartenwertPane = new JTextPane();
        
        mainPanel = new BackgroundImagePanel(new BorderLayout());
    }
    
    /**
     * Erzeugt das Spielfenster.
     */
    public void erzeugen()
    {
        frame.setName("Blackjack");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        
        frame.add(erzeugeHintergrundPanel());
        frame.add(erzeugeKartenLayout());
        
        frame.setVisible(true);
    }
    
    /**
     * Schließt das Spielfenster.
     */
    public void schließen()
    {
        frame.dispose();
    }
    
    /**
     * Fügt Spielerkarte mit entsprechenden werden ein.
     * 
     * @param farbe - Gibt die Farbe der einzufügenden Karte mit.
     * @param index - Gibt den Index der einzufügenden Karte mit.
     * @param kartenwert - Gibt den Kartenwert für das JTextPane an.
     */
    public void spielerKarteHinzufügen(int farbe, int index, int kartenwert)
    {
        updateSpielerKartenwertPane(kartenwert);
        southcenterPanel.add(erzeugeKartenPanel(farbe, index));
        southcenterPanel.revalidate();
    }
    
    /**
     * Fügt Dealerkarte mit entsprechenden werden ein.
     * 
     * @param farbe - Gibt die Farbe der einzufügenden Karte mit.
     * @param index - Gibt den Index der einzufügenden Karte mit.
     * @param kartenwert - Gibt den Kartenwert für das JTextPane an.
     */
    public void dealerKarteHinzufügen(int farbe, int index, int kartenwert)
    {
        updateDealerKartenwertPane(kartenwert);
        northcenterPanel.add(erzeugeKartenPanel(farbe, index));
        northcenterPanel.revalidate();
    }
    
    /**
     * Entfernt alle Karten auf dem Layout.
     */
    public void kartenEntfernen()
    {
        northcenterPanel.removeAll();
        southcenterPanel.removeAll();
        northcenterPanel.revalidate();
    }
    
    /**
     * Erzeugt ein Panel mit dem Layout, auf welchem die Karten später eingefügt werden.
     * 
     * @return - das erzeugte Panel
     */
    public JPanel erzeugeKartenLayout()
    {
        northcenterPanel.setOpaque(false);
        northcenterPanel.add(erzeugeDealerKartenwertPane());
        
        southcenterPanel.setOpaque(false);
        southcenterPanel.add(erzeugeSpielerKartenwertPane());
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false); //entscheidet, ob das Button-Panel durchsichtig sein soll
        centerPanel.add(northcenterPanel, BorderLayout.NORTH);
        centerPanel.add(southcenterPanel, BorderLayout.SOUTH);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        return mainPanel;
    }
    
    /**
     * Erzeugt ein Panel mit Hintergrund und den Knöpfen für das Spielfenster.
     * 
     * @return - das erzeugte Panel
     */
    private JPanel erzeugeHintergrundPanel()
    {   
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResource("\\res\\dealertisch.png"));
        } catch(IOException ioe) {
            JOptionPane.showMessageDialog(null,
            "Das Hintergrundbild konnte nicht geladen werden!\n" + ioe.getLocalizedMessage(),
            ioe.getClass().getName(),
            JOptionPane.WARNING_MESSAGE);
        }
        mainPanel.setImage(image); //hier kann man einstellen, ob das Bild im Original oder eingepasst ausgegeben werden soll (true/false)
        
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setOpaque(false); //entscheidet, ob das Button-Panel durchsichtig sein soll
        southPanel.add(erzeugeKnoepfePanel(southPanel.isOpaque()));
        
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        northPanel.setOpaque(false); //entscheidet, ob das Button-Panel durchsichtig sein soll
        northPanel.add(erzeugeBeendenPanel(northPanel.isOpaque()));
        
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        return mainPanel;
    }
    
    /**
     * Erzeugt ein JPanel für den Knopf "Beenden".
     * 
     * @param  opaque - Legt fest, ob das Panel durchsichtig sein soll.
     * @return - das erzeugte Panel
     */
    public JPanel erzeugeBeendenPanel(boolean opaque)
    {
        JPanel beendenPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        beendenPanel.setOpaque(opaque);
        beendenPanel.add(knopfBeenden);
        //Ereignisverarbeitung fehlt!
        return beendenPanel;
    }
    
    /**
     * Erzeugt ein JPanel für die Knöpfe "Hit" und "Stand"
     * 
     * @param  opaque - Legt fest, ob das Panel durchsichtig sein soll.
     * @return - das erzeugte JPanel
     */
    public JPanel erzeugeKnoepfePanel(boolean opaque)
    {
        knopfHit.setOpaque(true);
        knopfHit.setPreferredSize(new Dimension(180,50));
        knopfStand.setOpaque(true);
        knopfStand.setPreferredSize(new Dimension(180,50));
        knopfBeenden.setOpaque(true);
        knopfBeenden.setPreferredSize(new Dimension(180,50));
        
        JPanel knoepfePanel = new JPanel(new GridLayout(1, 0, 5, 5));
        knoepfePanel.setOpaque(opaque);
        knoepfePanel.add(knopfHit);
        knoepfePanel.add(knopfStand);
        
        return knoepfePanel;
    }
    
    /**
     * Erzeugt das JPanel für die eingefügten Karten
     * 
     * @param farbe - Gibt die Farbe der einzufügenden Karte mit.
     * @param index - Gibt den Index der einzufügenden Karte mit.
     * @return - das erzeugte JPanel
     */
    public JPanel erzeugeKartenPanel(int farbe, int index)
    {
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResource("\\res\\karten\\"+farbe+"-"+index+".png"));
        } catch(IOException ioe) {
            JOptionPane.showMessageDialog(null,
            "Das Bild konnte nicht geladen werden!\n" + ioe.getLocalizedMessage(),
            ioe.getClass().getName(),
            JOptionPane.WARNING_MESSAGE);
        }
        
        BackgroundImagePanel kartenPanel = new BackgroundImagePanel(new GridLayout(0, 5, 5, 5));
        kartenPanel.setOpaque(true);
        kartenPanel.setImage(image);
        
        return kartenPanel;
    }
    
    public JTextPane erzeugeSpielerKartenwertPane()
    {
        spielerKartenwertPane.setText("0");
        spielerKartenwertPane.setOpaque(true);
        return spielerKartenwertPane;
    }
    
    public JTextPane erzeugeDealerKartenwertPane()
    {
        dealerKartenwertPane.setText("0");
        dealerKartenwertPane.setOpaque(true);
        return dealerKartenwertPane;
    }
    
    public void updateSpielerKartenwertPane(int kartenwert)
    {
        spielerKartenwertPane.setText(Integer.toString(kartenwert));
    }
    
    public void updateDealerKartenwertPane(int kartenwert)
    {
        dealerKartenwertPane.setText(Integer.toString(kartenwert));
    }
    
    public JButton getKnopfHit()
    {
        return knopfHit;
    }

    public JButton getKnopfStand()
    {
        return knopfStand;
    }
    
    public JButton getKnopfBeenden()
    {
        return knopfBeenden;
    }
}
