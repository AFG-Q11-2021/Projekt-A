/**
 * Beschreiben Sie hier die Klasse SpielFenster.
 * 
 * @author (Paul Görner)
 * @version (04.07.2021)
 */

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;

public class SpielFenster2 extends JPanel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int width, height;
    private ImageIcon dealertischIcon, karteIcon, knopfHitIcon, knopfStandIcon, knopfBeendenIcon;
    private JPanel knoepfe, dealertisch;
    private JButton knopfHit, knopfStand, knopfBeenden;
    /**
     * Konstruktor für Objekte der Klasse SpielFenster
     */
    public SpielFenster2()
    {
        dealertischIcon = new ImageIcon(getClass().getResource("\\res\\dealertisch.png"));
        knopfHitIcon = new ImageIcon(getClass().getResource("\\res\\knopfHit.png"));
        knopfStandIcon = new ImageIcon(getClass().getResource("\\res\\knopfStand.png"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfBeenden.png"));
        
        knoepfe = new JPanel();
        dealertisch = new JPanel();
        
        
    }
    
    public void paint(Graphics g){
        dealertischIcon.paintIcon(this, g, 0, 0);
    }
    
    public JPanel knoepfeErzeugen()
    {
        knopfHit = new JButton();
        knopfHit.setIcon(knopfHitIcon);
        knopfHit.setFont(new Font("Arial", Font.PLAIN, 12));

        knopfStand = new JButton();
        knopfHit.setIcon(knopfHitIcon);
        knopfStand.setFont(new Font("Arial", Font.PLAIN, 12));
        
        knopfBeenden = new JButton ();
        knopfHit.setIcon(knopfHitIcon);
        knopfBeenden.setFont(new Font("Arial", Font.PLAIN, 12));     
        
        knoepfe.add(knopfHit);
        knoepfe.add(knopfStand);
        knoepfe.add(knopfBeenden);
        
        return knoepfe;
    }
    
    public JPanel dealertischErzeugen(){
        return dealertisch;
    }
}
