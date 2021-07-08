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

public class SpielFenster extends JFrame
{
    private JFrame frame;
    private ImageIcon dealertischIcon, karteIcon, knopfHitIcon, knopfStandIcon, knopfBeendenIcon;
    private JButton knopfHit, knopfStand, knopfBeenden;
    private BackgroundImagePanel mainPanel;
    
    /**
     * Konstruktor der Klasse SpielFenster
     */
    public SpielFenster() 
    {
        super("Blackjack");
        frame = new JFrame();
        
        knopfHitIcon = new ImageIcon(getClass().getResource("\\res\\knopfHit.jpg"));
        knopfStandIcon = new ImageIcon(getClass().getResource("\\res\\knopfStand.jpg"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfClose.jpg"));
        
        
        knopfHit = new JButton(knopfHitIcon);
        knopfStand = new JButton(knopfStandIcon);
        knopfBeenden = new JButton(knopfBeendenIcon);
        
        mainPanel = new BackgroundImagePanel(new BorderLayout());
    }

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            System.err.println(e);
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                new SpielFenster();
            }
        });
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
    
        JPanel northcenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northcenterPanel.setOpaque(false);
        northcenterPanel.add(erzeugeKartenwertPane(northcenterPanel.isOpaque()));
        northcenterPanel.add(erzeugeKartenPanel());
        northcenterPanel.add(erzeugeKartenPanel());
        
        JPanel southcenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southcenterPanel.setOpaque(false);
        southcenterPanel.add(erzeugeKartenwertPane(southcenterPanel.isOpaque()));
        southcenterPanel.add(erzeugeKartenPanel());
        southcenterPanel.add(erzeugeKartenPanel());
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false); //entscheidet, ob das Button-Panel durchsichtig sein soll
        centerPanel.add(northcenterPanel, BorderLayout.CENTER);
        centerPanel.add(southcenterPanel, BorderLayout.SOUTH);
        
        mainPanel.add(northcenterPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        return mainPanel;
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
        
       
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        return mainPanel;
    }
    
    public JPanel erzeugeKnoepfePanel(boolean opaque)
    {
        JPanel knoepfePanel = new JPanel(new GridLayout(1, 0, 5, 5));
        knoepfePanel.setOpaque(opaque);
        knoepfePanel.add(knopfHit);
        knoepfePanel.add(knopfStand);
        //Ereignisverarbeitung fehlt!
        return knoepfePanel;
    }
    
    public JPanel erzeugeKartenPanel()
    {
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResource("\\res\\karten\\1-1.png"));
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
    
    public JTextPane erzeugeKartenwertPane(boolean opaque)
    {
        JTextPane kartenwertPane = new JTextPane();
        kartenwertPane.setText("22");
        kartenwertPane.setOpaque(opaque);
        return kartenwertPane;
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
