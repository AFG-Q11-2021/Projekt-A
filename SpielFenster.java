/**
 * Beschreiben Sie hier die Klasse SpielFenster.
 * 
 * @author (Rafael Marsmann, Paul Görner) 
 * @version (05.07.2021)
 */

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.imageio.ImageIO;
import java.io.IOException;

import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Graphics;

public class SpielFenster extends JPanel
{
    private ImageIcon dealertischIcon, karteIcon, knopfHitIcon, knopfStandIcon, knopfBeendenIcon;
    private JPanel knoepfe, karten;
    private JButton knopfHit, knopfStand, knopfBeenden;
    
    public JTextArea textleiste;
    private JScrollPane scrollTextleiste;
    /**
     * Konstruktor der Klasse SpielFenster
     */
    public SpielFenster() 
    {
        dealertischIcon = new ImageIcon(getClass().getResource("\\res\\dealertisch.png"));
        
        knopfHitIcon = new ImageIcon(getClass().getResource("\\res\\knopfHit.png"));
        knopfStandIcon = new ImageIcon(getClass().getResource("\\res\\knopfStand.png"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfBeenden.png"));
        
        textleiste = new JTextArea();
        
        knopfHit = new JButton();
        knopfStand = new JButton();
        knopfBeenden = new JButton();
        
        
        
        knoepfe = new JPanel();
        karten = new JPanel();
    }
    
    /**
     * Methode paint erzeugt das Hintergrundbild
     */
    public void paint(Graphics g){
        dealertischIcon.paintIcon(this, g, 0, 0);
        
        
    }
    
    public JScrollPane textErzeugen(){
        scrollTextleiste = new JScrollPane(textleiste);
        scrollTextleiste.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollTextleiste;
    }
    
    public JPanel bildErzeugen(int farbe, int index)
    {
        karten.add(new JLabel(zeigeImage(farbe, index)));
        
        return karten;
    }
    
    public JPanel knoepfeErzeugen()
    {
        knopfHit.setIcon(knopfHitIcon);
        knopfHit.setFont(new Font("Arial", Font.PLAIN, 12));

        knopfStand.setIcon(knopfStandIcon);
        knopfStand.setFont(new Font("Arial", Font.PLAIN, 12));
        
        knopfBeenden.setIcon(knopfBeendenIcon);
        knopfBeenden.setFont(new Font("Arial", Font.PLAIN, 12));     
        
        knoepfe.add(knopfHit);
        knoepfe.add(knopfStand);
        knoepfe.add(knopfBeenden);
        
        return knoepfe;
    }
    
    public void karteErzeugen(int farbe, int index, int kartenanzahl)
    {
    }
    
    
    private ImageIcon zeigeImage(int farbe, int index){
        BufferedImage img = null;
        try {
           img = ImageIO.read(getClass().getResource("\\res\\karten\\" + farbe + "-" + index + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon(img);
    }
    
    public JButton getKnopfHit()
    {
        return knopfHit;
    }

    public JButton getKnopfStand()
    {
        return knopfStand;
    }
}
