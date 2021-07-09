/**
 * Beschreiben Sie hier die Klasse SpielFenster.
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
    private JTextPane kartenwertPane;
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
        
        kartenwertPane = new JTextPane();
        
        mainPanel = new BackgroundImagePanel(new BorderLayout());
    }
    
    public void erzeugen()
    {
        frame.setName("Blackjack");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        
        frame.add(erzeugeHintergrundPanel());
        frame.add(erzeugeKartenLayout());
        
        frame.setVisible(true);
    }
    
    public JPanel erzeugeKartenLayout()
    {
        northcenterPanel.setOpaque(false);
        northcenterPanel.add(erzeugeKartenwertPane());
        
        southcenterPanel.setOpaque(false);
        southcenterPanel.add(erzeugeKartenwertPane());
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false); //entscheidet, ob das Button-Panel durchsichtig sein soll
        centerPanel.add(northcenterPanel, BorderLayout.NORTH);
        centerPanel.add(southcenterPanel, BorderLayout.SOUTH);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        return mainPanel;
    }
    
    public void dealerKarteHinzufügen(int farbe, int index, int kartenwert)
    {
        updateKartenwertPane(kartenwert);
        northcenterPanel.add(erzeugeKartenPanel(farbe, index));
        northcenterPanel.revalidate();
    }
    
    public void spielerKarteHinzufügen(int farbe, int index, int kartenwert)
    {
        updateKartenwertPane(kartenwert);
        southcenterPanel.add(erzeugeKartenPanel(farbe, index));
        southcenterPanel.revalidate();
    }
    
    public void kartenEntfernen()
    {
        northcenterPanel.removeAll();
        southcenterPanel.removeAll();
        northcenterPanel.revalidate();
    }
    
    public void schließen()
    {
        frame.dispose();
    }
    
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
    
    public JPanel erzeugeBeendenPanel(boolean opaque)
    {
        JPanel beendenPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        beendenPanel.setOpaque(opaque);
        beendenPanel.add(knopfBeenden);
        //Ereignisverarbeitung fehlt!
        return beendenPanel;
    }
    
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
        //Ereignisverarbeitung fehlt!
        return knoepfePanel;
    }
    
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
    
    public JTextPane erzeugeKartenwertPane()
    {
        kartenwertPane.setText("0");
        kartenwertPane.setOpaque(true);
        return kartenwertPane;
    }
    
    public void updateKartenwertPane(int kartenwert)
    {
        kartenwertPane.setText(Integer.toString(kartenwert));
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
