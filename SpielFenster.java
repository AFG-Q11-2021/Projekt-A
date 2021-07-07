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
    
    /**
     * Konstruktor der Klasse SpielFenster
     */
    public SpielFenster() 
    {
        super("Blackjack");
        frame = new JFrame();
        
        knopfHitIcon = new ImageIcon(getClass().getResource("\\res\\knopfHit.png"));
        knopfStandIcon = new ImageIcon(getClass().getResource("\\res\\knopfStand.png"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfBeenden.png"));
        
        
        knopfHit = new JButton(knopfHitIcon);
        knopfStand = new JButton(knopfStandIcon);
        knopfBeenden = new JButton(knopfBeendenIcon);
    }
    
    public void erzeugen()
    {
        frame.setName("Blackjack");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        
        frame.add(erzeugeHintergrundPanel());
        frame.setVisible(true);
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

        BackgroundImagePanel mainPanel = new BackgroundImagePanel(new BorderLayout());
        mainPanel.setImage(image); //hier kann man einstellen, ob das Bild im Original oder eingepasst ausgegeben werden soll (true/false)

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setOpaque(false); //entscheidet, ob das Button-Panel durchsichtig sein soll
        southPanel.add(erzeugeKnoepfePanel(southPanel.isOpaque()));

        mainPanel.add(southPanel, BorderLayout.SOUTH);
        return mainPanel;
    }
    
    public JButton erzeugeKnopfHit()
    {
        return knopfHit;
    }
    
    public JButton erzeugeKnopfStand()
    {
        return knopfHit;
    }
    
    public JButton erzeugeKnopfBeenden()
    {
        return knopfHit;
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
    
    public void karteErzeugen(int farbe, int index, int kartenanzahl)
    {
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
